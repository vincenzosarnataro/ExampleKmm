package it.sarni.ipakmm.presentation.models

sealed class UiState<T>(val data:T?) {
    class Success<T>(data: T) : UiState<T>(data)
    class Loading<T>(data: T? = null) : UiState<T>(data)
    class Error<T>(val throwable: Throwable,data: T?=null) : UiState<T>(data)
}