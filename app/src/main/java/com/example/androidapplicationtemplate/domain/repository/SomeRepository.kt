package com.example.androidapplicationtemplate.domain.repository

interface SomeRepository{
	suspend fun someCrudOperation() : Result<String>
}