package com.example.a0155.myapplication.model.source

import com.example.a0155.myapplication.model.MainData
import com.example.a0155.myapplication.model.Repodata

class MainDataRepository(
    val remoteDataSource: MainDataSource,
    val localDataSource: MainDataSource
) : MainDataSource{
    override fun getMainData(callback: MainDataSource.GetMainDataCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        remoteDataSource.getMainData(object : MainDataSource.GetMainDataCallback{
            override fun onDataLoaded(mainData: MainData) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                callback.onDataLoaded(mainData)
            }

            override fun onNotAvailable() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                callback.onNotAvailable()
            }

            override fun onError(msg: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                callback.onError(msg)
            }

        })
    }

    override fun getRepoData(callback: MainDataSource.GetMainRepoCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        remoteDataSource.getRepoData(object : MainDataSource.GetMainRepoCallback{
            override fun onDataLoaded(repodata: MutableList<Repodata?>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                callback.onDataLoaded(repodata)
            }

            override fun onNotAvailable() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                callback.onNotAvailable()
            }

            override fun onError(msg: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                callback.onError(msg)
            }

        })
    }
    companion object {
        private var INSTANCE: MainDataRepository? = null

    }
}