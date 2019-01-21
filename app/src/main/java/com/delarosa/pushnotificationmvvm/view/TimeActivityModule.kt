package com.delarosa.pushnotificationmvvm.view


import android.content.Context
import com.delarosa.pushnotificationmvvm.ApplicationClass
import com.delarosa.pushnotificationmvvm.model.TimeRepositoryImpl
import com.delarosa.pushnotificationmvvm.viewModel.TimeViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TimeActivityModule {
    @Provides
    fun provideTimeViewModel() = TimeViewModel(TimeRepositoryImpl(), TimeActivity())

    @Provides
    @Singleton
    fun provideContext(app: ApplicationClass): Context = app
}