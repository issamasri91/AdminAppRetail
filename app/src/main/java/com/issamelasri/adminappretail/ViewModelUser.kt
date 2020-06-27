package com.issamelasri.adminappretail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.*

class ViewModelUser : ViewModel() {
    private var dbClients = FirebaseDatabase.getInstance().getReference(LIST_USER)
    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?>
        get() = _result

    private val _clients = MutableLiveData<List<Vendeur>>()
    val clients: LiveData<List<Vendeur>>
        get() = _clients

    private val _client = MutableLiveData<Vendeur>()
    val client: LiveData<Vendeur>
        get() = _client

    private val childEventListener = object : ChildEventListener {
        override fun onCancelled(error: DatabaseError) {}

        override fun onChildMoved(snapshot: DataSnapshot, p1: String?) {}

        override fun onChildChanged(snapshot: DataSnapshot, p1: String?) {
            val client = snapshot.getValue(Vendeur::class.java)
            client?.id = snapshot.key.toString()
            _client.value = client
        }

        override fun onChildAdded(snapshot: DataSnapshot, p1: String?) {
            val client = snapshot.getValue(Vendeur::class.java)
            client?.id = snapshot.key.toString()
            _client.value = client
        }

        override fun onChildRemoved(snapshot: DataSnapshot) {
            val client = snapshot.getValue(Vendeur::class.java)
            client?.id = snapshot.key.toString()
            client?.isDeleted = true
            _client.value = client
        }
    }

    fun fitchClients() {
        dbClients.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(erreur: DatabaseError) {
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val clients = mutableListOf<Vendeur>()
                    for (clientSnapshot in snapshot.children) {
                        val client = clientSnapshot.getValue(Vendeur::class.java)
                        client?.id = clientSnapshot.key.toString()
                        client?.let { clients.add(it) }
                    }
                    _clients.value = clients
                }
            }

        })
    }
    fun updateClient(client: Vendeur) {
        dbClients.child(client.id).setValue(client)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    _result.value = null
                } else {
                    _result.value = it.exception
                }
            }
    }
    fun deleteAuthor(author: Vendeur) {
        dbClients.child(author.id).setValue(null)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    _result.value = null
                } else {
                    _result.value = it.exception
                }
            }
    }
    fun addClient(client: Vendeur) {
        dbClients = FirebaseDatabase.getInstance().getReference(LIST_USER)
        client.id = dbClients.push().key.toString()
        dbClients.child(client.id).setValue(client)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    _result.value = null
                } else {
                    _result.value = it.exception
                }
            }
    }
    override fun onCleared() {
        super.onCleared()
        dbClients.removeEventListener(childEventListener)
    }

}