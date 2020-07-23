package com.issamelasri.adminappretail.stock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.issamelasri.adminappretail.R
import kotlinx.android.synthetic.main.fragment_stock_acc.*

class StockAccFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_stock_acc, container, false)
    }

    var cable = "0"
    var carteMemoir = "0"
    var chargeur = "0"
    var protection = "0"
    var pochet = "0"
    var support = "0"
    var earphone = "0"
    var autre = "0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            cable = savedInstanceState.get("cable").toString()
            carteMemoir = savedInstanceState.get("memoir").toString()
            chargeur = savedInstanceState.get("char").toString()
            earphone = savedInstanceState.get("ear").toString()
            protection = savedInstanceState.get("prot").toString()
            pochet = savedInstanceState.get("poshet").toString()
            support = savedInstanceState.get("supp").toString()
            autre = savedInstanceState.get("autre").toString()

        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        stock_accessoir_cable.text = cable
        stock_carte_memoir.text = carteMemoir
        char_stock_acc.text = chargeur
        ecteur_stock.text = earphone
        protection_stock.text = protection
        puchet_stock.text = pochet
        supportStock.text = support
        autre_acc_stock.text = autre
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("cable", stock_accessoir_cable.text.toString())
        outState.putString("memoir", stock_carte_memoir.text.toString())
        outState.putString("char", char_stock_acc.text.toString())
        outState.putString("ear", ecteur_stock.text.toString())
        outState.putString("prot", protection_stock.text.toString())
        outState.putString("poshet", puchet_stock.text.toString())
        outState.putString("supp", supportStock.text.toString())
        outState.putString("autre", autre_acc_stock.text.toString())

    }
}