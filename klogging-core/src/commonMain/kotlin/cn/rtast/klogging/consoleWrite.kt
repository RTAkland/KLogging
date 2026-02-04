/*
 * Copyright © 2026 RTAkland
 * Author: RTAkland
 * Date: 2026/2/1
 */


package cn.rtast.klogging

internal expect fun Logger.writeToConsole(content: String, level: LogLevel)

public expect open class Logger()