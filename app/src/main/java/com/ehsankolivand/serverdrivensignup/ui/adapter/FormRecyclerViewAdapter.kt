package com.ehsankolivand.serverdrivensignup.ui.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ehsankolivand.serverdrivensignup.core.base.BaseViewHolder
import com.ehsankolivand.serverdrivensignup.dataSource.models.Data
import com.ehsankolivand.serverdrivensignup.dataSource.models.ModelForms
import com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders.ViewHolderFactory
import com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders.contract.Enum_ItemType
import com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders.contract.OnEditTextChanged


class FormRecyclerViewAdapter(private val context: Context)
    :RecyclerView.Adapter<BaseViewHolder>() {

    var dataHolder = ModelForms()
    var datalist = ModelForms()
        set(value) {
            field = value
            dataHolder= value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : BaseViewHolder {
        return ViewHolderFactory.getViewHolder(parent,viewType,context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(datalist.data[position], {position:Int,data:Data ->DataChanged(position,data) },position)
    }

    override fun getItemCount(): Int {

        return datalist.data.size
    }


    override fun getItemViewType(position: Int): Int {

        return Enum_ItemType.valueOf(datalist.data[position].type.uppercase()).ordinal
    }



    private fun DataChanged(position: Int,data: Data)
    {
        dataHolder.data[position] = data
    }


}