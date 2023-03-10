plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    //kotlin("kapt")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.7.10"
}

version = "0.0.1"

kotlin {
    android()
    ios()
    jvm("desktop")
/*    iosX64()
    iosArm64()
    iosSimulatorArm64()*/

    cocoapods {
        summary = "Textile IOS SDK"
        homepage = "https://tp-iv.ru/"
        /* version = "1.0"*/
        ios.deploymentTarget = "14.0"
        /*podfile = project.file("../iosApp/Podfile")*/
        framework {
            transitiveExport = false
            /*isStatic = true*/
            baseName = "SharedSDK"
            //export(project(":shared"))
        }
    }

    sourceSets {
        /*  val commonMain by getting
          val commonTest by getting {
              dependencies {
                  implementation(kotlin("test"))
              }
          }
          val androidMain by getting
          val androidTest by getting
          val iosX64Main by getting
          val iosArm64Main by getting
          val iosSimulatorArm64Main by getting
          val iosMain by creating {
              dependsOn(commonMain)
              iosX64Main.dependsOn(this)
              iosArm64Main.dependsOn(this)
              iosSimulatorArm64Main.dependsOn(this)
          }
          val iosX64Test by getting
          val iosArm64Test by getting
          val iosSimulatorArm64Test by getting
          val iosTest by creating {
              dependsOn(commonTest)
              iosX64Test.dependsOn(this)
              iosArm64Test.dependsOn(this)
              iosSimulatorArm64Test.dependsOn(this)
          }*/
        val ktorVersion = "2.1.0"
        val kviewmodelVersion = "0.12"
        val odysseyVersion = "1.3.0"

        named("commonMain") {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.3")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")


                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-json:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")

                implementation("com.adeo:kviewmodel:$kviewmodelVersion")


                /*  implementation("com.adeo:kviewmodel-compose:$kviewmodelVersion")
                  implementation("com.adeo:kviewmodel-odyssey:$kviewmodelVersion")*/

                implementation("org.kodein.di:kodein-di:7.15.1")
            }
        }

        named("desktopMain") {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
            }
        }

        named("iosMain") {
            dependencies {
                implementation("io.ktor:ktor-client-ios:$ktorVersion")
            }
        }

        named("androidMain") {
            dependencies {
                implementation("io.ktor:ktor-client-android:$ktorVersion")
            }
        }
    }
}

android {
    namespace = "com.involta.textile.shared"
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