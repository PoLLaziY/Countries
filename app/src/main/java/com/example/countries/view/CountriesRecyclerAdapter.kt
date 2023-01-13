package com.example.countries.view

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countries.databinding.FragmentFirstCountryRecyclerItemBinding
import com.example.countries.domain.Country

class CountriesRecyclerAdapter(private val onClick: (Int) -> Unit) :
    ListAdapter<Country, CountryViewHolder>(CountryDiffUntilCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FragmentFirstCountryRecyclerItemBinding.inflate(inflater, parent, false)
        return CountryViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CountryViewHolder(
    private val binding: FragmentFirstCountryRecyclerItemBinding,
    onClick: (Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            onClick(adapterPosition)
        }
    }

    fun bind(country: Country) {
        binding.name.text = country.name

        val flagImageUri = Uri.parse(country.flags?.png)

        Glide.with(binding.root)
            .load(flagImageUri)
            .into(binding.flagImage)
    }
}

object CountryDiffUntilCallBack : DiffUtil.ItemCallback<Country>() {
    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem == newItem
    }
}