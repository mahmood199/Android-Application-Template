package com.example.androidapplicationtemplate.core.platform

sealed class RecyclerViewItemClickAction {
    data class ClickInterceptorOne(val position: Int) : RecyclerViewItemClickAction()
}