package com.issamelasri.adminappretail

import android.view.View

interface RecyclerClickListener {
    fun onRecyclerItemClicked(view: View, client: Vendeur)
}