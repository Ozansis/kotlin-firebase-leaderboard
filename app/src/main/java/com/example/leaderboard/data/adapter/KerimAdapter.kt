package com.example.leaderboard.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leaderboard.data.Users
import com.example.leaderboard.databinding.KerimCardBinding

class KerimAdapter(val context: Context,val user: List<Users>): RecyclerView.Adapter<KerimAdapter.CardHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val binding = KerimCardBinding.inflate(LayoutInflater.from(context),parent,false)
        return CardHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val kisi = user.get(position)
        val tasarim = holder.view

        tasarim.textView.text = kisi.ad




    }

    override fun getItemCount(): Int {
      return user.size
    }


    inner class CardHolder(val view : KerimCardBinding) : RecyclerView.ViewHolder(view.root)


}