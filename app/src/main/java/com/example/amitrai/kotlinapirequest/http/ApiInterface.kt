package com.example.amitrai.kotlinapirequest.http


import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url
import android.support.annotation.NonNull



/**
 * Created by amitrai on 3/8/17.
 * used for :-
 */

interface ApiInterface {

    @FormUrlEncoded
    @POST("/php/task_manager/v1/login")
    fun loginRequest(@Field("email") email: String,
              @Field("password") password: String): Call<ResponseBody>

}
