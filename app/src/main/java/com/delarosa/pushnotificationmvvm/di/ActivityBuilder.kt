package com.delarosa.pushnotificationmvvm.di

import com.delarosa.pushnotificationmvvm.view.TimeActivity
import com.delarosa.pushnotificationmvvm.view.TimeActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [(TimeActivityModule::class)])
    abstract fun bindTimeActivity(): TimeActivity
}