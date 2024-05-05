package ru.akurbanoff.home.ui.items

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.akurbanoff.home.R
import ru.akurbanoff.home.data.models.Coffee
import ru.akurbanoff.home.databinding.FrequentlyOrderedItemBinding

class FrequentlyOrderedListAdapter: RecyclerView.Adapter<FrequentlyOrderedListAdapter.ViewHolder>(){

    private var mItems: List<Coffee> = emptyList()
    private var mCallback: Callback? = null

    fun setData(mList: List<Coffee>){
        mItems = mList
    }

    fun setCallback(callback: Callback){
        mCallback = callback
    }

    interface Callback {
        abstract fun onClickItem(item: Coffee)
    }

    inner class ViewHolder(
        val binding: FrequentlyOrderedItemBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Coffee){
            binding.itemTitle.text = item.title
            binding.itemDescription.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FrequentlyOrderedItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mItems[position])
    }
}