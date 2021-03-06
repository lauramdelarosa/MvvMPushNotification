package com.delarosa.pushnotificationmvvm.view


import com.delarosa.pushnotificationmvvm.model.TimeRepositoryImpl
import com.delarosa.pushnotificationmvvm.viewModel.TimeViewModel
import dagger.Module
import dagger.Provides

@Module
class TimeActivityModule {
    @Provides
    fun provideTimeViewModel() = TimeViewModel(TimeRepositoryImpl())
}