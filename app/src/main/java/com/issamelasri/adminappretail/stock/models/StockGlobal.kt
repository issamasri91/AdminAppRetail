package com.issamelasri.adminappretail.stock.models

import com.google.firebase.database.Exclude

class StockGlobal {

    constructor(
        recharge: RechargeStock,
        stockSim: StockSim,
        stockAccessoir: StockAccessoir,
        stockPhones: StockPhones
    ) {
        this.recharge = recharge
        this.stockSim = stockSim
        this.stockAccessoir = stockAccessoir
        this.stockPhones = stockPhones
    }

    constructor()

    @get:Exclude
    var id = ""
    var recharge: RechargeStock =
        RechargeStock()
    var stockSim: StockSim =
        StockSim()
    var stockAccessoir: StockAccessoir =
        StockAccessoir()
    var stockPhones: StockPhones =
        StockPhones()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StockGlobal

        if (recharge != other.recharge) return false
        if (stockSim != other.stockSim) return false
        if (stockAccessoir != other.stockAccessoir) return false
        if (stockPhones != other.stockPhones) return false

        return true
    }

    @get:Exclude
    var isDeleted: Boolean = false
    override fun hashCode(): Int {
        var result = recharge.hashCode()
        result = 31 * result + stockSim.hashCode()
        result = 31 * result + stockAccessoir.hashCode()
        result = 31 * result + stockPhones.hashCode()
        return result
    }

}