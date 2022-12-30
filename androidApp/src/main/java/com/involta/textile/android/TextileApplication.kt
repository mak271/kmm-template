package com.involta.textile.android

import android.app.Application
import com.involta.textile.core.PlatformSDK
import com.involta.textile.core.platform.PlatformConfiguration

class TextileApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initPlatformSDK()
    }
}

private fun TextileApplication.initPlatformSDK() =
    PlatformSDK.init(PlatformConfiguration(applicationContext))