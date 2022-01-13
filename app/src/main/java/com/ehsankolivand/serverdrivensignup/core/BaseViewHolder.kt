package com.ehsankolivand.serverdrivensignup.core

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder(open val binding: ViewBinding)
    : RecyclerView.ViewHolder(binding.root) {
}
