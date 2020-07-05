package com.issamelasri.adminappretail.stock.models

class StockAccessoir {
    var cable: Int = 0
    var chargeur: Int = 0
    var puchet: Int = 0
    var protection: Int = 0
    var earphone: Int = 0
    var support: Int = 0
    var carte: Int = 0
    var aurteAcc: Int = 0

    constructor(
        cable: Int,
        chargeur: Int,
        puchet: Int,
        protection: Int,
        earphone: Int,
        support: Int,
        carte: Int,
        aurteAcc: Int
    ) {
        this.cable = cable
        this.chargeur = chargeur
        this.puchet = puchet
        this.protection = protection
        this.earphone = earphone
        this.support = support
        this.carte = carte
        this.aurteAcc = aurteAcc
    }

    constructor()
}
