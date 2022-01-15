package com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders

import android.content.Context
import android.widget.RadioButton
import com.ehsankolivand.serverdrivensignup.core.base.BaseViewHolder
import com.ehsankolivand.serverdrivensignup.dataSource.models.Data
import com.ehsankolivand.serverdrivensignup.databinding.RvItemRadiobuttonBinding
import com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders.contract.OnEditTextChanged

class RadioButtonViewHolder(
    override val binding: RvItemRadiobuttonBinding, override val context: Context
) :
    BaseViewHolder(binding, context) {


    override fun bind(data: Data, onEditTextChanged: OnEditTextChanged) {
        var name = data.name
        if (data.isRequired) {
            name += " (Required)"
        }
        binding.txtName.text = name

        binding.rbGroup.apply {

            data.values.options.forEach {
                var radioButton = RadioButton(context)
                radioButton.text = it.value
                radioButton.id = it.key.toInt()
                this.addView(radioButton)
            }



        }
    }
}


