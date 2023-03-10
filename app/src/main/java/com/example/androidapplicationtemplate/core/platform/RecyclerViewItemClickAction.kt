package com.example.androidapplicationtemplate.core.platform

sealed class RecyclerViewItemClickAction {
    object ClickInterceptorThree : RecyclerViewItemClickAction()
    data class ClickInterceptorOne(val viewType: Int) : RecyclerViewItemClickAction()
    data class ClickInterceptorTwo(val viewType: Int) : RecyclerViewItemClickAction()
}