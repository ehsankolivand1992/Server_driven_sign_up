package com.ehsankolivand.serverdrivensignup.core.base

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.ehsankolivand.serverdrivensignup.dataSource.models.Data
import com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders.contract.OnEditTextChanged

abstract class BaseViewHolder(open val binding: ViewBinding, open val context: Context)
    : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(data: Data, onEditTextChanged: OnEditTextChanged)

}
