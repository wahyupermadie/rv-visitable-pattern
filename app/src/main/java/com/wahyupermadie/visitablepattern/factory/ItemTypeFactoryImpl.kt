package com.wahyupermadie.visitablepattern.factory

import android.content.Context
import android.view.View
import androidx.viewbinding.ViewBinding
import com.wahyupermadie.visitablepattern.R
import com.wahyupermadie.visitablepattern.adapter.FetchStateViewHolder
import com.wahyupermadie.visitablepattern.adapter.TransactionBannerViewHolder
import com.wahyupermadie.visitablepattern.adapter.TransactionHistoryViewHolder
import com.wahyupermadie.visitablepattern.base.AbstractViewHolder
import com.wahyupermadie.visitablepattern.databinding.ItemBannerBinding
import com.wahyupermadie.visitablepattern.databinding.ItemFetchStateBinding
import com.wahyupermadie.visitablepattern.databinding.ItemTransactionBinding
import com.wahyupermadie.visitablepattern.model.FetchStateModel
import com.wahyupermadie.visitablepattern.model.TransactionBannerModel
import com.wahyupermadie.visitablepattern.model.TransactionHistoryModel

class ItemTypeFactoryImpl : ItemTypeFactory {

    override fun type(typeFactory: TransactionBannerModel): Int {
        return R.layout.item_banner
    }

    override fun type(typeFactory: TransactionHistoryModel): Int {
        return R.layout.item_transaction
    }

    override fun type(typeFactory: FetchStateModel): Int {
        return R.layout.item_fetch_state
    }

    override fun createViewHolder(parent: View, type: Int, context: Context): AbstractViewHolder<*> {
        return when(type) {
            R.layout.item_banner -> TransactionBannerViewHolder(parent)
            R.layout.item_transaction -> TransactionHistoryViewHolder(parent)
            else -> FetchStateViewHolder(parent, context)
        }
    }
}