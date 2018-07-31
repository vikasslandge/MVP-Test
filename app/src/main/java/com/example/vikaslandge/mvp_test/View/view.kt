package com.example.vikaslandge.mvp_test.View

import android.database.Cursor

interface IndiView {
    fun addResponse(msg : String)
    fun viewResponse(c :Cursor)

}