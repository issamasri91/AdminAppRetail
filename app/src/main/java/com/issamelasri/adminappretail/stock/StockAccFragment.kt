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
import kotlinx.android.synthetic.main.fragment_stock_acc.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StockAccFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StockAccFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_stock_acc, container, false)
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
            stock_accessoir_cable.text = it.stockAccessoir.cable.toString()
            stock_carte_memoir.text = it.stockAccessoir.carte.toString()
            char_stock_acc.text = it.stockAccessoir.chargeur.toString()
            ecteur_stock.text = it.stockAccessoir.earphone.toString()
            protection_stock.text = it.stockAccessoir.protection.toString()
            puchet_stock.text = it.stockAccessoir.puchet.toString()
            supportStock.text = it.stockAccessoir.support.toString()
            autre_acc_stock.text = it.stockAccessoir.aurteAcc.toString()
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
         * @return A new instance of fragment StockAccFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StockAccFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}