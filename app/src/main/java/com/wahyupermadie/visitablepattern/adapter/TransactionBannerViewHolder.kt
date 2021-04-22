package com.wahyupermadie.visitablepattern.adapter

import android.view.View
import android.widget.TextView
import com.wahyupermadie.visitablepattern.R
import com.wahyupermadie.visitablepattern.base.AbstractViewHolder
import com.wahyupermadie.visitablepattern.databinding.ItemBannerBinding
import com.wahyupermadie.visitablepattern.model.TransactionBannerModel

class TransactionBannerViewHolder(
    val binding: View
): AbstractViewHolder<TransactionBannerModel>(binding) {

    override fun bind(element: TransactionBannerModel) {
        binding.findViewById<TextView>(R.id.idTransaksi).text = element.idTransaction
        binding.findViewById<TextView>(R.id.totalTransaksi).text = element.transactionAmount
    }
}