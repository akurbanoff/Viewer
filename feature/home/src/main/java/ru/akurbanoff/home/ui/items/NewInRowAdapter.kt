package ru.akurbanoff.home.ui.items

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.akurbanoff.home.data.models.Coffee
import androidx.databinding.DataBindingUtil
import ru.akurbanoff.home.R
import ru.akurbanoff.home.databinding.NewInRowItemBinding

class NewInRowAdapter(
    val mItems: List<Coffee>,
    val callback: Callback
) : RecyclerView.Adapter<NewInRowAdapter.ViewHolder>(){

    interface Callback{
        abstract fun onClickItem(item: Coffee)
    }

    inner class ViewHolder(
        val binding: NewInRowItemBinding
    ) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.new_in_row_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mItems[position]
        holder.binding.item = item
    }
}