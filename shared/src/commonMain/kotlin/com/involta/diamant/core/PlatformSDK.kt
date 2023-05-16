package com.involta.diamant.core

import com.involta.diamant.core.di.Inject
import com.involta.diamant.core.di.textileRepositoryModule
import com.involta.diamant.core.platform.PlatformConfiguration
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.direct
import org.kodein.di.singleton

object PlatformSDK {
    fun init(
        configuration: PlatformConfiguration
    ) {

        val platformModule = DI.Module("platformModule") {
            bind<PlatformConfiguration>() with singleton { configuration }
        }

        Inject.createDependencies(
            DI {
                importAll(platformModule, coreModule, textileRepositoryModule)
            }.direct
        )
    }
}