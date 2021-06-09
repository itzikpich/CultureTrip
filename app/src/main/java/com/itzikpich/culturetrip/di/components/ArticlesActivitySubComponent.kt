package com.itzikpich.culturetrip.di.components

import com.itzikpich.culturetrip.ArticlesActivity
import com.itzikpich.culturetrip.MainActivity
import dagger.Subcomponent

@Subcomponent
interface ArticlesActivitySubComponent {

    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): ArticlesActivitySubComponent
    }

    fun inject(activity: ArticlesActivity)
}