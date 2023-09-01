package com.example.invisiaxploretask

import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.invisiaxploretask.databinding.ActivityMainBinding
import com.example.invisiaxploretask.ui.theme.view.FamilyListActivity
import com.example.invisiaxploretask.utility.Constants
import com.example.invisiaxploretask.viewmodel.FamilyViewModel

/**
 * Created by Tejas Dani on 31-Aug-2023
 * */

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: FamilyViewModel
    private lateinit var activityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)
        viewModel = ViewModelProvider(this)[FamilyViewModel::class.java]

        setUpClick()
    }

    private fun validateParentInput() {
        val firstNumber = activityBinding.edParent.text.toString()
        var secondNumber = activityBinding.edChild.text.toString()

        if (firstNumber.isEmpty()) {
            Toast.makeText(this, this@MainActivity.resources.getString(R.string.valid_parent_input), Toast.LENGTH_SHORT).show()
        } else {
            try {
                val parents = firstNumber.toInt()
                val child = if (secondNumber.isEmpty()) 0 else secondNumber.toInt()
                addFamilyToList(parents, child)
            } catch (e: NumberFormatException) {
                Toast.makeText(this, this@MainActivity.resources.getString(R.string.invalid_number), Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun addFamilyToList(parentsValue: Int, secondValue: Int) {
        viewModel.addFamily(parentsValue, secondValue)
        activityBinding.edParent.text!!.clear()
        activityBinding.edChild.text!!.clear()
        activityBinding.edParent.requestFocus()
    }

    private fun redirectFamilyList() {
        val intent = Intent(this, FamilyListActivity::class.java)
        intent.putParcelableArrayListExtra(Constants.FAMILY_LIST, ArrayList(viewModel.getNumberList()))
        startActivity(intent)
    }

    private fun setUpClick() {
        activityBinding.btnAddFamily.setOnClickListener {
            validateParentInput()
        }
        activityBinding.btnRedirect.setOnClickListener {
            redirectFamilyList()
        }
    }

}