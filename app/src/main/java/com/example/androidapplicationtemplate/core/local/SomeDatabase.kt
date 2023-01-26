package com.example.androidapplicationtemplate.core.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidapplicationtemplate.data.local.dao.SomeDao
import com.example.androidapplicationtemplate.data.models.entity.Entity


@Database(entities = [Entity::class], version = 1)
abstract class SomeDatabase : RoomDatabase() {

    abstract fun someDao() : SomeDao

}