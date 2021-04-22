package com.wahyupermadie.visitablepattern.utils

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil.Callback
import com.wahyupermadie.visitablepattern.base.BaseItemModel

class DiffAdapterCallback(oldEmployeeList: List<BaseItemModel>, newEmployeeList: List<BaseItemModel>) :
    Callback() {

    private val mOldEmployeeList: List<BaseItemModel> = oldEmployeeList
    private val mNewEmployeeList: List<BaseItemModel> = newEmployeeList

    override fun getOldListSize(): Int {
        return mOldEmployeeList.size
    }

    override fun getNewListSize(): Int {
        return mNewEmployeeList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldEmployeeList[oldItemPosition].id() === mNewEmployeeList[newItemPosition].id()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldEmployee: BaseItemModel = mOldEmployeeList[oldItemPosition]
        val newEmployee: BaseItemModel = mNewEmployeeList[newItemPosition]
        return oldEmployee.id() == newEmployee.id()
    }
}