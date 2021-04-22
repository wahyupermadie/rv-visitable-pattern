package com.wahyupermadie.visitablepattern.utils

import androidx.recyclerview.widget.ListUpdateCallback
import com.wahyupermadie.visitablepattern.base.HomeAdapter

class ListUpdateCallBack : ListUpdateCallback {
    var firstInsert = -1
    var mAdapter: HomeAdapter? = null
    fun bind(adapter: HomeAdapter?) {
        this.mAdapter = adapter
    }

    override fun onChanged(position: Int, count: Int, payload: Any?) {
        mAdapter?.notifyItemRangeChanged(position, count, payload)
    }

    override fun onInserted(position: Int, count: Int) {
        if (firstInsert == -1 || firstInsert > position) {
            firstInsert = position
        }
        mAdapter?.notifyItemRangeInserted(position, count)
    }

    override fun onMoved(fromPosition: Int, toPosition: Int) {
        mAdapter?.notifyItemMoved(fromPosition, toPosition)
    }

    override fun onRemoved(position: Int, count: Int) {
        mAdapter?.notifyItemRangeRemoved(position, count)
    }
}