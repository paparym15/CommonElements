package com.one.testnotifications.di.modules

import androidx.lifecycle.ViewModel
import com.one.testnotifications.MainViewModel
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ViewModelModule {

    @Singleton
    @Binds
    fun bindsMainViewModel(mainViewModel: MainViewModel): ViewModel
}