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
import kotlinx.android.synthetic.main.fragment_stock_rech.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StockRechFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StockRechFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_stock_rech, container, false)
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
            //inwi
            inwi_5.text = it.recharge.inwiscratch5.toString()
            inwi_10.text = it.recharge.inwiscratch10.toString()
            inwi_20.text = it.recharge.inwiscratch20.toString()
            inwi_50.text = it.recharge.inwiscratch50.toString()
            inwi_100.text = it.recharge.inwiscratch100.toString()
            inwi_500.text = it.recharge.inwidealer500.toString()
            inwi_1000.text = it.recharge.inwidealer1000.toString()
            inwi_5000.text = it.recharge.inwidealer5000.toString()
            //orange
            orange_5.text = it.recharge.orangeScratch5.toString()
            orange_10.text = it.recharge.orangeScratch10.toString()
            orange_20.text = it.recharge.orangeScratch20.toString()
            orange_25.text = it.recharge.orangeScratch25.toString()
            orange_50.text = it.recharge.orangeScratch50.toString()
            orange_100.text = it.recharge.orangeScratch100.toString()
            orange_500.text = it.recharge.orangeDealer500.toString()
            //iam
            iam5.text = it.recharge.iamscratch5.toString()
            iam10.text = it.recharge.iamscratch10.toString()
            iam20.text = it.recharge.iamscratch20.toString()
            iam50.text = it.recharge.iamscratch50.toString()
            iam100.text = it.recharge.iamscratch100.toString()
            iam500.text = it.recharge.iamdealer500.toString()
            iam1000.text = it.recharge.iamdealer1000.toString()

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
         * @return A new instance of fragment StockRechFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StockRechFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}