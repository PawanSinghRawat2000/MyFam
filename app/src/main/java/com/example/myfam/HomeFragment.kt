package com.example.myfam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listMember = listOf<MemberModel>(
            MemberModel(
                "Lokesh",
                "9th buildind, 2nd floor, maldiv road, manali 9th buildind, 2nd floor",
                "90%",
                "220"
            ),
            MemberModel(
                "Kedia",
                "10th buildind, 3rd floor, maldiv road, manali 10th buildind, 3rd floor",
                "80%",
                "210"
            ),
            MemberModel(
                "D4D5",
                "11th buildind, 4th floor, maldiv road, manali 11th buildind, 4th floor",
                "70%",
                "200"
            ),
            MemberModel(
                "Ramesh",
                "12th buildind, 5th floor, maldiv road, manali 12th buildind, 5th floor",
                "60%",
                "190"
            ),
        )
        val adapter=MemberAdapter(listMember)
        val recycler=requireView().findViewById<RecyclerView>(R.id.recycler_member)
        recycler.layoutManager=LinearLayoutManager(requireContext())
        recycler.adapter=adapter

        val listContact= arrayListOf<ContactModel>(
            ContactModel("Pawan",9548871918),
            ContactModel("Pawan",9548871918),
            ContactModel("Pawan",9548871918)
        )
        val contactAdapter=InviteAdapter(listContact)
        val inviteRecycler=requireView().findViewById<RecyclerView>(R.id.recycler_invite)
    }




    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()

    }
}