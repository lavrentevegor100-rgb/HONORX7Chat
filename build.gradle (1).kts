plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.honorx7chat"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.honorx7chat"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
}
