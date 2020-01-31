package dev.temirlan.analytics.entities

import android.os.Bundle

data class EventParameter(
    val key: String,
    val value: Any
) {

    var child: EventParameter? = null

    constructor(
        key: String,
        value: Any,
        child: EventParameter
    ) : this(key, value) {
        this.child = child
    }

    //region Presentation
    fun toHierarchicalMap(): Map<String, Any> {
        return mapOf(key to (child?.toHierarchicalMap() ?: value))
    }

    fun toLinearMap(): Map<String, Any> {
        return mutableMapOf(key to value).apply {
            child?.let {
                putAll(it.toLinearMap())
            }
        }
    }

    fun toBundle(): Bundle {
        val bundle = Bundle()
        for (entry in toLinearMap()) {
            bundle.putString(entry.key, entry.value.toString())
        }
        return bundle
    }
    //endregion
}