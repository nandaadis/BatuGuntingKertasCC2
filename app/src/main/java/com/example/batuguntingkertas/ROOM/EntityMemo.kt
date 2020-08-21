package com.example.batuguntingkertas.ROOM

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity
@Parcelize
data class EntityMemo(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name = "Tanggal") var Tanggal:String,
    @ColumnInfo(name = "IsiMemo") var IsiMemo:String
): Parcelable