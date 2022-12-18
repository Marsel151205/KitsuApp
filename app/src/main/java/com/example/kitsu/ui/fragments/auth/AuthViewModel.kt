package com.example.kitsu.ui.fragments.auth

import com.example.kitsu.base.BaseViewModel
import com.example.kitsu.data.repositories.AuthRepository
import com.example.kitsu.models.auth.AuthModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val repository: AuthRepository): BaseViewModel() {

    fun post(model: AuthModel) = repository.postDataUser(model)
}