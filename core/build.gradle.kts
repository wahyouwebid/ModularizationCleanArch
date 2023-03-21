import dependencies.Dependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = 33

    defaultConfig {
        namespace = "com.wahyouwebid.core"
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFile("customer-rules.pro")
    }
    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles (
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = true
            proguardFiles (
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Dependencies.ANDROIDX_CORE)
    implementation(Dependencies.ANDROIDX_APPCOMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.ANDROIDX_CONSTRAINT_LAYOUT)
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.FRAGMENT_KTX)
    implementation(Dependencies.NAVIGATION_UI)

    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_COMPILER)
    kapt(Dependencies.ANDROIDX_HILT_COMPILER)

    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.CONVERTER_GSON)
    implementation(Dependencies.OKHTTP)
    implementation(Dependencies.OKHTTP_INTERCEPTOR)

    implementation(Dependencies.RX_ANDROID)
    implementation(Dependencies.RX_JAVA)
    implementation(Dependencies.RX_JAVA_ADAPTER)

    implementation(Dependencies.VIEW_MODEL_KTX)
    implementation(Dependencies.RUNTIME_KTX)

    implementation(Dependencies.GLIDE)
    kapt(Dependencies.GLIDE_COMPILER)

    implementation(Dependencies.VIEW_MODEL_DELEGATE)
    implementation(Dependencies.SWIPE_REFRESH)
    implementation(Dependencies.LOTTIE)
    implementation(Dependencies.ANDROIDX_SECURITY_CRYPTO)
}
