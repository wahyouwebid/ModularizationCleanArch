import dependencies.Dependencies

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = 33

    defaultConfig {
        namespace = "com.wahyouwebid.beritaku"
        minSdk = 23
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    implementation(project(":modules:news"))
    implementation(project(":core"))

    implementation(Dependencies.ANDROIDX_CORE)
    implementation(Dependencies.ANDROIDX_APPCOMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.ANDROIDX_CONSTRAINT_LAYOUT)
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)

    implementation(Dependencies.LOTTIE)
    implementation(Dependencies.HILT)
    implementation(Dependencies.ROOM)

    testImplementation(Dependencies.JUNIT)
    androidTestImplementation(Dependencies.ANDROIDX_JUNIT)
    androidTestImplementation(Dependencies.ESPRESSO)

    kapt(Dependencies.HILT_COMPILER)
    kapt(Dependencies.ANDROIDX_HILT_COMPILER)
    kapt(Dependencies.ROOM_COMPILER)
}
