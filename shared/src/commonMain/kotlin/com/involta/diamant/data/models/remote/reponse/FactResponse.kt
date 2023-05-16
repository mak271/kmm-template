package com.involta.textile.data.models.remote.reponse

import com.involta.textile.data.models.Fact
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FactResponse(
    @SerialName("fact")
    val fact: String,
    @SerialName("length")
    val length: Int
) {
    fun toFact(): Fact = Fact(fact)
}