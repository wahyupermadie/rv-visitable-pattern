package com.wahyupermadie.visitablepattern.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wahyupermadie.visitablepattern.factory.ItemTypeFactory
import com.wahyupermadie.visitablepattern.model.FetchState
import com.wahyupermadie.visitablepattern.model.FetchStateModel
import com.wahyupermadie.visitablepattern.utils.ListUpdateCallBack

class HomeAdapter(
    private val adapterTypeFactory: ItemTypeFactory,
    private val context: Context
): RecyclerView.Adapter<AbstractViewHolder<BaseItemModel>>() {

    companion object {
        private val loading = FetchStateModel(FetchState.LOADING)
        private val error = FetchStateModel(FetchState.FAILURE)
    }
    private var itemList : MutableList<BaseItemModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder<BaseItemModel> {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return adapterTypeFactory.createViewHolder(view, viewType, context) as AbstractViewHolder<BaseItemModel>
    }

    override fun onBindViewHolder(holder: AbstractViewHolder<BaseItemModel>, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].type(adapterTypeFactory)
    }

    fun submitData(items: MutableList<BaseItemModel>) {
        val oldSize = itemList.size
        itemList.addAll(oldSize, items)
        notifyItemRangeInserted(oldSize, oldSize+items.size)
    }

    fun submitData(item: BaseItemModel) {
        val oldSize = itemList.size
        itemList.add(oldSize, item)
        notifyItemInserted(oldSize)
    }

    fun removed(index: FetchStateModel) {
        itemList.remove(index)
        notifyItemRemoved(itemList.size - 1)
    }

    fun showLoading() {
        if (itemList[itemList.size - 1] is FetchStateModel) {
            itemList.removeAt(itemList.size - 1)
            notifyItemRemoved(itemList.size - 1)
        }
        this.submitData(loading)
    }

    fun hideLoading(){
        itemList.remove(loading)
        notifyItemRemoved(itemList.size - 1)
    }

    fun setError() {
        if (itemList[itemList.size - 1] is FetchStateModel) {
            itemList.removeAt(itemList.size - 1)
            notifyItemRemoved(itemList.size - 1)
        }
        this.submitData(error)
    }

    override fun getItemCount(): Int = itemList.size
}