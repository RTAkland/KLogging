/*
 * Copyright © 2025 RTAkland
 * Author: RTAkland
 * Date: 2025/4/5
 */

@file:OptIn(ExperimentalTime::class)

package cn.rtast.klogging

import kotlin.time.Clock
import kotlin.time.ExperimentalTime

private fun padZero(value: Int, length: Int = 2): String {
    return value.toString().padStart(length, '0')
}

private fun formatEpochMillis(epochMillis: Long): String {
    val millisPerDay = 86_400_000L
    val millisOfDay = ((epochMillis % millisPerDay) + millisPerDay) % millisPerDay
    val daysSinceEpoch = epochMillis / millisPerDay
    val hours = (millisOfDay / 3_600_000).toInt()
    val minutes = ((millisOfDay % 3_600_000) / 60_000).toInt()
    val seconds = ((millisOfDay % 60_000) / 1000).toInt()
    val millis = (millisOfDay % 1000).toInt()
    val date = calculateDateFromDays(daysSinceEpoch)
    return "${padZero(date.year, 4)}-${padZero(date.month)}-${padZero(date.day)} " +
            "${padZero(hours)}:${padZero(minutes)}:${padZero(seconds)}.${padZero(millis, 3)}"

}

private data class SimpleDate(val year: Int, val month: Int, val day: Int)

private fun calculateDateFromDays(days: Long): SimpleDate {
    var y = 1970
    var remainingDays = days
    while (true) {
        val daysInYear = if (isLeapYear(y)) 366 else 365
        if (remainingDays >= daysInYear) {
            remainingDays -= daysInYear
            y++
        } else break
    }
    val monthDays = intArrayOf(
        31, if (isLeapYear(y)) 29 else 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    )
    var m = 1
    for (daysInMonth in monthDays) {
        if (remainingDays >= daysInMonth) {
            remainingDays -= daysInMonth
            m++
        } else break
    }
    return SimpleDate(y, m, (remainingDays + 1).toInt())
}

private fun isLeapYear(year: Int): Boolean {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
}

public fun getCurrentDatetime(): String {
    return formatEpochMillis(Clock.System.now().toEpochMilliseconds())
}