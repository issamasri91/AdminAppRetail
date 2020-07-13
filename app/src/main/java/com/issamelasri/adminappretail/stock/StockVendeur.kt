package com.issamelasri.adminappretail.stock

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.issamelasri.adminappretail.R
import com.issamelasri.adminappretail.STOCK_CHILD
import com.issamelasri.adminappretail.stock.models.*
import com.issamelasri.adminappretail.ui.main.SectionsPagerAdapter
import kotlinx.android.synthetic.main.enter_acc_stock.*
import kotlinx.android.synthetic.main.fragment_stock_acc.*

class StockVendeur : AppCompatActivity() {
    private var stock: StockGlobal = StockGlobal()

    private val model: ViewModelStock by viewModels()
    private var pageActive = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock_vendeur)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val email = if (intent != null) {
            intent.extras?.get(STOCK_CHILD).toString()
        } else {
            return
        }
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    when (tab.position) {
                        0 -> pageActive = 0
                        1 -> pageActive = 1
                        2 -> pageActive = 2
                        3 -> pageActive = 3
                    }
                }
            }
        })

        fab.setOnClickListener {
            val dialog: MaterialDialog = MaterialDialog(this)
                .noAutoDismiss()
            when (pageActive) {
                0 -> {
                    dialog.customView(R.layout.enter_acc_stock)
                }
                1 -> {
                    dialog.customView(R.layout.enter_stock_phones)
                }

            }

            dialog.positiveButton {
                when (pageActive) {
                    0 -> {

                        val cable = dialog.stock_accessoir_cable_editText.text
                        stock_accessoir_cable.text = cable
                        val carteMimoir = dialog.stock_carte_memoir_editText.text
                        stock_carte_memoir.text = carteMimoir
                        val chargeur = dialog.stock_chargeur.text
                        char_stock_acc.text = chargeur
                        val ecuteur = dialog.stock_ecuteur.text
                        ecteur_stock.text = ecuteur
                        val protection = dialog.stock_protection.text
                        protection_stock.text = protection
                        val pochet = dialog.stock_pochet.text
                        puchet_stock.text = pochet
                        val support = dialog.stock_support.text
                        supportStock.text = support
                        val autre = dialog.stock_autre.text
                        autre_acc_stock.text = autre
                        stock.stockAccessoir.cable = cable.toString().toInt()
                        stock.stockAccessoir.carte = carteMimoir.toString().toInt()
                        stock.stockAccessoir.chargeur = chargeur.toString().toInt()
                        stock.stockAccessoir.earphone = ecuteur.toString().toInt()
                        stock.stockAccessoir.protection = protection.toString().toInt()
                        stock.stockAccessoir.puchet = pochet.toString().toInt()
                        stock.stockAccessoir.support = support.toString().toInt()
                        stock.stockAccessoir.aurteAcc = autre.toString().toInt()
                        model.addStock(stock,email)
                        Toast.makeText(applicationContext, "stock change", Toast.LENGTH_LONG).show()
                    }
                    1 -> {

                    }
                    2 -> {
                    }
                    3 -> {
                    }
                }


                dialog.dismiss()
            }
            dialog.negativeButton {
                Toast.makeText(baseContext, "cancel", Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }
            dialog.show()
        }
        model.fitchClients(email)
        model.getRealtimeUpdates()
        model.stocks.observe(this, Observer {
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
            it.recharge =rechaege
            it.stockSim = sim
            stock.stockAccessoir = stockAcc
            stock.stockPhones = phones
            stock.recharge = rechaege
            stock.stockSim = sim


        })


    }
}