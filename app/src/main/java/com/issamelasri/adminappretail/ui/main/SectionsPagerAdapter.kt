package com.issamelasri.adminappretail.ui.main


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.issamelasri.adminappretail.R
import com.issamelasri.adminappretail.stock.StockAccFragment
import com.issamelasri.adminappretail.stock.StockPhonesFragment
import com.issamelasri.adminappretail.stock.StockRechFragment
import com.issamelasri.adminappretail.stock.StockSimFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)

class SectionsPagerAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                StockAccFragment()
            }
            1 -> {
                StockPhonesFragment()
            }
            2 -> {
                StockRechFragment()
            }
            else -> {
                return StockSimFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Accessoir"
            1 -> "Phones"
            2 -> "Recharge"
            else -> {
                return "Sim"
            }
        }
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 4
    }


}