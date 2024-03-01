package com.example.mangan.domain

public class Categorydomain{
    private var title: String? = null
    private var pic: String? = null

    class CategoryDomain {
        var title: String = ""
            private set

        var pic: String = ""
            private set

        constructor(title: String, pic: String) {
            this.title = title
            this.pic = pic
        }
    }

}