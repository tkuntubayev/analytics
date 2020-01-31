package dev.temirlan.analytics

import dev.temirlan.analytics.entities.EventParameter
import dev.temirlan.analytics.entities.UserInfo

class BaseAnalyticsFacade private constructor(
    private val analytics: List<Analytics>
) : Analytics {

    class Builder {
        private val analytics = ArrayList<Analytics>()

        fun add(analytics: Analytics): Builder {
            this.analytics.add(analytics)
            return this
        }

        fun build(): BaseAnalyticsFacade {
            return BaseAnalyticsFacade(analytics)
        }
    }

    override fun sendEvent(eventName: String) {
        analytics.forEach {
            it.sendEvent(eventName)
        }
    }

    override fun sendEvent(eventName: String, vararg eventParameters: EventParameter) {
        analytics.forEach {
            it.sendEvent(eventName, *eventParameters)
        }
    }

    override fun updateUserInfo(userInfo: UserInfo) {
        analytics.forEach {
            it.updateUserInfo(userInfo)
        }
    }
}