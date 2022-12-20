package com.example.androidapplicationtemplate.sample

import com.google.gson.annotations.SerializedName

data class PostEntity(
	@SerializedName("id") val id : Int,
	@SerializedName("title") val title : String,
	@SerializedName("body") val body : String,
	@SerializedName("userId") val userId : Int,
)