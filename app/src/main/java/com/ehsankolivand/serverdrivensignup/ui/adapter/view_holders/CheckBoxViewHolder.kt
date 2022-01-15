package com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders

import android.content.Context
import com.ehsankolivand.serverdrivensignup.core.base.BaseViewHolder
import com.ehsankolivand.serverdrivensignup.dataSource.models.Data
import com.ehsankolivand.serverdrivensignup.databinding.RvItemChecklistBinding
import com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders.contract.OnEditTextChanged

class CheckBoxViewHolder(override val binding: RvItemChecklistBinding, override val context: Context) :
    BaseViewHolder(binding,context)
{


    override fun bind(data: Data, onEditTextChanged: OnEditTextChanged) {



    }



}