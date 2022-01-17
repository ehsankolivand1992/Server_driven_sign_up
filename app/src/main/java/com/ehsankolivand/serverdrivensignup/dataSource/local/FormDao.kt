package com.ehsankolivand.serverdrivensignup.dataSource.local

import androidx.room.*
import com.ehsankolivand.serverdrivensignup.dataSource.remote.RemoteFormModel

@Dao
abstract class FormDao {

    @Query("SELECT * FROM RemoteFormModel")
    abstract fun getFormData(): RemoteFormModel

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertFormData(modelForms: RemoteFormModel)


    @Update
    abstract fun updateFormData(modelForms: RemoteFormModel)

}
