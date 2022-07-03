package com.duran.travelapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.duran.travelapp.dto.AddPlanDto

@Dao
interface AddPlanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dto: AddPlanDto)

    @Query("select * from addPlanTable")
    fun list(): LiveData<MutableList<AddPlanDto>>

    @Query("select * from addPlanTable where id = (:id)")
    fun selectOne(id: Long): AddPlanDto

    @Update
    suspend fun update(dto: AddPlanDto)

    @Delete
    fun delete(dto: AddPlanDto)

}