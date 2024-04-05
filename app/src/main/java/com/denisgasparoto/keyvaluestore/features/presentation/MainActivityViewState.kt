package com.denisgasparoto.keyvaluestore.features.presentation

internal sealed class MainActivityViewState {

    data class Feedback(val value: String) : MainActivityViewState()
    data class Error(val errorMessage: String) : MainActivityViewState()
}
