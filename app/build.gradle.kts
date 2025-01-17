plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
}


android {
    namespace = "com.mediaeditor.app"
    compileSdk = 35

    defaultConfig {
        minSdk = 27
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        buildConfig = true
    }

}

dependencies {


    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // ============== Glide ==============
    implementation (libs.glide)

    // ============== FFMpeg ==============
    implementation (libs.mobile.ffmpeg.full)
    api(libs.media3.exoplayer)
    api(libs.media3.ui)
    api(libs.media3.exoplayer.hls)
    implementation(libs.media3.datasource.cronet)

    // ============== intuit for different devices size ==============
    implementation (libs.sdp.android)
    implementation (libs.ssp.android)

    // ============= Color Picker ===========
    implementation(libs.colorseekbar)

    // ==============Logging==============
    implementation(libs.timber)

    // ==============RxJava==============
    implementation(libs.rxandroid)
    implementation(libs.rxjava)


    // ============= Photo Crop ===========
    implementation(libs.ucrop)

    // ============= Video Crop ===========
    implementation(project(":videcrop"))
}

publishing {
    publications {
        register<MavenPublication>("release") {
            afterEvaluate {
                from(components["release"])
                groupId = "com.github.sahil"
                artifactId = "media-editor"
                version = "1.0.5"
            }
        }
    }
}
