package com.example.portfoliomanagement.networking

import android.util.Log
import com.example.portfoliomanagement.domain.NetworkError
import com.example.portfoliomanagement.domain.Result
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException


//handle request before sending to server
suspend inline fun <reified T> safeCall(action: () -> HttpResponse): Result<T, NetworkError> {
    val response = try {
        action()
    } catch (e: UnresolvedAddressException){
        return Result.Error(NetworkError.NO_INTERNET)
    } catch (e: SerializationException) {
        return Result.Error(NetworkError.SERIALIZATION)
    } catch (e: Exception) {
        Log.d("response stock", "${e.message} hi")
        return Result.Error(NetworkError.UNKNOWN)
    }
    return responseToResult(response)
}