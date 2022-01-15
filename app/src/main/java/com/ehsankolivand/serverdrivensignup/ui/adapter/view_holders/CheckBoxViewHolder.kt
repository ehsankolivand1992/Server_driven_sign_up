package com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders

import android.content.Context
import android.widget.CheckBox
import android.widget.CompoundButton
import com.ehsankolivand.serverdrivensignup.core.base.BaseViewHolder
import com.ehsankolivand.serverdrivensignup.dataSource.models.Data
import com.ehsankolivand.serverdrivensignup.databinding.RvItemChecklistBinding

class CheckBoxViewHolder(override val binding: RvItemChecklistBinding, override val context: Context) :
    BaseViewHolder(binding,context)
{

    private lateinit var localData:Data
    private lateinit var dataChanged: (Int, Data) -> Unit
    private  var postion: Int=0

    override fun bind(data: Data, dataChanged: (Int, Data) -> Unit,postion:Int)
    {

        this.postion = postion
        localData = data
        this.dataChanged = dataChanged

        var name = data.name
        name += if (data.isRequired) {
            " (Required)"
        }else{
            " (optional)"

        }
        binding.txtName.text = name
        binding.llContainer.apply {

            data.values.options.forEachIndexed { index, it ->
                val checkBox = CheckBox(context)
                checkBox.id = index
                checkBox.text = it.value
                checkBox.setOnCheckedChangeListener(CheckBoxListener())
                checkBox.isChecked = it.tick
                addView(checkBox)
            }
        }


    }


    inner class CheckBoxListener() :
        CompoundButton.OnCheckedChangeListener{
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            if (p0 != null) {
                localData.values.options[p0.id].tick = p1
            }
            dataChanged(postion,localData)
        }

    }

}
