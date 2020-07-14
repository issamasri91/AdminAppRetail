package com.issamelasri.adminappretail.stock

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.issamelasri.adminappretail.R
import com.issamelasri.adminappretail.STOCK_CHILD
import com.issamelasri.adminappretail.stock.models.StockGlobal
import com.issamelasri.adminappretail.ui.main.SectionsPagerAdapter
import kotlinx.android.synthetic.main.enter_acc_stock.*
import kotlinx.android.synthetic.main.enter_stock_phones.*
import kotlinx.android.synthetic.main.enter_stock_recharge.*
import kotlinx.android.synthetic.main.enter_stock_sim.*
import kotlinx.android.synthetic.main.fragment_stock_acc.*
import kotlinx.android.synthetic.main.fragment_stock_phones.*
import kotlinx.android.synthetic.main.fragment_stock_rech.*
import kotlinx.android.synthetic.main.fragment_stock_sim.*

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
                2 -> {
                    dialog.customView(R.layout.enter_stock_recharge)
                }
                3 -> {
                    dialog.customView(R.layout.enter_stock_sim)
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
                        val nokia = dialog.nokia_stock_edit.text
                        stock_phones_nokia.text = nokia
                        val hwaui = dialog.hwauei_stock_edit.text
                        stock_phones_hwaoui.text = hwaui
                        val logicom = dialog.logicom_stock_edit.text
                        stock_phones_logicom.text = logicom
                        val accent = dialog.accent_stock_edit.text
                        stock_phones_accent.text = accent
                        val oppo = dialog.oppo_stock_edit.text
                        stock_phones_oppo.text = oppo
                        val tecno = dialog.tecno_stock_edit.text
                        stock_phones_oppo.text = tecno
                        val samsung = dialog.samsung_stock_edit.text
                        stock_phones_samsung.text = samsung
                        val autrePhones = dialog.autre_phones_edit.text
                        stock_phones_autre.text = autrePhones
                        stock.stockPhones.nokia = nokia.toString().toInt()
                        stock.stockPhones.hwaui = hwaui.toString().toInt()
                        stock.stockPhones.logicom = logicom.toString().toInt()
                        stock.stockPhones.accent = accent.toString().toInt()
                        stock.stockPhones.lenovo = oppo.toString().toInt()
                        stock.stockPhones.tecno = tecno.toString().toInt()
                        stock.stockPhones.samsung = samsung.toString().toInt()
                        stock.stockPhones.autre = autrePhones.toString().toInt()
                        model.addStock(stock, email)
                        Toast.makeText(applicationContext, "stock change", Toast.LENGTH_LONG).show()

                    }
                    2 -> {
                        //inwi
                        inwi_5.text = dialog.inwi_5dh_edit.text
                        inwi_10.text = dialog.inwi_10dh_edit.text
                        inwi_20.text = dialog.inwi_20_edit.text
                        inwi_50.text = dialog.inwi_50_edit.text
                        inwi_100.text = dialog.inwi_1000_edit.text
                        inwi_500.text = dialog.inwi_500_edit.text
                        inwi_1000.text = dialog.inwi_1000_edit.text
                        inwi_5000.text = dialog.inwi_5000_edit.text
                        stock.recharge.inwiscratch5 = inwi_5.text.toString().toInt()
                        stock.recharge.inwiscratch10 = inwi_10.text.toString().toInt()
                        stock.recharge.inwiscratch20 = inwi_20.text.toString().toInt()
                        stock.recharge.inwiscratch50 = inwi_50.text.toString().toInt()
                        stock.recharge.inwiscratch100 = inwi_100.text.toString().toInt()
                        stock.recharge.inwidealer500 = inwi_500.text.toString().toInt()
                        stock.recharge.inwidealer1000 = inwi_100.text.toString().toInt()
                        stock.recharge.inwidealer5000 = inwi_5000.text.toString().toInt()
                        model.addStock(stock, email)
                        Toast.makeText(applicationContext, "stock change", Toast.LENGTH_LONG).show()


                    }
                    3 -> {
                        val inwiSim = dialog.stock_sim_inwi_edit.text
                        stock_inwi_sim.text = inwiSim
                        val orangeSim = dialog.stock_orange_sim_edittex.text
                        stock_orange_sim.text = orangeSim
                        val iamSim = dialog.stock_iam_sim_edittex.text
                        stock_iam_sim.text = iamSim
                        stock.stockSim.inwi = inwiSim.toString().toInt()
                        stock.stockSim.orange = orangeSim.toString().toInt()
                        stock.stockSim.iam = iamSim.toString().toInt()
                        model.addStock(stock, email)
                        Toast.makeText(applicationContext, "stock change", Toast.LENGTH_LONG).show()
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


    }
}