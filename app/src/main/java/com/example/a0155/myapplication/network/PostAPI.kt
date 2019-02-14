package com.example.a0155.myapplication.network

import com.example.a0155.myapplication.network.dao.MainDataDao
import com.example.a0155.myapplication.model.Post
import com.example.a0155.myapplication.network.dao.RepoDataDao
import com.example.a0155.myapplication.utils.Constant
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PostAPI{
    @GET("/Post")
    fun getPost(): Observable<List<Post>>
    //bedaversi tutorial

    @GET("users/{username}")
    fun getMainData(@Path("username") username:String) :  Observable<MainDataDao>

    @GET("users/{username}/repos")
    fun getReposData(@Path("username") username: String): Observable<List<RepoDataDao>>

    companion object Factory{
        fun create(): PostAPI{
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build()
            return retrofit.create(PostAPI::class.java)
        }
    }
}