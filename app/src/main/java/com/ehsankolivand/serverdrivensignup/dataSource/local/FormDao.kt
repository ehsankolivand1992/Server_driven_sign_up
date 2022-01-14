package com.ehsankolivand.serverdrivensignup.dataSource.local

import androidx.room.Dao
import androidx.room.Query
import com.ehsankolivand.serverdrivensignup.dataSource.models.ModelForms

@Dao
abstract class FormDao {

    @Query("SELECT * FROM ModelForms")
    abstract fun getFormData(): ModelForms

}
