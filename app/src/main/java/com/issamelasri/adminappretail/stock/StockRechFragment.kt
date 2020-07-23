package com.issamelasri.adminappretail.stock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.issamelasri.adminappretail.R
import kotlinx.android.synthetic.main.fragment_stock_rech.*


class StockRechFragment : Fragment() {
    //inwi
    var inwi5 = "0"
    var inwi10 = "0"
    var inwi20 = "0"
    var inwi50 = "0"
    var inwi100 = "0"
    var inwi500 = "0"
    var inwi1000 = "0"
    var inwi5000 = "0"

    //orange
    var orange5 = "0"
    var orange10 = "0"
    var orange20 = "0"
    var orange25 = "0"
    var orange50 = "0"
    var orange100 = "0"
    var orange500 = "0"

    //iam
    var iam_5 = "0"
    var iam_10 = "0"
    var iam_20 = "0"
    var iam_50 = "0"
    var iam_100 = "0"
    var iam_500 = "0"
    var iam_1000 = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            //inwi
            inwi5 = savedInstanceState.get("inwi5").toString()
            inwi10 = savedInstanceState.get("inwi10").toString()
            inwi20 = savedInstanceState.get("inwi20").toString()
            inwi50 = savedInstanceState.get("inwi50").toString()
            inwi100 = savedInstanceState.get("inwi100").toString()
            inwi500 = savedInstanceState.get("inwi500").toString()
            inwi1000 = savedInstanceState.get("inwi1000").toString()
            inwi5000 = savedInstanceState.get("inwi5000").toString()
            //orange
            orange5 = savedInstanceState.get("orange5").toString()
            orange10 = savedInstanceState.get("orange10").toString()
            orange20 = savedInstanceState.get("orange20").toString()
            orange25 = savedInstanceState.get("orange25").toString()
            orange50 = savedInstanceState.get("orange50").toString()
            orange100 = savedInstanceState.get("orange100").toString()
            orange500 = savedInstanceState.get("orange500").toString()
            //iam
            iam_5 = savedInstanceState.get("iam_5").toString()
            iam_10 = savedInstanceState.get("iam_10").toString()
            iam_20 = savedInstanceState.get("iam_20").toString()
            iam_50 = savedInstanceState.get("iam_50").toString()
            iam_500 = savedInstanceState.get("iam_500").toString()
            iam_1000 = savedInstanceState.get("iam_1000").toString()


        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //inwi
        outState.putString("inwi5", inwi_5.text.toString())
        outState.putString("inwi10", inwi_10.text.toString())
        outState.putString("inwi20", inwi_20.text.toString())
        outState.putString("inwi50", inwi_50.text.toString())
        outState.putString("inwi100", inwi_100.text.toString())
        outState.putString("inwi500", inwi_500.text.toString())
        outState.putString("inwi1000", inwi_1000.text.toString())
        outState.putString("inwi5000", inwi_5000.text.toString())
        //orange
        outState.putString("orange5", orange_5.text.toString())
        outState.putString("orange10", orange_10.text.toString())
        outState.putString("orange20", orange_20.text.toString())
        outState.putString("orange25", orange_25.text.toString())
        outState.putString("orange50", orange_50.text.toString())
        outState.putString("orange100", orange_100.text.toString())
        outState.putString("orange500", orange_500.text.toString())
        //iam
        outState.putString("iam_5", iam5.text.toString())
        outState.putString("iam_10", iam10.text.toString())
        outState.putString("iam_20", iam20.text.toString())
        outState.putString("iam_50", iam50.text.toString())
        outState.putString("iam_100", iam100.text.toString())
        outState.putString("iam_500", iam500.text.toString())
        outState.putString("iam_1000", iam1000.text.toString())
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
        //inwi
        inwi_5.text = inwi5
        inwi_10.text = inwi10
        inwi_20.text = inwi20
        inwi_50.text = inwi50
        inwi_100.text = inwi100
        inwi_500.text = inwi500
        inwi_1000.text = inwi1000
        inwi_5000.text = inwi5000
        //orange
        orange_5.text = orange5
        orange_10.text = orange10
        orange_20.text = orange20
        orange_25.text = orange25
        orange_50.text = orange50
        orange_100.text = orange100
        orange_500.text = orange500
        //iam
        iam5.text = iam_5
        iam10.text = iam_10
        iam20.text = iam_20
        iam50.text = iam_50
        iam100.text = iam_100
        iam500.text = iam_500
        iam1000.text = iam_1000
    }


}