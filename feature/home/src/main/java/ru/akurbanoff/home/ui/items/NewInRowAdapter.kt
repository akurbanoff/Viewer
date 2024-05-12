package ru.akurbanoff.home.ui.items

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.akurbanoff.home.data.models.Coffee
import ru.akurbanoff.home.R
import ru.akurbanoff.home.databinding.NewInRowItemBinding

internal class NewInRowAdapter: RecyclerView.Adapter<NewInRowAdapter.ViewHolder>(){

    private var mItems: List<Coffee> = emptyList()
    private var mCallback: Callback? = null
    fun setData(mList: List<Coffee>){
        mItems = mList
    }

    fun setCallback(callback: Callback){
        mCallback = callback
    }

    interface Callback{
        abstract fun onClickItem(item: Coffee)
    }

    inner class ViewHolder(
        val binding: NewInRowItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Coffee){
            binding.itemTitle.text = item.title
        }
    }

    override fun onBindViewHolder(holder: NewInRowAdapter.ViewHolder, position: Int) {
        holder.bind(mItems[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            NewInRowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mItems.size
    }
}