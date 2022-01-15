package com.ehsankolivand.serverdrivensignup.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ehsankolivand.serverdrivensignup.core.base.BaseViewHolder
import com.ehsankolivand.serverdrivensignup.dataSource.models.Data
import com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders.ViewHolderFactory
import com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders.contract.Enum_ItemType
import com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders.contract.OnEditTextChanged


class FormRecyclerViewAdapter constructor(
    private val context: Context,
    private val onEditTextChanged: OnEditTextChanged
)
    : RecyclerView.Adapter<BaseViewHolder>() {


     var datalist = listOf<Data>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : BaseViewHolder {
        return ViewHolderFactory.getViewHolder(parent,viewType,context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(datalist[position],onEditTextChanged)
    }

    override fun getItemCount(): Int {

        return datalist.size
    }

    override fun getItemViewType(position: Int): Int {

        return Enum_ItemType.valueOf(datalist[position].type.uppercase()).ordinal
    }
}