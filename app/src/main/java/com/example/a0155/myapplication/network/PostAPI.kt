package com.example.a0155.myapplication.network

import com.example.a0155.myapplication.model.Post
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface PostAPI{
    @GET("/Post")
    fun getPost(): Observable<List<Post>>
}