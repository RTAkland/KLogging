/*
 * Copyright © 2025 RTAkland
 * Date: 2025/5/7 00:29
 * Open Source Under Apache-2.0 License
 * https://www.apache.org/licenses/LICENSE-2.0
 */

package cn.rtast.klogging.filesystem

public expect fun File.appendLine(content: String)

public expect fun File.readText(): String