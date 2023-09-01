package com.example.invisiaxploretask.ui.theme.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.invisiaxploretask.databinding.ActivityFamilyListBinding
import com.example.invisiaxploretask.model.FamilyData
import com.example.invisiaxploretask.ui.view.FamilyListAdapter
import com.example.invisiaxploretask.utility.Constants
import com.example.invisiaxploretask.utility.handleAdapterIfEmpty

/**
 * Created by Tejas Dani on 31-Aug-2023
 * FamilyListActivity class to show list of Families
 * */

class FamilyListActivity : AppCompatActivity() {
    private lateinit var familyListBinding: ActivityFamilyListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        familyListBinding = ActivityFamilyListBinding.inflate(layoutInflater)
        setContentView(familyListBinding.root)
        val numberList = intent.getParcelableArrayListExtra<FamilyData>(Constants.FAMILY_LIST)
        if (numberList != null) {
            familyListBinding.rvFamilyList.layoutManager = LinearLayoutManager(this)
            numberList.handleAdapterIfEmpty(
                familyListBinding.tvNoData,
                familyListBinding.rvFamilyList
            ) {
                val adapter = FamilyListAdapter(numberList)
                familyListBinding.rvFamilyList.adapter = adapter

            }

        }
    }
}