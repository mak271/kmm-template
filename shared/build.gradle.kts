plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    //kotlin("kapt")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.8.10"
}

version = "0.0.1"

kotlin {
    android()
    ios()
/*    iosX64()
    iosArm64()
    iosSimulatorArm64()*/

    cocoapods {
        summary = "Diamant IOS SDK"
        homepage = "https://diamant-online.ru/"
        /* version = "1.0"*/
        ios.deploymentTarget = "15.0"
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
        val ktorVersion = "2.3.0"
        val kviewmodelVersion = "0.14"

        named("commonMain") {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.5.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")


                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-json:$ktorVersion")
                implementation("io.ktor:ktor-client-cio:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
                implementation("io.ktor:ktor-client-auth:$ktorVersion")

                implementation("com.russhwolf:multiplatform-settings:1.0.0-RC")
                implementation("com.russhwolf:multiplatform-settings-no-arg:1.0.0-RC")

                implementation("com.adeo:kviewmodel:$kviewmodelVersion")


                /*  implementation("com.adeo:kviewmodel-compose:$kviewmodelVersion")
                  implementation("com.adeo:kviewmodel-odyssey:$kviewmodelVersion")*/

                implementation("org.kodein.di:kodein-di:7.15.1")
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
    namespace = "com.involta.diamant.shared"
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