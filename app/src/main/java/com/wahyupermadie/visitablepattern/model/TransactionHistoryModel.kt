package com.wahyupermadie.visitablepattern.model

import com.wahyupermadie.visitablepattern.base.BaseItemModel
import com.wahyupermadie.visitablepattern.factory.ItemTypeFactory

data class TransactionHistoryModel(
    val transactionDate : Int,
    val transacationAmount : String,
    val transactionId : Int
): BaseItemModel {
    override fun id(): Any = transactionId
    override fun content(): Any = transacationAmount
    override fun type(typeFactory: ItemTypeFactory): Int {
        return typeFactory.type(this)
    }
}
