package com.example.amitrai.kotlinapirequest.ui

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.example.amitrai.kotlinapirequest.R
import com.example.amitrai.kotlinapirequest.bean.BaseBean
import com.example.amitrai.kotlinapirequest.bean.Data
import com.example.amitrai.kotlinapirequest.bean.LoginBean
import com.example.amitrai.kotlinapirequest.http.request.SimpleRequest
import com.example.amitrai.kotlinapirequest.listeners.ApiCallback
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.content_base.*
import kotlinx.android.synthetic.main.content_base.view.*


class BaseActivity : AppCompatActivity(), ApiCallback, View.OnClickListener {


    //    val TAGN = BaseActivity::class.simpleName
    var requester = SimpleRequest()

    lateinit var pd: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setSupportActionBar(toolbar)

        pd = ProgressDialog(this)

        btn_login.setOnClickListener(this)


    }


    override fun onRequestSuccess(bean: BaseBean) {
        if (pd.isShowing)
            pd.dismiss()
        bean as LoginBean
        val data : Data = bean.data as Data
        Log.e("BASE ACTIVITY", ""+data.apiKey)
        showSnackBar("Logged-in successfully")
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onRequestFailed(message: String) {
        if (pd.isShowing)
            pd.dismiss()
        Log.e("BASE ACTIVITY", message)
        showSnackBar(message)
    }

    override fun onClick(p0: View?) {

        if (p0 == btn_login){
            if (edt_email.text.toString().trim().isBlank()){
                edt_email.setError("Can not be left empty")
                return
            }

            if (edt_password.text.toString().trim().isBlank()){
                edt_password.setError("Can not be left empty")
                return
            }

            if (!pd.isShowing)
                pd.show()

            requester.login(edt_email.text.toString().trim(), edt_password.text.toString().trim(), this)

        }
    }


    fun showSnackBar(message: String) {
        val snackbar = Snackbar
                .make(layout_parent, "" + message, Snackbar.LENGTH_LONG)

        snackbar.show()
    }


}
