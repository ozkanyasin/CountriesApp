package com.example.countrieskotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.countrieskotlin.R
import com.example.countrieskotlin.model.Country
import com.example.countrieskotlin.util.downloadFromURL
import com.example.countrieskotlin.util.placeholderProgressBar
import com.example.countrieskotlin.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList: ArrayList<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(var view: View) : RecyclerView.ViewHolder(view) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val  view = inflater.inflate(R.layout.item_country, parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.view.detailCountryName.text = countryList[position].countryName
        holder.view.detailCountryRegion.text = countryList[position].countryRegion
        countryList[position].imageUrl?.let { holder.view.imageView.downloadFromURL(it, placeholderProgressBar(holder.view.context)) }
        holder.view.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateCountryList(newCL: List<Country>) {
        countryList.clear()
        countryList.addAll(newCL)
        notifyDataSetChanged()
    }


}