package com.example.vikaslandge.mvp_test.View

import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import com.example.vikaslandge.mvp_test.Model.Model
import com.example.vikaslandge.mvp_test.Presnter.PresenterAPI
import com.example.vikaslandge.mvp_test.R
import com.example.vikaslandge.mvp_test.beans.Bean
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),IndiView {

    override fun addResponse(msg: String) {
        Toast.makeText(this,msg, Toast.LENGTH_LONG).show()
    }

    override fun viewResponse(c: Cursor) {
        var myadapter = SimpleCursorAdapter(this,R.layout.indiview,c, arrayOf("date_","amount","desc_","type"), intArrayOf(
                R.id.tv1,
                R.id.tv2,R.id.tv3,
                R.id.tv4),0)
        lv1.adapter =myadapter

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        save.setOnClickListener(){
            var bean = Bean(et1.text.toString(),et2.text.toString().toInt(),et3.text.toString(),sp1.selectedItem.toString())

            var api : PresenterAPI = Model(this@MainActivity)
            api.addInput(bean)
        }
        view.setOnClickListener(){
            var api : PresenterAPI =Model(this)
            api.viewInput(sp1.selectedItem.toString())
        }

     }
}
