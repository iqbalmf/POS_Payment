package com.example.a0155.myapplication.network.dao

data class MainDataDao(
    val avatar_url : String,
    val name:String,
    val location:String,
    val public_repos:Int,
    val followers:Int,
    val following:Int
)