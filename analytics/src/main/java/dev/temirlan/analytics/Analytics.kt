package dev.temirlan.analytics

import dev.temirlan.analytics.entities.EventParameter
import dev.temirlan.analytics.entities.UserInfo

interface Analytics {
    fun sendEvent(eventName: String)

    fun sendEvent(eventName: String, vararg eventParameters: EventParameter)

    fun updateUserInfo(userInfo: UserInfo)
}