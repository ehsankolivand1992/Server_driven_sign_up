package com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders

import android.content.Context
import com.ehsankolivand.serverdrivensignup.core.base.BaseViewHolder
import com.ehsankolivand.serverdrivensignup.dataSource.models.Data
import com.ehsankolivand.serverdrivensignup.databinding.RvItemEdittextBinding
import com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders.contract.OnEditTextChanged

class EditTextViewHolder(override val binding: RvItemEdittextBinding,
                          override val context: Context
) :
    BaseViewHolder(binding,context) {

    private lateinit var localData: Data

    override fun bind(data: Data, onEditTextChanged: OnEditTextChanged) {

        localData = data
        binding.txtTitle.text = data.name
        binding.ofName.hint = data.values.hint.toString()


        if (!data.answer.isNullOrBlank())
        {
            binding.tfName.setText(data.answer)
        }

    }
}