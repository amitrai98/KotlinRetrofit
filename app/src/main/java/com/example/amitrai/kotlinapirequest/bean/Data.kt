package com.example.amitrai.kotlinapirequest.bean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by amitrai on 3/8/17.
 * used for :-
 */
class Data : BaseBean() {
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("apiKey")
    @Expose
    var apiKey: String? = null
    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null

  @SerializedName("message")
    @Expose
    var message: String? = null

}