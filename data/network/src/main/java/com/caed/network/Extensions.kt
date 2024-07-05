package com.caed.network

import com.caed.network.model.Data
import com.google.gson.JsonParser
import retrofit2.Response

inline fun <T> handleRequest(call: () -> Response<T>) : Data<T> {
    var data: Data<T>

    try {
        val response = call()
        val successful = response.isSuccessful
        val body = response.body()

        if (successful && body != null) {
            data = Data.Success(body)
        }
        else {
            val errorJsonString = response.errorBody()?.string()
            val json = JsonParser()
                .parse(errorJsonString)
                .asJsonObject["message"]
                .asString
            val throwable = Throwable(message = json)

            data = Data.Error(throwable)
        }
    }
    catch (e: Exception){
        data = Data.Error(e.cause)
    }

    return data
}