package com.involta.textile.core

import com.involta.textile.core.ktor.ktorModule
import org.kodein.di.DI

val coreModule = DI.Module("coreModule") {
    importAll(
        ktorModule
    )
}