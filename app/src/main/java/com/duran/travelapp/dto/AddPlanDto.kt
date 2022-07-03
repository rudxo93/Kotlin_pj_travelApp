package com.duran.travelapp.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "addPlanTable")
class AddPlanDto(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "sdate") val sdate: String,
    @ColumnInfo(name = "edate") val edate: String
): Serializable { // intent에 객체를 담이 위해 상속받는다.

}