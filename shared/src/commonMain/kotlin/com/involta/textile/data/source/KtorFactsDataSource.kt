package com.involta.textile.data.source

import com.involta.textile.data.models.remote.reponse.FactResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class KtorFactsDataSource(private val httpClient: HttpClient) {
    suspend fun getFact(): FactResponse {
        return httpClient.request {
            url {
                path("/fact")
            }
        }.body()
    }
}