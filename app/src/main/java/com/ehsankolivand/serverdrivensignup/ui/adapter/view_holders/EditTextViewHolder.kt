package com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import com.ehsankolivand.serverdrivensignup.core.base.BaseViewHolder
import com.ehsankolivand.serverdrivensignup.dataSource.models.Data
import com.ehsankolivand.serverdrivensignup.databinding.RvItemEdittextBinding

class EditTextViewHolder(override val binding: RvItemEdittextBinding,
                         override val context: Context) :
    BaseViewHolder(binding,context) {

    private lateinit var localData:Data
    private lateinit var dataChanged: (Int, Data) -> Unit

    override fun bind(data: Data, dataChanged: (Int, Data) -> Unit,postion:Int)
    {
        var name = data.name
        name += if (data.isRequired) {
            " (Required)"
        }else{
            " (optional)"

        }

        this.dataChanged = dataChanged
        localData = data
        binding.txtTitle.text = name
        binding.ofName.hint = data.values.hint.toString()


        if (!data.answer.isNullOrBlank())
        {
            binding.tfName.setText(data.answer)
        }

        binding.tfName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                data.answer = p0.toString()
                dataChanged(postion,data)
            }

            override fun afterTextChanged(p0: Editable?) {
            }


        })



    }


}