package com.example.a0155.myapplication.model.source

import com.example.a0155.myapplication.model.MainData
import com.example.a0155.myapplication.model.Repodata

interface MainDataSource{
    fun getMainData(callback:GetMainDataCallback)
    fun getRepoData(callback:GetMainRepoCallback)

    interface GetMainDataCallback{
        fun onDataLoaded(mainData: MainData)
        fun onNotAvailable()
        fun onError(msg:String?)
    }
    interface GetMainRepoCallback{
        fun onDataLoaded(repodata: MutableList<Repodata?>)
        fun onNotAvailable()
        fun onError(msg: String?)
    }
}