package com.example.androidapplicationtemplate.ui.someFeature

sealed class SomeState {
    object Idle : SomeState()
    object State1 : SomeState()
    object State2 : SomeState()
    object State3 : SomeState()
    object State4 : SomeState()

}