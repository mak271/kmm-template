package com.involta.diamant.core.ktor

import io.ktor.client.engine.*

internal expect class HttpEngineFactory() {
    fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig>
}