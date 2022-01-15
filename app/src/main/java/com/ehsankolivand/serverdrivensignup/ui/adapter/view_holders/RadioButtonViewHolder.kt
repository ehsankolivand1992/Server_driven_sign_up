package com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders

import android.content.Context
import android.widget.RadioButton
import com.ehsankolivand.serverdrivensignup.core.base.BaseViewHolder
import com.ehsankolivand.serverdrivensignup.dataSource.models.Data
import com.ehsankolivand.serverdrivensignup.databinding.RvItemRadiobuttonBinding

class RadioButtonViewHolder(
    override val binding: RvItemRadiobuttonBinding, override val context: Context
) :
    BaseViewHolder(binding, context) {


    override fun bind(data: Data, dataChanged: (Int, Data) -> Unit,postion:Int)
    {
        var name = data.name
        name += if (data.isRequired) {
            " (Required)"
        }else{
            " (optional)"

        }
        binding.txtName.text = name

        binding.rbGroup.apply {
            var counter =0

            data.values.options.forEach {
                var radioButton = RadioButton(context)
                radioButton.text = it.value
                radioButton.id = it.key.toInt()
                radioButton.isChecked= it.tick
                this.addView(radioButton)
            }

            binding.rbGroup.setOnCheckedChangeListener { radioGroup, i ->
                data.values.options.map {
                    it.tick = it.key.toInt() == i
                }
                dataChanged(postion,data)
            }
        }

    }
}

