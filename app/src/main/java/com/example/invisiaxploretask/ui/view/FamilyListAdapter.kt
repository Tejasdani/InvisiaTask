package com.example.invisiaxploretask.ui.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.invisiaxploretask.R
import com.example.invisiaxploretask.databinding.ItemNumberBinding
import com.example.invisiaxploretask.model.FamilyData

/**
 * Created by Tejas Dani on 31-Aug-2023
 * FamilyListAdapter showing families items
 * */


class FamilyListAdapter(private val numberList: List<FamilyData>) :
    RecyclerView.Adapter<FamilyListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("No of Size:: ${numberList.size}")
        val currentItem = numberList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = numberList.size

    class ViewHolder(private val cx:Context,private val item: View) : RecyclerView.ViewHolder(item) {
        private val binding: ItemNumberBinding by lazy {
            ItemNumberBinding.bind(item)
        }

        fun bind(familyData: FamilyData) {
            binding.tvItemParent.text =
                "${cx.resources.getString(R.string.no_parents)} ${familyData.noOfParents}"
            binding.tvItemChild.text =
                "${cx.resources.getString(R.string.no_child)} ${familyData.noOfChild}"
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_number, parent, false)
                return ViewHolder(parent.context,view)
            }
        }
    }
}