package com.involta.textile.data.repository

import com.involta.textile.data.models.Fact
import com.involta.textile.data.repository.api.TextileRepository
import com.involta.textile.data.source.KtorFactsDataSource

class TextileRepositoryImpl(
    private val remoteDataSource: KtorFactsDataSource
) : TextileRepository {
    override suspend fun getFact(): Fact {
        return remoteDataSource.getFact().toFact()
    }
}