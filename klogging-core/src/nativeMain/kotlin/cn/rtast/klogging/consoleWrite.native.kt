/*
 * Copyright © 2026 RTAkland
 * Author: RTAkland
 * Date: 2026/2/1
 */

@file:OptIn(ExperimentalForeignApi::class)

package cn.rtast.klogging

import kotlinx.cinterop.ExperimentalForeignApi
import platform.posix.fprintf
import platform.posix.stderr

internal actual fun writeToConsole(content: String, level: LogLevel) {
    when (level) {
        LogLevel.DEBUG -> println(content)
        LogLevel.INFO -> println(content)
        LogLevel.WARN -> println(content)
        LogLevel.ERROR -> fprintf(stderr, "%s\n", content)
        LogLevel.RESET -> println(content)
    }
}