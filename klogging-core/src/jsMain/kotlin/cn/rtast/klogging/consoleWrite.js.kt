/*
 * Copyright © 2026 RTAkland
 * Author: RTAkland
 * Date: 2026/2/1
 */


package cn.rtast.klogging

internal actual fun writeToConsole(content: String, level: LogLevel) {
    when (level) {
        LogLevel.DEBUG -> console.log(content)
        LogLevel.INFO -> console.log(content)
        LogLevel.WARN -> console.warn(content)
        LogLevel.ERROR -> console.error(content)
        LogLevel.RESET -> console.log(content)
    }
}