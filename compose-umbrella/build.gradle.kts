plugins {
    kotlin("multiplatform")
    kotlin("kapt")
    id("org.jetbrains.compose")
    id("com.android.library")
}

val kviewmodelVersion = "0.14"
val odysseyVersion = "1.3.0"

kotlin {
    android()


    sourceSets {


        named("commonMain") {
            dependencies {
                implementation(project(":shared"))
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.ui)
                implementation(compose.materialIconsExtended)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

                implementation("io.github.alexgladkov:odyssey-core:$odysseyVersion")
                implementation("io.github.alexgladkov:odyssey-compose:$odysseyVersion")
                implementation("com.adeo:kviewmodel-compose:$kviewmodelVersion")
                implementation("com.adeo:kviewmodel-odyssey:$kviewmodelVersion")

            }
        }

        named("androidMain") {
            dependencies {
                implementation("androidx.compose.ui:ui:1.4.3")
                implementation("androidx.compose.ui:ui-tooling:1.4.3")
                implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
                implementation("androidx.compose.foundation:foundation:1.4.3")
                //implementation("androidx.compose.material:material:1.4.3")
                implementation("androidx.activity:activity-compose:1.7.1")
                implementation("androidx.compose.material3:material3:1.1.0")
                implementation("androidx.compose.material3:material3-window-size-class:1.1.0")
            }
        }
    }
}

android {
    namespace = "com.involta.diamant.compose"
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

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}
