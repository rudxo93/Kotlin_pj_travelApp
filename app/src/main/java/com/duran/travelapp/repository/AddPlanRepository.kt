package com.duran.travelapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.duran.travelapp.database.AddPlanDatabase
import com.duran.travelapp.dto.AddPlanDto

private const val DATABASE_NAME = "addPlan-database.db"

class AddPlanRepository private constructor(context: Context) {

    private val database: AddPlanDatabase = Room.databaseBuilder(
        context.applicationContext,
        AddPlanDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val addPlanDao = database.addPlanDao()

    fun list() : LiveData<MutableList<AddPlanDto>> = addPlanDao.list()

    fun getPlan(id: Long): AddPlanDto = addPlanDao.selectOne(id)

    fun insert(dto: AddPlanDto) = addPlanDao.insert(dto)

    suspend fun update(dto: AddPlanDto) = addPlanDao.update(dto)

    fun delete(dto: AddPlanDto) = addPlanDao.delete(dto)

    companion object {
        private var INSTANCE: AddPlanRepository?= null

        fun initialize(context: Context) {
            if(INSTANCE == null) {
                INSTANCE = AddPlanRepository(context)
            }
        }

        fun get(): AddPlanRepository {
            return INSTANCE ?:
            throw IllegalStateException("AddPlanRepository must be initialized")
        }
    }

}