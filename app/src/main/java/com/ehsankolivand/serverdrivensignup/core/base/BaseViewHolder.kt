package com.ehsankolivand.serverdrivensignup.core.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder(open val binding: ViewBinding)
    : RecyclerView.ViewHolder(binding.root) {
}
