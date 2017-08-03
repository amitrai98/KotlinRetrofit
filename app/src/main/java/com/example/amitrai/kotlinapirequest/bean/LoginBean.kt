package com.example.amitrai.kotlinapirequest.bean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by amitrai on 3/8/17.
 * used for :-
 */

class LoginBean : BaseBean() {

    @SerializedName("error")
    @Expose
    var error: Boolean? = null
    @SerializedName("data")
    @Expose
    var data: Data? = null



}
