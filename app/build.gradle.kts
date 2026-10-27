plugins {
    alias(libs.plugins.android.application)
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.20" // Cambia "1.9.22" por la versión de Kotlin que use tu proyecto
}

android {
    namespace = "com.example.appcursosequipo2"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.appcursosequipo2"
        minSdk = 28
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation("com.github.bumptech.glide:glide:5.0.9")
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.recyclerview)
    implementation(libs.material)
    implementation(libs.protolite.well.known.types)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    //aqui agregamos las librerias retrofit y kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("com.squareup.retrofit2:converter-kotlinx-serialization:2.11.0")
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    //implementation(libs.okhttp)
    //implementation(libs.retrofit)
    //implementation(libs.retrofit.converter.kotlinx)
}