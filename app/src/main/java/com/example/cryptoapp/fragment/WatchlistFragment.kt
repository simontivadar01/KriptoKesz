package com.example.cryptoapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cryptoapp.SignInActivity
import com.example.cryptoapp.SignUpActivity
import com.example.cryptoapp.databinding.FragmentWatchlistBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class WatchlistFragment : Fragment() {

    private lateinit var binding: FragmentWatchlistBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWatchlistBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()
        val currentUser: FirebaseUser? = firebaseAuth.currentUser
        currentUser?.let {
            binding.emailTextView.text = "E-mail: ${it.email}"
        }


        binding.loginButton.setOnClickListener {
            val intent = Intent(requireContext(), SignInActivity::class.java)
            startActivity(intent)
        }

        binding.registerButton.setOnClickListener {
            val intent = Intent(requireContext(), SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.signOut.setOnClickListener{
            firebaseAuth.signOut()
            val intent = Intent(requireContext(), SignInActivity::class.java)
            startActivity(intent)
        }
    }


}