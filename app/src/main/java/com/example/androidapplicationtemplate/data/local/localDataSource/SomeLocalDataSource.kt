package com.example.androidapplicationtemplate.data.local.localDataSource

import com.example.androidapplicationtemplate.data.local.dao.SomeDao
import javax.inject.Inject

class SomeLocalDataSource @Inject constructor(
    val someDao: SomeDao
) {
}