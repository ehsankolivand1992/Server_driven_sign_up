package com.ehsankolivand.serverdrivensignup.dataSource.pagingtest

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "form_remote_keys")
data class FormRemoteKeys(
    @PrimaryKey val pageId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)