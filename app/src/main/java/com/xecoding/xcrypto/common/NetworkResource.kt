package com.xecoding.xcrypto.common

sealed class NetworkResource<T>(val data : T? = null, val message: String? = null) {
    class Success<T>(data: T): NetworkResource<T>(data)
    class Error<T>(data: T? = null, message: String): NetworkResource<T>(data, message)
    class Loading<T>(data: T? = null): NetworkResource<T>(data)
}