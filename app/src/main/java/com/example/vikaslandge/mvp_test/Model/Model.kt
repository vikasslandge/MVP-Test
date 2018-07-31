package com.example.vikaslandge.mvp_test.Model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
 import com.example.vikaslandge.mvp_test.Presnter.PresenterAPI
import com.example.vikaslandge.mvp_test.View.IndiView
import com.example.vikaslandge.mvp_test.View.MainActivity
import com.example.vikaslandge.mvp_test.beans.Bean

class Model : PresenterAPI{

    var dbase : SQLiteDatabase? = null
    var api :IndiView? =null

    constructor(api: IndiView){
        this.api = api
        var mactivity= api as MainActivity
        dbase = mactivity.openOrCreateDatabase("incexp",Context.MODE_PRIVATE,null)

        dbase!!.execSQL("create table  if not exists incexp(_id integer primary key autoincrement, date_ varchar(20),amount number,desc_ varchar(500),type varchar(20))")
    }
    override fun addInput(bean: Bean) {
        var cv = ContentValues()
        cv.put("date_",bean.date_)
        cv.put("amount",bean.amount)
        cv.put("desc_",bean.desc_)
        cv.put("type",bean.type)

        var status = dbase!!.insert("incexp",null,cv)
        if (status==-1.toLong()){
            api!!.addResponse("Insertion Fail")
         }else{
            api!!.addResponse("Inserted successfully")
        }
     }


    override fun viewInput(type: String) {
        var c = dbase!!.query("incexp",null,"type=?", arrayOf(type),null,null,null,null)

        api!!.viewResponse(c)
     }
}