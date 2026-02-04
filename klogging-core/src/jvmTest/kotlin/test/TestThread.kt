/*
 * Copyright © 2025 RTAkland
 * Author: RTAkland
 * Date: 2025/4/5
 */

package test

import cn.rtast.klogging.KLogging
import cn.rtast.klogging.LogLevel
import cn.rtast.klogging.getCurrentThreadName
import org.junit.Test

class TestThread {
    @Test
    fun `Test get current thread name`() {
        println(getCurrentThreadName())
    }

    @Test
    fun `Test Logging`() {
        val logger2 = KLogging.getLogger("Test2", "[S]").apply {
            setLoggingLevel(LogLevel.DEBUG)
        }
        logger2.debug("debug")
        logger2.debug("中文测试")
        println("test")

    }
}