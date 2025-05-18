// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    // Agregar el plugin de Google Services desde el archivo libs.versions.toml
    alias(libs.plugins.google.services) apply false
    alias(libs.plugins.hilt) apply false

}