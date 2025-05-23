// Top-level build file where you can add configuration options common to all sub-projects/modules.
//buildscript {
//    extra.apply {
//        set("room_version", "2.5.2")
//    }
//}
//
buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.21")
    }
    extra.apply {
        set("room_version", "2.5.2")
    }
}

plugins {
    id("com.android.application") version "8.1.4" apply false
    id("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false
}

