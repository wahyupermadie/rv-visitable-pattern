package com.wahyupermadie.visitablepattern.model

import com.wahyupermadie.visitablepattern.base.BaseItemModel
import com.wahyupermadie.visitablepattern.factory.ItemTypeFactory

data class FetchStateModel(
    val fetchState: FetchState
) : BaseItemModel {

    override fun id(): Any = FetchState::class.java

    override fun content(): Any = fetchState

    override fun type(typeFactory: ItemTypeFactory): Int {
        return typeFactory.type(this)
    }
}

sealed class FetchState {
    object LOADING : FetchState()
    object FAILURE : FetchState()
}