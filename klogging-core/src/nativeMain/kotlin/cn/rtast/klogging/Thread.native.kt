/*
 * Copyright © 2025 RTAkland
 * Author: RTAkland
 * Date: 2025/4/5
 */

@file:OptIn(ObsoleteWorkersApi::class)

package cn.rtast.klogging

import kotlin.native.concurrent.ObsoleteWorkersApi
import kotlin.native.concurrent.Worker

public actual fun getCurrentThreadName(): String = Worker.current.name