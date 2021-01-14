plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(30)

    defaultConfig {
        applicationId = "com.vanced.faq"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 10
        versionName = "1.0"

        vectorDrawables.useSupportLibrary = true
    }

    lintOptions {
        disable("MissingTranslation", "ExtraTranslation")
    }

    applicationVariants.all {
        resValue("string", "versionName", versionName)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/*.kotlin_module")
    }

// To inline the bytecode built with JVM target 1.8 into
// bytecode that is being built with JVM target 1.6. (e.g. navArgs)

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

}

dependencies {

// Kotlin
    implementation(kotlin("stdlib-jdk8"))

// AndroidX
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.fragment:fragment-ktx:1.2.5")
    implementation("androidx.lifecycle:lifecycle-livedata-core-ktx:2.2.0")

    //Appearance
    implementation("com.google.android.material:material:1.3.0-beta01")

    // JSON parser
    implementation("com.beust:klaxon:5.4")

}