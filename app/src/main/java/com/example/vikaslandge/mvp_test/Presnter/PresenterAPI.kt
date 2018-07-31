package com.example.vikaslandge.mvp_test.Presnter

import com.example.vikaslandge.mvp_test.beans.Bean

interface PresenterAPI {
    fun addInput(bean: Bean)
    fun viewInput(type : String)

}