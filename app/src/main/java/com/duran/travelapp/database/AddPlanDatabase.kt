package com.duran.travelapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.duran.travelapp.dao.AddPlanDao
import com.duran.travelapp.dto.AddPlanDto

@Database(entities = arrayOf(AddPlanDto::class), version = 1)
abstract class AddPlanDatabase : RoomDatabase() {
    abstract fun addPlanDao(): AddPlanDao
}