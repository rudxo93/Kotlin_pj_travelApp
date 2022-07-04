package com.duran.travelapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duran.travelapp.dto.AddPlanDto
import com.duran.travelapp.repository.AddPlanRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddPlanViewModel: ViewModel() {

    val addPlanList: LiveData<MutableList<AddPlanDto>>

    private val addPlanRepository: AddPlanRepository = AddPlanRepository.get()

    init {
        addPlanList = addPlanRepository.list()
    }

    fun getOne(id: Long) = addPlanRepository.getPlan(id)

    fun insert(dto: AddPlanDto) = viewModelScope.launch(Dispatchers.IO) {
        addPlanRepository.insert(dto)
    }

    fun update(dto: AddPlanDto) = viewModelScope.launch(Dispatchers.IO) {
        addPlanRepository.update(dto)
    }

    fun delete(dto: AddPlanDto) = viewModelScope.launch(Dispatchers.IO) {
        addPlanRepository.delete(dto)
    }
}