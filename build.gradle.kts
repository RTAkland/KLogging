@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    id("maven-publish")
    kotlin("multiplatform") version "2.1.20" apply false
}

val libVersion: String by extra

allprojects {
    group = "cn.rtast.klogging"
    version = libVersion

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "maven-publish")
    apply(plugin = "org.jetbrains.kotlin.multiplatform")

    publishing {
        repositories {
            mavenLocal()
            maven("https://repo.maven.rtast.cn/releases") {
                credentials {
                    username = "RTAkland"
                    password = System.getenv("PUBLISH_TOKEN")
                }
            }
        }
    }
}