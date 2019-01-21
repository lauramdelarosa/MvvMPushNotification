package com.delarosa.pushnotificationmvvm.viewModel

import android.content.Context
import com.delarosa.pushnotificationmvvm.ApplicationClass
import dagger.Module
import dagger.Provides

@Module
class TimeViewModelModule {
    @Provides
    fun provideContext(app: ApplicationClass): Context = app
}