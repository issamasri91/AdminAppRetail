package com.issamelasri.adminappretail.stock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.issamelasri.adminappretail.R
import kotlinx.android.synthetic.main.fragment_stock_sim.*

class StockSimFragment : Fragment() {

    var simInwi = "0"
    var simOrange = "0"
    var simIam = "0"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            simInwi = savedInstanceState.get("simInwi").toString()
            simOrange = savedInstanceState.get("simOrange").toString()
            simIam = savedInstanceState.get("simIam").toString()


        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("simInwi", stock_inwi_sim.text.toString())
        outState.putString("simOrange", stock_orange_sim.text.toString())
        outState.putString("simIam", stock_iam_sim.text.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stock_sim, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        stock_inwi_sim.text = simInwi
        stock_orange_sim.text = simOrange
        stock_iam_sim.text = simIam

    }


}