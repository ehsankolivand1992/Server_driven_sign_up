package com.ehsankolivand.serverdrivensignup.ui.adapter.view_holders.contract

import com.ehsankolivand.serverdrivensignup.dataSource.models.Data

interface OnEditTextChanged {

    fun onTextChanged(position: Int, charSeq: Data)

}