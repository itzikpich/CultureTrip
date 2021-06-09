package com.itzikpich.culturetrip

import android.app.Application
import com.itzikpich.culturetrip.di.components.DaggerApplicationComponent


class App: Application() {

    val appComponent = DaggerApplicationComponent.builder().create(this).build()

}