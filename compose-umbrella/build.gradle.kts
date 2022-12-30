plugins {
    kotlin("multiplatform")
    kotlin("kapt")
    id("org.jetbrains.compose")
    id("com.android.library")
}

val kviewmodelVersion = "0.12"
val odysseyVersion = "1.3.0"

kotlin {
    android()
    jvm("desktop")


    sourceSets {


        named("commonMain") {
            dependencies {
                implementation(project(":shared"))
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

                implementation("io.github.alexgladkov:odyssey-core:$odysseyVersion")
                implementation("io.github.alexgladkov:odyssey-compose:$odysseyVersion")
                implementation("com.adeo:kviewmodel-compose:$kviewmodelVersion")
                implementation("com.adeo:kviewmodel-odyssey:$kviewmodelVersion")

            }
        }

        named("desktopMain") {
            dependencies {
                implementation(compose.desktop.common)
            }
        }

        named("androidMain") {
            dependencies {
                implementation("androidx.compose.ui:ui:1.3.2")
                implementation("androidx.compose.ui:ui-tooling:1.3.2")
                implementation("androidx.compose.ui:ui-tooling-preview:1.3.2")
                implementation("androidx.compose.foundation:foundation:1.3.1")
                implementation("androidx.compose.material:material:1.3.1")
                implementation("androidx.activity:activity-compose:1.6.1")
            }
        }
    }
}

android {
    namespace = "com.involta.textile.compose"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }
}
