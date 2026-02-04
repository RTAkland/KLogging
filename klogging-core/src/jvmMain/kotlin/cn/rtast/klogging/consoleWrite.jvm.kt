/*
 * Copyright © 2026 RTAkland
 * Author: RTAkland
 * Date: 2026/2/1
 */

package cn.rtast.klogging

internal actual fun Logger.writeToConsole(content: String, level: LogLevel) {
    val stream = when (level) {
        LogLevel.ERROR, LogLevel.WARN -> System.err
        else -> System.out
    }
    val writer = stream.writer(Charsets.UTF_8)
    writer.apply {
        write(content)
        write(LogLevel.RESET.loggingColor)
        write("\n")
        flush()
    }
}

public actual open class Logger