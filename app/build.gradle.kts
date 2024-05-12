plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.devtools)
    alias(libs.plugins.safeargs)
}

android {
    namespace = "ru.akurbanoff.viewer"
    compileSdk = 34

    defaultConfig {
        applicationId = "ru.akurbanoff.viewer"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Modules
    implementation(project(":core"))
    implementation(project(":feature"))
    implementation(project(":feature:cart"))
    implementation(project(":feature:favorites"))
    implementation(project(":feature:menu"))
    implementation(project(":feature:profile"))
    implementation(project(":feature:home"))

    // Network
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.okhttp.core)
    implementation(libs.retrofit.rxjava.adapter)

    // DI
    implementation(libs.dagger.core)
    implementation(libs.dagger.android)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.fragment.ktx)
    ksp(libs.dagger.compiler)
    ksp(libs.dagger.android.processor)
    implementation(libs.dagger.android.support)
    implementation(libs.javax.inject)

    // Navigation
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    // Biometric
    implementation(libs.biometric)

    // Firebase
    implementation(libs.firebase.analytics)

    // Core
    implementation(libs.view.binding)
    implementation(libs.lifecycle.ext)
    implementation(libs.lifecycle.livedata)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Test
    testImplementation(libs.google.truth)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    kspTest(libs.dagger.core)
    kspTest(libs.dagger.compiler)

}