/*
 * Copyright © 2026 RTAkland
 * Author: RTAkland
 * Date: 2026/2/1
 */

package cn.rtast.klogging

import java.util.logging.ConsoleHandler
import java.util.logging.Level
import java.util.logging.Logger

private val logger = Logger.getAnonymousLogger()
private val consoleHandler = ConsoleHandler().apply { logger.addHandler(this) }

internal actual fun writeToConsole(content: String, level: LogLevel) {
    when (level) {
        LogLevel.DEBUG -> logger.level = Level.FINE
        LogLevel.INFO -> logger.level = Level.INFO
        LogLevel.WARN -> logger.level = Level.WARNING
        LogLevel.ERROR -> logger.level = Level.SEVERE
        LogLevel.RESET -> logger.level = Level.ALL
    }
    when (level) {
        LogLevel.DEBUG -> logger.fine(content)
        LogLevel.INFO -> logger.info(content)
        LogLevel.WARN -> logger.warning(content)
        LogLevel.ERROR -> logger.severe(content)
        LogLevel.RESET -> logger.info(content)
    }
}