package com.involta.textile.core.di

import com.involta.textile.data.repository.TextileRepositoryImpl
import com.involta.textile.data.repository.api.TextileRepository
import com.involta.textile.data.source.KtorFactsDataSource
import org.kodein.di.*

val textileRepositoryModule = DI.Module("textileRepositoryModule") {
    bind<KtorFactsDataSource>() with provider {
        KtorFactsDataSource(instance())
    }

    bind<TextileRepository>() with singleton {
        TextileRepositoryImpl(instance())
    }

}