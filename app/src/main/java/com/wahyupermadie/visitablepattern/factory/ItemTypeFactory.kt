package com.wahyupermadie.visitablepattern.factory

import android.content.Context
import android.view.View
import com.wahyupermadie.visitablepattern.base.AbstractViewHolder
import com.wahyupermadie.visitablepattern.model.FetchStateModel
import com.wahyupermadie.visitablepattern.model.TransactionBannerModel
import com.wahyupermadie.visitablepattern.model.TransactionHistoryModel

interface ItemTypeFactory {
    fun type(typeFactory: TransactionBannerModel): Int
    fun type(typeFactory: TransactionHistoryModel): Int
    fun type(typeFactory: FetchStateModel): Int

    fun createViewHolder(parent: View, type: Int, context: Context): AbstractViewHolder<*>
}