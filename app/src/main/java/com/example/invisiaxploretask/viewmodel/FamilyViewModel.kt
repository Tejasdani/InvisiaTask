package com.example.invisiaxploretask.viewmodel

import androidx.lifecycle.ViewModel
import com.example.invisiaxploretask.model.FamilyData



/**
 * Created by Tejas Dani on 31-Aug-2023
 * FamilyViewModel class for written logics
 * */


class FamilyViewModel:ViewModel() {

    private val numberList = mutableListOf<FamilyData>()

    fun addFamily(firstNumber: Int, secondNumber: Int) {
        numberList.add(FamilyData(firstNumber, secondNumber))
    }

    fun getNumberList(): List<FamilyData> {
        return numberList.toList()
    }

}