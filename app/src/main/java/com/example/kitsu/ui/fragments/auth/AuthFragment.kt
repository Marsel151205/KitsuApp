package com.example.kitsu.ui.fragments.auth

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsu.R
import com.example.kitsu.base.BaseFragment
import com.example.kitsu.common.PreferencesConstants
import com.example.kitsu.common.Resource
import com.example.kitsu.data.local.sharedpreferences.PreferencesHelper
import com.example.kitsu.data.local.sharedpreferences.userdata.UserPreferencesData
import com.example.kitsu.databinding.FragmentAuthBinding
import com.example.kitsu.models.auth.AuthModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class AuthFragment : BaseFragment<FragmentAuthBinding, AuthViewModel>(R.layout.fragment_auth) {

    override val binding by viewBinding(FragmentAuthBinding::bind)
    override val viewModel: AuthViewModel by viewModels()

    @Inject
    lateinit var userPreferencesData: UserPreferencesData

    override fun setupListener() {
        binding.btnSingIn.setOnClickListener {
            subscribeToAuth()
        }
    }

    fun subscribeToAuth() {
        val email = binding.tvEmail.text.trim().toString()
        val password = binding.tvPassword.text.trim().toString()

        lifecycleScope.launch {
            viewModel.post(AuthModel("password", email, password))
                .collect {
                    when (it) {
                        is Resource.Error -> {
                            Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is Resource.Loading -> {

                        }
                        is Resource.Success -> {
                            if (it.data != null) {
                                PreferencesConstants.PREF_ACCESS_TOKEN = it.data.accessToken
                                userPreferencesData.isAuthorized = true
                                findNavController().navigate(R.id.mainFragment)
                            }
                        }
                    }
                    Log.e("token", it.data.toString())
                }
        }
    }
}