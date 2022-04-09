package com.example.myretrofit.ui.main.adapter

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofit.R
import com.example.myretrofit.data.api.CountryModel
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class CountryListAdapter (var activity: Activity): RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {

    private var countryList: List<CountryModel>? = null

    fun setCountryList(countryList: List<CountryModel>?) {
        this.countryList = countryList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryListAdapter.MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.country_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryListAdapter.MyViewHolder, position: Int) {
        holder.bind(countryList?.get(position)!!,activity)
    }

    override fun getItemCount(): Int {
        if (countryList == null)
            return 0
        else return countryList?.size!!
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tv_name = view.findViewById<TextView>(R.id.txt_name)
        val tv_code = view.findViewById<TextView>(R.id.txt_code)
        var img_flag = view.findViewById<ImageView>(R.id.img_logo)
        fun bind(data: CountryModel, activity: Activity) {

            tv_name.text = "name Country : "+data.name+"  "+data.emoji
            tv_code.text = "code Country : "+data.code

            GlideToVectorYou.justLoadImage(activity, Uri.parse(data.image),img_flag)

        }
    }
}