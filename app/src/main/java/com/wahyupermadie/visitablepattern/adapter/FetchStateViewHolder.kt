package com.wahyupermadie.visitablepattern.adapter

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import com.wahyupermadie.visitablepattern.R
import com.wahyupermadie.visitablepattern.base.AbstractViewHolder
import com.wahyupermadie.visitablepattern.model.FetchState.FAILURE
import com.wahyupermadie.visitablepattern.model.FetchState.LOADING
import com.wahyupermadie.visitablepattern.model.FetchStateModel

class FetchStateViewHolder(
    val binding: View,
    val context: Context
): AbstractViewHolder<FetchStateModel>(binding) {

    private var fetchStateViewHolderListener: FetchStateViewHolderListener

    init {
        fetchStateViewHolderListener = context as FetchStateViewHolderListener
    }

    override fun bind(element: FetchStateModel) {
        when(element.fetchState) {
            is LOADING -> {
                binding.findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
                binding.findViewById<Button>(R.id.retryBtn).visibility = View.GONE
            }
            is FAILURE -> {
                binding.findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
                binding.findViewById<Button>(R.id.retryBtn).visibility = View.VISIBLE
            }
        }

        binding.findViewById<Button>(R.id.retryBtn).setOnClickListener {
            fetchStateViewHolderListener.onRetryClicked()
        }
    }

    fun setLoading() {

    }

    interface FetchStateViewHolderListener {
        fun onRetryClicked()
    }
}