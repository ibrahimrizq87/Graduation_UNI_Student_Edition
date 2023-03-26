package com.uni.unistudent.data.di

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object appModule {
    @Provides
    @Singleton
    fun provideSharedPref(@ApplicationContext context: Context):SharedPreferences{
        return context.getSharedPreferences(SharedPreferencesTable.local_shared_preferences,Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideGson():Gson{
        return Gson()
    }
}