import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform") version "2.1.20"
    id("maven-publish")
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

    compilerOptions {
        freeCompilerArgs.apply {
            add("-Xexpect-actual-classes")
        }
    }

    sourceSets {
        commonMain.dependencies {
        }

        nativeMain.dependencies {
        }

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