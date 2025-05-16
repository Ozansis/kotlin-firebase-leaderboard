package com.example.leaderboard.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.leaderboard.data.Users
import com.example.leaderboard.databinding.FragmentKisiKayitBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.example.leaderboard.R



class KisiKayitFragment : Fragment() {

    private lateinit var binding: FragmentKisiKayitBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentKisiKayitBinding.inflate(inflater,container,false)


        val db = Firebase.firestore


        binding.button.setOnClickListener {
            val name = binding.kullaniciEtext.text.toString()
            val puan = binding.puanEtext.text.toString()

            val user = Users(name,puan.toIntOrNull()?: 0)

            db.collection("users")
                .add(user)
                .addOnSuccessListener { task->
                    Log.d("tag", "DocumentSnapshot added with ID: ${task.id}")

                }.addOnFailureListener { e ->
                    Log.w("tag", "Error adding document", e)

                }


        }

        binding.btngecis.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.lidertablosugecis)


        }



        return binding.root


    }




}