/*
 * Copyright © 2025 RTAkland
 * Author: RTAkland
 * Date: 2025/4/5
 */

package cn.rtast.klogging

public class KLogging internal constructor(private val name: String, private val prefix: String) {
    public companion object {
        public fun getLogger(name: String, prefix: String = ""): KLogging {
            return KLogging(name, prefix)
        }

        public fun getLogger(prefix: String = ""): KLogging {
            return this.getLogger(this::class.qualifiedName.toString(), prefix)
        }

        public inline fun <reified T> getLogger(type: T, prefix: String = ""): KLogging {
            return this.getLogger(type::class.qualifiedName.toString(), prefix)
        }
    }

    private var logLevel = LogLevel.INFO

    public fun setLoggingLevel(level: LogLevel) {
        logLevel = level
    }

    private fun format(level: LogLevel, message: String) {
        val currentDatetime = getCurrentDatetime()
        val currentThreadName = getCurrentThreadName()
        println(
            "${level.loggingColor}$prefix" +
                    "[${level.name}][$currentDatetime][$currentThreadName]" +
                    "[$name]: $message${LogLevel.RESET.loggingColor}"
        )
    }

    public fun debug(message: String) {
        if (LogLevel.DEBUG.levelNumber < logLevel.levelNumber) return
        this.format(LogLevel.DEBUG, message)
    }

    public fun info(message: String) {
        if (LogLevel.INFO.levelNumber < logLevel.levelNumber) return
        this.format(LogLevel.INFO, message)
    }

    public fun warn(message: String) {
        if (LogLevel.WARN.levelNumber < logLevel.levelNumber) return
        this.format(LogLevel.WARN, message)
    }

    public fun error(message: String) {
        if (LogLevel.ERROR.levelNumber < logLevel.levelNumber) return
        this.format(LogLevel.ERROR, message)
    }

    public fun error(message: String, exception: Exception) {
        if (LogLevel.ERROR.levelNumber < logLevel.levelNumber) return
        this.format(LogLevel.ERROR, "$message\n${exception.stackTraceToString()}")
    }

    public fun error(exception: Exception) {
        if (LogLevel.ERROR.levelNumber < logLevel.levelNumber) return
        this.format(LogLevel.ERROR, exception.stackTraceToString())
    }
}