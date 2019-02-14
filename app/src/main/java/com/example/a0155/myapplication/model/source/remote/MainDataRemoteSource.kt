package com.example.a0155.myapplication.model.source.remote

import android.util.Log
import com.example.a0155.myapplication.model.MainData
import com.example.a0155.myapplication.model.Repodata
import com.example.a0155.myapplication.model.source.MainDataSource
import com.example.a0155.myapplication.network.PostAPI
import com.example.a0155.myapplication.network.dao.RepoDataDao
import com.example.a0155.myapplication.utils.Constant
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object MainDataRemoteSource: MainDataSource {

    private val apiService = PostAPI.create()

    override fun getMainData(callback: MainDataSource.GetMainDataCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        apiService.getMainData(Constant.BASE_URL_UNAME)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                run {
                    if (it.name != ""){
                        val mainData = MainData(
                            it.name,
                            it.location,
                            it.avatar_url,
                            "${it.followers}\nFollowers",
                            "${it.following}\nFollowing",
                            "${it.public_repos}\nRepos"
                            )
                        callback.onDataLoaded(mainData)
                    }else{
                        callback.onNotAvailable()
                    }
                }
            }, {
                callback.onError(it.message)
            })

    }

    override fun getRepoData(callback: MainDataSource.GetMainRepoCallback) {
        apiService.getReposData(Constant.BASE_URL_UNAME)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                run {

                    if (it.isNotEmpty()) {
                        Log.i("xx", " ${it.size}")

                        val listRepo: MutableList<Repodata?> = mutableListOf<Repodata?>()
                        for (item: RepoDataDao in it) {
                            Log.i("xx", " -- ${item.desc}")
                            val repoData = Repodata(
                                item.name,
                                item.language,
                                item.desc,
                                item.html_url
                            )
                            listRepo.add(repoData)


                        }

                        callback.onDataLoaded(listRepo)
                    } else {
                        callback.onNotAvailable()
                    }

                }
            }, {
                callback.onError(it.message)
            })
    }
}