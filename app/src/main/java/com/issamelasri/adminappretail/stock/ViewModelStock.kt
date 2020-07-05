package com.issamelasri.adminappretail.stock

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.issamelasri.adminappretail.STOCK_NODE
import com.issamelasri.adminappretail.stock.models.StockGlobal

class ViewModelStock : ViewModel() {

    private var dbClients = FirebaseDatabase.getInstance().getReference(STOCK_NODE)
    lateinit var auth: FirebaseAuth

    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?>
        get() = _result
    private val _stocks = MutableLiveData<StockGlobal>()
    val stocks: LiveData<StockGlobal>
        get() = _stocks
}


