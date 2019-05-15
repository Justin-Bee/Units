package com.bee.units

class NavDrawerItem {


    var isShowNotify: Boolean = false
    var title: String? = null


    constructor() {

    }

    constructor(showNotify: Boolean, title: String) {
        this.isShowNotify = showNotify
        this.title = title
    }

    fun gettitle():String?{
        return this.title
    }
}