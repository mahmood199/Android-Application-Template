package com.example.androidapplicationtemplate.core.di

import android.content.Context
import androidx.room.Room
import com.example.androidapplicationtemplate.core.local.SomeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    private const val DB_NAME = "some_db"

    @Provides
    @Singleton
    fun provideSomeDatabase(@ApplicationContext context: Context) : SomeDatabase {
        return Room.databaseBuilder(
            context,
            SomeDatabase::class.java,
            DB_NAME)
            .build()
    }

}