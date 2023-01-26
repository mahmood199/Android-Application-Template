package com.example.androidapplicationtemplate.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.androidapplicationtemplate.data.models.entity.Entity

@Dao
interface SomeDao {

    @Query("Select * from local_entity")
    suspend fun getAll(): List<Entity>


}