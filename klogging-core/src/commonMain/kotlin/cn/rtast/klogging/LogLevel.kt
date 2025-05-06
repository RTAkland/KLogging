/*
 * Copyright © 2025 RTAkland
 * Author: RTAkland
 * Date: 2025/4/5
 */

package cn.rtast.klogging

public enum class LogLevel(
    public val levelNumber: Int,
    public val loggingColor: String
) {
    DEBUG(0, "\u001B[36m"),
    INFO(1, "\u001B[32m"),
    WARN(2, "\u001B[33m"),
    ERROR(3, "\u001B[31m"),
    RESET(-1, "\u001B[0m")
}