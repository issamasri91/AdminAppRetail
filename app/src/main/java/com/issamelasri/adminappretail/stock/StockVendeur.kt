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
    var email = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock_vendeur)
        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        email = if (intent != null) {
            intent.extras?.get(STOCK_CHILD).toString()
        } else
            return

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        model.fitchClients(email)
        model.getRealtimeUpdates(email)
        model.stocks.observe(this, Observer {
            stock = it
        })

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    when (tab.position) {
                        0 -> {
                            pageActive = 0
                            //acc
                            if (StockAccFragment().isVisible) {
                                stock_accessoir_cable.text = stock.stockAccessoir.cable.toString()
                                stock_carte_memoir.text = stock.stockAccessoir.carte.toString()
                                char_stock_acc.text = stock.stockAccessoir.chargeur.toString()
                                ecteur_stock.text = stock.stockAccessoir.earphone.toString()
                                protection_stock.text = stock.stockAccessoir.protection.toString()
                                puchet_stock.text = stock.stockAccessoir.puchet.toString()
                                supportStock.text = stock.stockAccessoir.support.toString()
                                autre_acc_stock.text = stock.stockAccessoir.aurteAcc.toString()
                            }
                        }
                        1 -> {
                            pageActive = 1
                            if (StockPhonesFragment().isVisible) {
                                //phones
                                stock_phones_nokia.text = stock.stockPhones.nokia.toString()
                                stock_phones_hwaoui.text = stock.stockPhones.hwaui.toString()
                                stock_phones_logicom.text = stock.stockPhones.logicom.toString()
                                stock_phones_accent.text = stock.stockPhones.accent.toString()
                                stock_phones_oppo.text = stock.stockPhones.lenovo.toString()
                                stock_phones_tecno.text = stock.stockPhones.tecno.toString()
                                stock_phones_samsung.text = stock.stockPhones.samsung.toString()
                                stock_phones_autre.text = stock.stockPhones.autre.toString()
                            }

                        }
                        2 -> {
                            pageActive = 2
                            if (StockRechFragment().isVisible) {
                                //recharge
                                //inwi
                                inwi_5.text = stock.recharge.inwiscratch5.toString()
                                inwi_10.text = stock.recharge.inwiscratch10.toString()
                                inwi_20.text = stock.recharge.inwiscratch20.toString()
                                inwi_50.text = stock.recharge.inwiscratch50.toString()
                                inwi_100.text = stock.recharge.inwiscratch100.toString()
                                inwi_500.text = stock.recharge.inwidealer500.toString()
                                inwi_1000.text = stock.recharge.inwidealer1000.toString()
                                inwi_5000.text = stock.recharge.inwidealer5000.toString()
                                //orange
                                orange_5.text = stock.recharge.orangeScratch5.toString()
                                orange_10.text = stock.recharge.orangeScratch10.toString()
                                orange_20.text = stock.recharge.orangeScratch20.toString()
                                orange_25.text = stock.recharge.orangeScratch25.toString()
                                orange_50.text = stock.recharge.orangeScratch50.toString()
                                orange_100.text = stock.recharge.orangeScratch100.toString()
                                orange_500.text = stock.recharge.orangeDealer500.toString()
                                //iam
                                iam5.text = stock.recharge.iamscratch5.toString()
                                iam10.text = stock.recharge.iamscratch10.toString()
                                iam20.text = stock.recharge.iamscratch20.toString()
                                iam50.text = stock.recharge.iamscratch50.toString()
                                iam100.text = stock.recharge.iamscratch100.toString()
                                iam500.text = stock.recharge.iamdealer500.toString()
                                iam1000.text = stock.recharge.iamdealer1000.toString()
                            }
                        }
                        3 -> {
                            pageActive = 3
                            if (StockSimFragment().isVisible) {
                                stock_inwi_sim.text = stock.stockSim.inwi.toString()
                                stock_orange_sim.text = stock.stockSim.orange.toString()
                                stock_iam_sim.text = stock.stockSim.iam.toString()

                            }
                            //sim

                        }
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
                    dialog.stock_accessoir_cable_editText.setText(stock_accessoir_cable.text)
                    dialog.stock_carte_memoir_editText.setText(stock_carte_memoir.text)
                    dialog.stock_chargeur.setText(char_stock_acc.text)
                    dialog.stock_ecuteur.setText(ecteur_stock.text)
                    dialog.stock_protection.setText(protection_stock.text)
                    dialog.stock_pochet.setText(puchet_stock.text)
                    dialog.stock_support.setText(supportStock.text)
                    dialog.stock_autre.setText(autre_acc_stock.text)
                }
                1 -> {
                    dialog.customView(R.layout.enter_stock_phones)
                    dialog.nokia_stock_edit.setText(stock_phones_nokia.text)
                    dialog.hwauei_stock_edit.setText(stock_phones_hwaoui.text)
                    dialog.logicom_stock_edit.setText(stock_phones_logicom.text)
                    dialog.accent_stock_edit.setText(stock_phones_accent.text)
                    dialog.oppo_stock_edit.setText(stock_phones_oppo.text)
                    dialog.tecno_stock_edit.setText(stock_phones_tecno.text)
                    dialog.samsung_stock_edit.setText(stock_phones_samsung.text)
                    dialog.autre_phones_edit.setText(stock_phones_autre.text)
                }
                2 -> {
                    dialog.customView(R.layout.enter_stock_recharge)
                    //inwi
                    dialog.inwi_5dh_edit.setText(inwi_5.text)
                    dialog.inwi_10dh_edit.setText(inwi_10.text)
                    dialog.inwi_20_edit.setText(inwi_20.text)
                    dialog.inwi_50_edit.setText(inwi_50.text)
                    dialog.inwi_100_edit.setText(inwi_100.text)
                    dialog.inwi_500_edit.setText(inwi_500.text)
                    dialog.inwi_1000_edit.setText(inwi_1000.text)
                    dialog.inwi_5000_edit.setText(inwi_5000.text)
                    //orange
                    dialog.orange_5_edit.setText(orange_5.text)
                    dialog.orange_10_edit.setText(orange_10.text)
                    dialog.orange_20_edit.setText(orange_20.text)
                    dialog.orange_50_edit.setText(orange_50.text)
                    dialog.orange_25_edit.setText(orange_25.text)
                    dialog.orange_100_edit.setText(orange_100.text)
                    dialog.orange_500_edit.setText(orange_500.text)
                    //iam
                    dialog.iam5edit.setText(iam5.text)
                    dialog.iam10edit.setText(iam10.text)
                    dialog.iam20edit.setText(iam20.text)
                    dialog.iam50edit.setText(iam50.text)
                    dialog.iam100edit.setText(iam100.text)
                    dialog.iam500edit.setText(iam500.text)
                    dialog.iam1000edit.setText(iam1000.text)

                }
                3 -> {
                    dialog.customView(R.layout.enter_stock_sim)
                    dialog.stock_sim_inwi_edit.setText(stock_inwi_sim.text)
                    dialog.stock_orange_sim_edittex.setText(stock_orange_sim.text)
                    dialog.stock_iam_sim_edittex.setText(stock_iam_sim.text)
                }
            }
            dialog.positiveButton {
                when (pageActive) {
                    0 -> {

                        stock_accessoir_cable.text = dialog.stock_accessoir_cable_editText.text
                        stock_carte_memoir.text = dialog.stock_carte_memoir_editText.text
                        char_stock_acc.text = dialog.stock_chargeur.text
                        ecteur_stock.text = dialog.stock_ecuteur.text
                        protection_stock.text = dialog.stock_protection.text
                        puchet_stock.text = dialog.stock_pochet.text
                        supportStock.text = dialog.stock_support.text
                        autre_acc_stock.text = dialog.stock_autre.text
                        stock.stockAccessoir.cable = stock_accessoir_cable.text.toString().toInt()
                        stock.stockAccessoir.carte = stock_carte_memoir.text.toString().toInt()
                        stock.stockAccessoir.chargeur = char_stock_acc.text.toString().toInt()
                        stock.stockAccessoir.earphone = ecteur_stock.text.toString().toInt()
                        stock.stockAccessoir.protection = protection_stock.text.toString().toInt()
                        stock.stockAccessoir.puchet = puchet_stock.text.toString().toInt()
                        stock.stockAccessoir.support = supportStock.text.toString().toInt()
                        stock.stockAccessoir.aurteAcc = autre_acc_stock.text.toString().toInt()

                    }
                    1 -> {
                        stock_phones_nokia.text = dialog.nokia_stock_edit.text
                        stock_phones_hwaoui.text = dialog.hwauei_stock_edit.text
                        stock_phones_logicom.text = dialog.logicom_stock_edit.text
                        stock_phones_accent.text = dialog.accent_stock_edit.text
                        stock_phones_oppo.text = dialog.oppo_stock_edit.text
                        stock_phones_tecno.text = dialog.tecno_stock_edit.text
                        stock_phones_samsung.text = dialog.samsung_stock_edit.text
                        stock_phones_autre.text = dialog.autre_phones_edit.text


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

                        //orange
                        orange_5.text = dialog.orange_5_edit.text
                        orange_10.text = dialog.orange_10_edit.text
                        orange_20.text = dialog.orange_20_edit.text
                        orange_25.text = dialog.orange_25_edit.text
                        orange_50.text = dialog.orange_50_edit.text
                        orange_100.text = dialog.orange_100_edit.text
                        orange_500.text = dialog.orange_500_edit.text

                        //iam
                        iam5.text = dialog.iam5edit.text
                        iam10.text = dialog.iam10edit.text
                        iam20.text = dialog.iam20edit.text
                        iam50.text = dialog.iam50edit.text
                        iam100.text = dialog.iam100edit.text
                        iam500.text = dialog.iam500edit.text
                        iam1000.text = dialog.iam1000edit.text


                    }
                    3 -> {
                        stock_inwi_sim.text = dialog.stock_sim_inwi_edit.text
                        stock_orange_sim.text = dialog.stock_orange_sim_edittex.text
                        stock_iam_sim.text = dialog.stock_iam_sim_edittex.text


                    }
                }
                stock.stockPhones.nokia = stock_phones_nokia.text.toString().toInt()
                stock.stockPhones.hwaui = stock_phones_hwaoui.text.toString().toInt()
                stock.stockPhones.logicom = stock_phones_logicom.text.toString().toInt()
                stock.stockPhones.accent = stock_phones_accent.text.toString().toInt()
                stock.stockPhones.lenovo = stock_phones_oppo.text.toString().toInt()
                stock.stockPhones.tecno = stock_phones_tecno.text.toString().toInt()
                stock.stockPhones.samsung = stock_phones_samsung.text.toString().toInt()
                stock.stockPhones.autre = stock_phones_autre.text.toString().toInt()
                stock.recharge.inwiscratch5 = inwi_5.text.toString().toInt()
                stock.recharge.inwiscratch10 = inwi_10.text.toString().toInt()
                stock.recharge.inwiscratch20 = inwi_20.text.toString().toInt()
                stock.recharge.inwiscratch50 = inwi_50.text.toString().toInt()
                stock.recharge.inwiscratch100 = inwi_100.text.toString().toInt()
                stock.recharge.inwidealer500 = inwi_500.text.toString().toInt()
                stock.recharge.inwidealer1000 = inwi_1000.text.toString().toInt()
                stock.recharge.inwidealer5000 = inwi_5000.text.toString().toInt()
                stock.recharge.orangeScratch5 = orange_5.text.toString().toInt()
                stock.recharge.orangeScratch10 = orange_10.text.toString().toInt()
                stock.recharge.orangeScratch20 = orange_20.text.toString().toInt()
                stock.recharge.orangeScratch25 = orange_25.text.toString().toInt()
                stock.recharge.orangeScratch50 = orange_50.text.toString().toInt()
                stock.recharge.orangeScratch100 = orange_100.text.toString().toInt()
                stock.recharge.orangeDealer500 = orange_500.text.toString().toInt()
                stock.recharge.iamscratch5 = iam5.text.toString().toInt()
                stock.recharge.iamscratch10 = iam10.text.toString().toInt()
                stock.recharge.iamscratch20 = iam20.text.toString().toInt()
                stock.recharge.iamscratch50 = iam50.text.toString().toInt()
                stock.recharge.iamscratch100 = iam100.text.toString().toInt()
                stock.recharge.iamdealer500 = iam500.text.toString().toInt()
                stock.recharge.iamdealer1000 = iam1000.text.toString().toInt()
                stock.stockSim.inwi = stock_inwi_sim.text.toString().toInt()
                stock.stockSim.orange = stock_orange_sim.text.toString().toInt()
                stock.stockSim.iam = stock_iam_sim.text.toString().toInt()
                model.addStock(stock, email)
                Toast.makeText(applicationContext, "stock change", Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }
            dialog.negativeButton {
                Toast.makeText(baseContext, "cancel", Toast.LENGTH_LONG).show()
                dialog.dismiss()
            }
            dialog.show()
        }
    }

    internal interface SendMessage {
        fun sendData(stock: StockGlobal?)
    }

    override fun onStart() {
        super.onStart()
        model.stocks.observe(this@StockVendeur, Observer {
            stock = it


        })
    }

    fun fillText() {
        //acc
        stock_accessoir_cable.text = stock.stockAccessoir.cable.toString()
        stock_carte_memoir.text = stock.stockAccessoir.carte.toString()
        char_stock_acc.text = stock.stockAccessoir.chargeur.toString()
        ecteur_stock.text = stock.stockAccessoir.earphone.toString()
        protection_stock.text = stock.stockAccessoir.protection.toString()
        puchet_stock.text = stock.stockAccessoir.puchet.toString()
        supportStock.text = stock.stockAccessoir.support.toString()
        autre_acc_stock.text = stock.stockAccessoir.aurteAcc.toString()
        //phones
        stock_phones_nokia.text = stock.stockPhones.nokia.toString()
        stock_phones_hwaoui.text = stock.stockPhones.hwaui.toString()
        stock_phones_logicom.text = stock.stockPhones.logicom.toString()
        stock_phones_accent.text = stock.stockPhones.accent.toString()
        stock_phones_oppo.text = stock.stockPhones.lenovo.toString()
        stock_phones_tecno.text = stock.stockPhones.tecno.toString()
        stock_phones_samsung.text = stock.stockPhones.samsung.toString()
        stock_phones_autre.text = stock.stockPhones.autre.toString()
        //sim
        // stock_inwi_sim.text = stock.stockSim.inwi.toString()
        //     stock_orange_sim.text =  stock.stockSim.orange.toString()
        // stock_iam_sim.text =  stock.stockSim.iam.toString()
        //recharge
        //inwi
        inwi_5.text = stock.recharge.inwiscratch5.toString()
        inwi_10.text = stock.recharge.inwiscratch10.toString()
        inwi_20.text = stock.recharge.inwiscratch20.toString()
        inwi_50.text = stock.recharge.inwiscratch50.toString()
        inwi_100.text = stock.recharge.inwiscratch100.toString()
        inwi_500.text = stock.recharge.inwidealer500.toString()
        inwi_1000.text = stock.recharge.inwidealer1000.toString()
        inwi_5000.text = stock.recharge.inwidealer5000.toString()
        //orange
        orange_5.text = stock.recharge.orangeScratch5.toString()
        orange_10.text = stock.recharge.orangeScratch10.toString()
        orange_20.text = stock.recharge.orangeScratch20.toString()
        orange_25.text = stock.recharge.orangeScratch25.toString()
        orange_50.text = stock.recharge.orangeScratch50.toString()
        orange_100.text = stock.recharge.orangeScratch100.toString()
        orange_500.text = stock.recharge.orangeDealer500.toString()
        //iam
        iam5.text = stock.recharge.iamscratch5.toString()
        iam10.text = stock.recharge.iamscratch10.toString()
        iam20.text = stock.recharge.iamscratch20.toString()
        iam50.text = stock.recharge.iamscratch50.toString()
        iam100.text = stock.recharge.iamscratch100.toString()
        iam500.text = stock.recharge.iamdealer500.toString()
        iam1000.text = stock.recharge.iamdealer1000.toString()
    }
}