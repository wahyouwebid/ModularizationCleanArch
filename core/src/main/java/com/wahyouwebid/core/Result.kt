package com.wahyouwebid.core

sealed class Result<T>{
    class Loading<T>(): Result<T>()
    class Success<T>(val data:T?): Result<T>()
    class Error<T>(val message:String,val data:T?=null): Result<T>()
}
