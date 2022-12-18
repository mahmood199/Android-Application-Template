package com.example.androidapplicationtemplate.data.repository

interface SomeRepository{
	suspend fun someCrudOperation() : Result<String>
}