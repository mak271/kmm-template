package com.involta.diamant.core

import com.involta.diamant.core.ktor.ktorModule
import org.kodein.di.DI

val coreModule = DI.Module("coreModule") {
    importAll(
        ktorModule
    )
}