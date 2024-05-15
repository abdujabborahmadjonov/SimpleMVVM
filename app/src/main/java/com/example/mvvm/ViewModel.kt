package com.example.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.User

class ViewModel:ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user
    fun getUser(){
        val user = User(1,"John Doe","@gmail.com")
        _user.value = user
    }
    fun setUser(id: Int, name: String, email: String) {
        val user = User(id, name, email)
        _user.value = user
    }
}