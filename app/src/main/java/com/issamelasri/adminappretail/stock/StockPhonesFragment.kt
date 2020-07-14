package com.issamelasri.adminappretail.stock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.issamelasri.adminappretail.R
import com.issamelasri.adminappretail.stock.models.*
import kotlinx.android.synthetic.main.fragment_stock_phones.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StockPhonesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StockPhonesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val model: ViewModelStock by viewModels()
    private var stock: StockGlobal = StockGlobal()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
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
        model.fitchClients("elasriisssamgmailcom")
        model.getRealtimeUpdates()
        model.stocks.observe(viewLifecycleOwner, Observer {
            val stockAcc = StockAccessoir()
            val rechaege = RechargeStock()
            val sim = StockSim()
            val phones = StockPhones()
            stock_phones_nokia.text = it.stockPhones.nokia.toString()
            stock_phones_hwaoui.text = it.stockPhones.hwaui.toString()
            stock_phones_logicom.text = it.stockPhones.logicom.toString()
            stock_phones_accent.text = it.stockPhones.accent.toString()
            stock_phones_oppo.text = it.stockPhones.lenovo.toString()
            stock_phones_tecno.text = it.stockPhones.tecno.toString()
            stock_phones_samsung.text = it.stockPhones.samsung.toString()
            stock_phones_autre.text = it.stockPhones.autre.toString()
            it.stockAccessoir = stockAcc
            it.stockPhones = phones
            it.recharge = rechaege
            it.stockSim = sim
            stock.stockAccessoir = stockAcc
            stock.stockPhones = phones
            stock.recharge = rechaege
            stock.stockSim = sim


        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StockPhonesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StockPhonesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}