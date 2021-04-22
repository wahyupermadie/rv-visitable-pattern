package com.wahyupermadie.visitablepattern.model

import com.wahyupermadie.visitablepattern.base.BaseItemModel
import com.wahyupermadie.visitablepattern.factory.ItemTypeFactory

data class TransactionBannerModel(
    val idTransaction: String,
    val transactionAmount: String
): BaseItemModel {
    override fun id(): Any = idTransaction
    override fun content(): Any = transactionAmount
    override fun type(typeFactory: ItemTypeFactory): Int {
        return typeFactory.type(this)
    }
}