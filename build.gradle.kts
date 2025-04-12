@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("maven-publish")
    kotlin("multiplatform") version "2.1.20"
}

val libVersion: String by extra

group = "cn.rtast.klogging"
version = libVersion

repositories {
    mavenCentral()
}

kotlin {
    explicitApi()
    jvm {
        compilerOptions.jvmTarget = JvmTarget.JVM_1_8
    }
    mingwX64()
    linuxX64()
    linuxArm64()
    macosX64()
    macosArm64()
    js(IR) {
        nodejs()
    }
    wasmJs {
        nodejs()
    }
    watchosArm32()
    watchosArm64()
    watchosDeviceArm64()
    watchosSimulatorArm64()
    watchosX64()
    tvosArm64()
    tvosSimulatorArm64()
    tvosX64()

    compilerOptions {
        freeCompilerArgs.apply {
            add("-Xexpect-actual-classes")
        }
    }

    sourceSets {
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}

publishing {
    repositories {
        maven("https://maven.rtast.cn/releases") {
            credentials {
                username = "RTAkland"
                password = System.getenv("PUBLISH_TOKEN")
            }
        }
    }
}