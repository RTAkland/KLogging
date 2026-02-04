/*
 * Copyright © 2026 RTAkland
 * Author: RTAkland
 * Date: 2026/2/1
 */

package cn.rtast.klogging

internal actual fun Logger.writeToConsole(content: String, level: LogLevel) {
    when (level) {
        LogLevel.RESET -> Unit
        else -> println(content)
    }
}

public actual open class Logger