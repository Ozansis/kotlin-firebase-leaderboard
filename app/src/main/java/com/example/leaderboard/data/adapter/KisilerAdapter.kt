package com.example.leaderboard.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leaderboard.data.Users
import com.example.leaderboard.databinding.LeaderboardBinding

class KisilerAdapter(var context: Context,var kisilistesi: List<Users>): RecyclerView.Adapter<KisilerAdapter.CardViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        var binding = LeaderboardBinding.inflate(LayoutInflater.from(context),parent,false)
        return CardViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val kisi = kisilistesi.get(position)
        val tasarim = holder.view

        tasarim.sRaTxt.text = (position+1).toString()+ "."
        tasarim.isimTxt.text = kisi.ad.toString()
        tasarim.puanTxt.text = kisi.puan.toString()


    }

    override fun getItemCount(): Int {
        return kisilistesi.size
    }

    inner class CardViewHolder (var view : LeaderboardBinding) : RecyclerView.ViewHolder(view.root)




}