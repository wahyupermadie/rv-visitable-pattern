package com.wahyupermadie.visitablepattern.adapter

import android.view.View
import android.widget.TextView
import com.wahyupermadie.visitablepattern.R
import com.wahyupermadie.visitablepattern.base.AbstractViewHolder
import com.wahyupermadie.visitablepattern.model.TransactionHistoryModel

class TransactionHistoryViewHolder(
    val binding: View
): AbstractViewHolder<TransactionHistoryModel>(binding) {

    override fun bind(element: TransactionHistoryModel) {
        binding.findViewById<TextView>(R.id.idTransaction).text = element.transactionId.toString()
        binding.findViewById<TextView>(R.id.idTransaction).text = element.transacationAmount
    }
}