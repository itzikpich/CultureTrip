package com.itzikpich.culturetrip.di.components

import com.itzikpich.culturetrip.MainActivity
import dagger.Subcomponent

@Subcomponent
interface MainActivitySubComponent {

    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivitySubComponent
    }

    fun inject(activity: MainActivity)
}