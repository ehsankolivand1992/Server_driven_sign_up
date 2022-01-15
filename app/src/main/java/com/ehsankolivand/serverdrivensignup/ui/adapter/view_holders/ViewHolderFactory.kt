package com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ehsankolivand.serverdrivensignup.core.base.BaseViewHolder
import com.ehsankolivand.serverdrivensignup.databinding.RvItemChecklistBinding
import com.ehsankolivand.serverdrivensignup.databinding.RvItemEdittextBinding
import com.ehsankolivand.serverdrivensignup.databinding.RvItemRadiobuttonBinding
import com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders.contract.Enum_ItemType
import java.lang.IllegalArgumentException

object ViewHolderFactory{

    fun getViewHolder(parent: ViewGroup, viewType: Int, context: Context)
            : BaseViewHolder
    {
        return when(viewType)
        {
            Enum_ItemType.CHECK.ordinal ->{
                CheckBoxViewHolder(
                    RvItemChecklistBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    context
                )
            }
            Enum_ItemType.RADIO.ordinal->{
                RadioButtonViewHolder(
                    RvItemRadiobuttonBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    context
                )
            }
            Enum_ItemType.TEXT.ordinal->{
                EditTextViewHolder(
                    RvItemEdittextBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    context
                )
            }
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }
}