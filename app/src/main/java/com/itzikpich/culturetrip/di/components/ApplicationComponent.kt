package com.itzikpich.culturetrip.di.components

import android.app.Application
import com.itzikpich.culturetrip.App
import com.itzikpich.culturetrip.di.modules.NetworkModule
import com.itzikpich.culturetrip.di.modules.SubcomponentsModule
import com.itzikpich.culturetrip.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    SubcomponentsModule::class,
    ViewModelModule::class
])
interface ApplicationComponent: AndroidInjector<App> {

    fun mainActivitySubComponent(): MainActivitySubComponent.Factory
    fun articlesActivitySubComponent(): ArticlesActivitySubComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(app: Application): Builder
        fun build(): ApplicationComponent
    }

}