package com.issamelasri.adminappretail.stock

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.issamelasri.adminappretail.STOCK_CHILD
import com.issamelasri.adminappretail.STOCK_NODE
import com.issamelasri.adminappretail.stock.models.StockGlobal

class ViewModelStock : ViewModel() {

    private var dbClients = FirebaseDatabase.getInstance().getReference(STOCK_NODE)
    var auth: FirebaseAuth = FirebaseAuth.getInstance()


    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?>
        get() = _result
    private val _stocks = MutableLiveData<StockGlobal>()
    val stocks: LiveData<StockGlobal>
        get() = _stocks

    private val childEventListener = object : ChildEventListener {
        override fun onCancelled(error: DatabaseError) {}
        override fun onChildMoved(snapshot: DataSnapshot, p1: String?) {}
        override fun onChildChanged(snapshot: DataSnapshot, p1: String?) {
            val stockVendeur = snapshot.getValue(StockGlobal::class.java)
            stockVendeur?.id = snapshot.key.toString()
            _stocks.value = stockVendeur
        }

        override fun onChildAdded(snapshot: DataSnapshot, p1: String?) {
            val stockVendeur = snapshot.getValue(StockGlobal::class.java)
            stockVendeur?.id = snapshot.key.toString()
            _stocks.value = stockVendeur
        }

        override fun onChildRemoved(snapshot: DataSnapshot) {
            val stockVendeur = snapshot.getValue(StockGlobal::class.java)
            stockVendeur?.id = snapshot.key.toString()
            stockVendeur?.isDeleted = true
            _stocks.value = stockVendeur
        }
    }

    fun getRealtimeUpdates(email: String) {
        dbClients.child(email).addChildEventListener(childEventListener)
        Log.d("up", email)
    }

    fun fitchClients(email: String) {
        dbClients.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(erreur: DatabaseError) {
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var stocks = StockGlobal()
                    for (clientSnapshot in snapshot.children) {
                        val client = clientSnapshot.getValue(StockGlobal::class.java)
                        client?.id = clientSnapshot.key.toString()
                        Log.d("id", "the id is ${client?.id}")
                        if (client?.id == email) {
                            Log.d(STOCK_CHILD, email)
                            client.let {
                                stocks = it
                                Log.d(STOCK_CHILD, it.stockAccessoir.cable.toString())

                                _stocks.value = stocks
                            }
                        }
                    }
                }
            }
        })
    }

    fun addStock(stock: StockGlobal,email: String) {
        dbClients = FirebaseDatabase.getInstance().getReference(STOCK_NODE)
       email.let { it ->
            dbClients.child(it).setValue(stock)
                .addOnCompleteListener {
                    if (
                        it.isSuccessful) {
                        _result.value = null
                    } else {
                        _result.value = it.exception
                    }
                }
        }
    }

    override fun onCleared() {
        super.onCleared()
        dbClients.removeEventListener(childEventListener)
    }


}


