package com.example.countrieskotlin.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.countrieskotlin.R
import com.example.countrieskotlin.databinding.ItemCountryBinding
import com.example.countrieskotlin.model.Country
import com.example.countrieskotlin.util.downloadFromURL
import com.example.countrieskotlin.util.placeholderProgressBar
import com.example.countrieskotlin.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.fragment_detail.view.*
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList: ArrayList<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(), CountryClickListener {

    class CountryViewHolder(var view: ItemCountryBinding) : RecyclerView.ViewHolder(view.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val  view = DataBindingUtil.inflate<ItemCountryBinding>(inflater,R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.view.country = countryList[position]
        holder.view.listener = this

        /*holder.view.detailCountryName.text = countryList[position].countryName
        holder.view.detailCountryRegion.text = countryList[position].countryRegion

        holder.view.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToDetailFragment(countryList[position].uuid)
            //action.uuid
            Navigation.findNavController(it).navigate(action)
        }
        holder.view.imageView.downloadFromURL(countryList[position].imageUrl,
            placeholderProgressBar(holder.view.context))
*/
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateCountryList(newCL: List<Country>) {
        countryList.clear()
        countryList.addAll(newCL)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(v: View) {
        val uuid = v.countryUuidTxt.text.toString().toInt()
        val action = FeedFragmentDirections.actionFeedFragmentToDetailFragment(uuid)
        //action.uuid
        Navigation.findNavController(v).navigate(action)
    }


}