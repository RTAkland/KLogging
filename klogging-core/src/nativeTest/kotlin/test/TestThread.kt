/*
 * Copyright © 2025 RTAkland
 * Author: RTAkland
 * Date: 2025/4/5
 */

package test

import cn.rtast.klogging.KLogging
import cn.rtast.klogging.LogLevel
import cn.rtast.klogging.getCurrentThreadName
import kotlin.test.Test

class TestThread {
    @Test
    fun `Test get current thread name`() {
        println(getCurrentThreadName())
    }

    @Test
    fun `Test Logging`() {
        val logger1 = KLogging.getLogger("Test1").apply {
            setLoggingLevel(LogLevel.ERROR)
        }
        val logger2 = KLogging.getLogger("Test2").apply {
            setLoggingLevel(LogLevel.DEBUG)
        }
        logger1.info("info")
        logger1.error("error")
        logger2.debug("debug")
        logger2.error("1", Exception("111"))
        logger2.error(Exception("111"))
    }
}