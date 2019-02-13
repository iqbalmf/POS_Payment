package com.example.a0155.myapplication.injection.component

import android.os.Build
import com.example.a0155.myapplication.injection.module.NetworkModule
import com.example.a0155.myapplication.ui.PostListViewModel
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector{
    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param postListViewModel PostListViewModel in which to inject the dependencies
     */
    fun inject(postListViewModel: PostListViewModel)
    /**
     * Injects required dependencies into the specified PostViewModel.
     * @param postViewModel PostViewModel in which to inject the dependencies
     */
    @Component.Builder
    interface Builder{
        fun Build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule) : Builder
    }
}