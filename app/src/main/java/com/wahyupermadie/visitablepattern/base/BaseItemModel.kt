package com.wahyupermadie.visitablepattern.base

import com.wahyupermadie.visitablepattern.factory.ItemTypeFactory

interface BaseItemModel {

    fun id(): Any

    fun content(): Any

    fun payload(other: Any): Payloadable = Payloadable.None

    fun type(typeFactory: ItemTypeFactory): Int

    /**
     * Simple marker interface for payloads
     */

    interface Payloadable {
        object None: Payloadable
    }
}