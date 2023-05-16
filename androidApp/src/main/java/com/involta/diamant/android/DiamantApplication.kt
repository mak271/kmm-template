package com.involta.diamant.android

import android.app.Application
import com.involta.diamant.core.PlatformSDK
import com.involta.diamant.core.platform.PlatformConfiguration

class DiamantApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initPlatformSDK()
    }
}

private fun DiamantApplication.initPlatformSDK() =
    PlatformSDK.init(PlatformConfiguration(applicationContext))