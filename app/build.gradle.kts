plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.appsecurity"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.appsecurity"
        minSdk = 24
        targetSdk = 35
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

    compileOptions { // Java 17 para Compose 2025
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }

    buildFeatures { compose = true }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.6.0-beta01" // empareja con la BOM
    }
}

dependencies {
    /* --- Compose BOM: mantiene versiones coherentes --- */
    implementation(platform("androidx.compose:compose-bom:2025.05.00"))

    /* Núcleo Compose */
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    /* Material 3 + iconos */
    implementation("androidx.compose.material3:material3:1.4.3")
    implementation("androidx.compose.material:material-icons-extended:1.6.0")

    /* Navegación Compose */
    implementation("androidx.navigation:navigation-compose:2.8.0")

    /* Core AndroidX */
    implementation("androidx.core:core-ktx:1.13.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")
    implementation("androidx.activity:activity-compose:1.10.2")
    implementation("androidx.navigation:navigation-compose:2.8.0")


    /* Tests básicos (opcional) */
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.0")
    androidTestImplementation(platform("androidx.compose:compose-bom:2025.05.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
