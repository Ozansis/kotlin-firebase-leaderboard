package com.example.leaderboard.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.leaderboard.data.Users
import com.example.leaderboard.data.adapter.KerimAdapter
import com.example.leaderboard.data.adapter.KisilerAdapter
import com.example.leaderboard.databinding.FragmentLeaderBoardBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore


class LeaderBoardFragment : Fragment() {
    private lateinit var binding: FragmentLeaderBoardBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLeaderBoardBinding.inflate(inflater,container,false)

        val db = Firebase.firestore

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        db.collection("users")
            .orderBy("puan", Query.Direction.DESCENDING).limit(10)
            .addSnapshotListener { snapshot, exception ->

            val userList = mutableListOf<Users>()
            if(exception != null){

                Toast.makeText(requireContext(),exception.localizedMessage, Toast.LENGTH_LONG).show()

            }else{

                if (snapshot != null){

                    if (!snapshot.isEmpty){

                        val documents = snapshot.documents


                        for( document in documents){

                            val kullaniciAdi = document.getString("ad") ?: ""
                            val puan = document.getLong("puan")?.toInt() ?: 0

                            userList.add(Users(kullaniciAdi,puan))


                        }

                        val adapter= KisilerAdapter(requireContext(),userList)
                        binding.recyclerView.adapter=adapter




                    }


                }
            }


        }





        return binding.root
    }


}