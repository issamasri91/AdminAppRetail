package com.issamelasri.adminappretail

import com.google.firebase.database.Exclude

class Vendeur {
    constructor()

    @get:Exclude
    var id = ""
    val email = ""
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vendeur

        return true
    }
    @get:Exclude
    var isDeleted: Boolean = false
    override fun hashCode(): Int {
        return email.hashCode()
    }


}