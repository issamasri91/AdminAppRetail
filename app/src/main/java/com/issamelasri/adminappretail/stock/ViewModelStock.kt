package com.issamelasri.adminappretail.stock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.issamelasri.adminappretail.STOCK_NODE
import com.issamelasri.adminappretail.stock.models.StockGlobal

class ViewModelStock : ViewModel() {

    private var dbClients = FirebaseDatabase.getInstance().getReference(STOCK_NODE)
    var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val email = auth.currentUser?.email?.replace("@", "")
        ?.replace(".", "")

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

    fun getRealtimeUpdates() {
        dbClients.addChildEventListener(childEventListener)
    }

    fun fitchClients() {
        dbClients.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(erreur: DatabaseError) {
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val stocks = StockGlobal()
                    for (clientSnapshot in snapshot.children) {
                        val client = clientSnapshot.getValue(StockGlobal::class.java)
                        client?.id = clientSnapshot.key.toString()
                        client?.let {
                            stocks.recharge = it.recharge
                            stocks.stockAccessoir = it.stockAccessoir
                            stocks.stockPhones = it.stockPhones
                            stocks.stockSim = it.stockSim
                        }
                    }
                    _stocks.value = stocks
                }
            }

        })
    }

    fun addStock(stock: StockGlobal) {
        dbClients = FirebaseDatabase.getInstance().getReference(STOCK_NODE)
        this.email?.let { it ->
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

