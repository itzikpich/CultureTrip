package com.itzikpich.culturetrip.di.modules

import com.itzikpich.culturetrip.di.components.ArticlesActivitySubComponent
import com.itzikpich.culturetrip.di.components.MainActivitySubComponent
import dagger.Module

@Module(subcomponents = [MainActivitySubComponent::class, ArticlesActivitySubComponent::class])
class SubcomponentsModule {
}