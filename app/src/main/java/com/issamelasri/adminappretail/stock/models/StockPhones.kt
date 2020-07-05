package com.issamelasri.adminappretail.stock.models

class StockPhones {
    var nokia: Int = 0
    var hwaui: Int = 0
    var lenovo: Int = 0
    var accent: Int = 0
    var samsung: Int = 0
    var logicom: Int = 0
    var tecno: Int = 0
    var autre: Int = 0

    constructor(
        nokia: Int,
        hwaui: Int,
        lenovo: Int,
        accent: Int,
        samsung: Int,
        logicom: Int,
        tecno: Int,
        autre: Int
    ) {
        this.nokia = nokia
        this.hwaui = hwaui
        this.lenovo = lenovo
        this.accent = accent
        this.samsung = samsung
        this.logicom = logicom
        this.tecno = tecno
        this.autre = autre
    }

    constructor()

}
