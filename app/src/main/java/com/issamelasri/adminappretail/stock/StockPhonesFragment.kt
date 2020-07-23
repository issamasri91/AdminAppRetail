package com.issamelasri.adminappretail.stock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.issamelasri.adminappretail.R
import kotlinx.android.synthetic.main.fragment_stock_phones.*

class StockPhonesFragment : Fragment() {

    var nokia = "0"
    var hwaui = "0"
    var logicom = "0"
    var accent = "0"
    var oppo = "0"
    var tecno = "0"
    var samsung = "0"
    var autrePhone = "0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            nokia = savedInstanceState.get("nokia").toString()
            hwaui = savedInstanceState.get("hwaui").toString()
            logicom = savedInstanceState.get("logicom").toString()
            accent = savedInstanceState.get("accent").toString()
            oppo = savedInstanceState.get("oppo").toString()
            tecno = savedInstanceState.get("tecno").toString()
            samsung = savedInstanceState.get("samsung").toString()
            autrePhone = savedInstanceState.get("autrePhone").toString()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stock_phones, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        stock_phones_nokia.text = nokia
        stock_phones_hwaoui.text = hwaui
        stock_phones_logicom.text = logicom
        stock_phones_accent.text = accent
        stock_phones_oppo.text = oppo
        stock_phones_tecno.text = tecno
        stock_phones_samsung.text = samsung
        stock_phones_autre.text = autrePhone
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nokia", stock_phones_nokia.text.toString())
        outState.putString("hwaui", stock_phones_hwaoui.text.toString())
        outState.putString("logicom", stock_phones_logicom.text.toString())
        outState.putString("accent", stock_phones_accent.text.toString())
        outState.putString("oppo", stock_phones_oppo.text.toString())
        outState.putString("tecno", stock_phones_tecno.text.toString())
        outState.putString("samsung", stock_phones_samsung.text.toString())
        outState.putString("autrePhone", stock_phones_autre.text.toString())
    }

}