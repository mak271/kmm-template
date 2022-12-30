package com.involta.textile.data.repository.api

import com.involta.textile.data.models.Fact

interface TextileRepository {
    suspend fun getFact(): Fact
}