package com.duran.travelapp.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "addPlan")
class AddPlanDto(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "sdate") val sdate: String,
    @ColumnInfo(name = "edate") val edate: String
): Serializable {

}