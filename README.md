# KLogging

A lightweight kotlin multiplatform logging framework support several platforms

- jvm(1.8)
- mingwX64
- linuxX64
- linuxArm64
- macosX64
- macosArm64
- js(IR)(nodejs)
- wasmJs(nodejs)
- watchosArm32
- watchosArm64
- watchosDeviceArm64
- watchosSimulatorArm64
- watchosX64
- tvosArm64
- tvosSimulatorArm64
- tvosX64
- iosArm64
- iosSimulatorArm64
- iosX64

# Usage

```kotlin
// build.gradle.kts
repositories {
    maven("https://repo.maven.rtast.cn/releases/")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation("cn.rtast.klogging:klogging:<version>")
        }
    }
}

// main.kt

fun main() {
    val logger1 = KLogging.getLogger("Test1").apply {
        setLoggingLevel(LogLevel.ERROR)
    }
    val logger2 = KLogging.getLogger("Test2").apply {
        setLoggingLevel(LogLevel.DEBUG)
    }
    logger1.info("info")
    logger1.error("error")
    logger2.debug("debug")
}
```

> The latest version can be found at https://repo.maven.rtast.cn/listing/releases/cn/rtast/klogging/klogging

# 中文文档

# KLogging

轻量级的Kotlin multiplatform的日志框架, 无任何依赖即可使用, 按照上方的配置即可使用
