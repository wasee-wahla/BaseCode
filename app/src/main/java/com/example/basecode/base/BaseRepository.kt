package com.example.basecode.base

import com.example.basecode.network.Resourse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.HttpException

abstract class BaseRepository {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resourse<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resourse.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        Resourse.Failure(false, throwable.code(), throwable.response()?.errorBody())
                    }
                    else -> {
                        Resourse.Failure(true, null, null)
                    }
                }
            }
        }
    }
}