package com.ehsankolivand.serverdrivensignup.dataSource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ehsankolivand.serverdrivensignup.dataSource.models.ModelForms
import com.ehsankolivand.serverdrivensignup.dataSource.models.RemoteFormModel

@Dao
abstract class FormDao {

    @Query("SELECT * FROM RemoteFormModel")
    abstract fun getFormData(): RemoteFormModel

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertFormData(modelForms: RemoteFormModel)

}
