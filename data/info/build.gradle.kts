plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.hilt.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
    namespace = "com.mindera.data.info"
    compileSdk = 35

    defaultConfig {
        minSdk = 33

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":domain:info"))
    implementation(project(":core:network"))

    implementation(libs.androidx.core.ktx)

    implementation(libs.hilt.android)
    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)

    kapt(libs.hilt.android.compiler)
}