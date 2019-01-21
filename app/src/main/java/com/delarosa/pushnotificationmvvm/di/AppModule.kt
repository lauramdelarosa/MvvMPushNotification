package com.delarosa.pushnotificationmvvm.di

import android.content.Context
import com.delarosa.pushnotificationmvvm.ApplicationClass
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
   @Provides
     @Singleton
     fun provideApplicationContext(app: ApplicationClass): Context = app
}