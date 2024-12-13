plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.dampmdmtarea2cdva"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.dampmdmtarea2cdva"
        minSdk = 24
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

    /* Habilitamos biewBinding y dataBinding (para evitar el uso de findViewById)
    - biewBindiwng: crea clases que permite acceder fácilmente a los componentes de la interfaz de usuario en los XML
    - dataBinding: permite enlazar directamente las propiedades de tu modelo de datos (por ejemplo un ViewModel) */
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

/* Incluimos las dependencias re recyclerview, cardview y las dos de navegación que us Lindsay */
dependencies {
    implementation(libs.core.splashscreen)
    implementation(libs.recyclerview)
    implementation(libs.cardview)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}