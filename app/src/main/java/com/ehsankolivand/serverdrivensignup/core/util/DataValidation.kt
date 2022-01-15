package com.ehsankolivand.serverdrivensignup.core.util

import android.widget.RadioButton
import com.ehsankolivand.serverdrivensignup.dataSource.models.Data
import com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders.contract.Enum_ItemType

fun Datavalidation(data: List<Data>):Boolean
{
    var valid = true
    data.forEach {
        if (it.isRequired) {
            when (Enum_ItemType.valueOf(it.type.uppercase()).ordinal)
            {
                Enum_ItemType.RADIO.ordinal -> {
                 valid = RadioButtonValidator(it)
                }
                Enum_ItemType.CHECK.ordinal -> {
                    valid = CheckBoxValidator(it)
                }
                Enum_ItemType.TEXT.ordinal -> {
                    valid = TextValidator(it)
            }
            }
        }
    }
    return valid

}
private fun TextValidator(data: Data):Boolean
{
    return data.answer.isNotEmpty()
}
private fun CheckBoxValidator(data: Data):Boolean
{
    var result = false
    data.values.options.forEach {
        if (it.tick)
        {
            result=true
        }
    }
    return result
}
private fun RadioButtonValidator(data: Data):Boolean
{
    var result = false
    data.values.options.forEach {
        if (it.tick)
        {
            result=true
        }
    }
    return result
}
