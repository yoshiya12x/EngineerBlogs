package com.example.maeda_yos.engineerblogs.model

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private var user: MutableLiveData<User>? = null

    fun getUser(): MutableLiveData<User>? {
        if(user == null){
            user = MutableLiveData()
            load()
        }
        return user
    }

    private fun load(){
        user?.postValue(User("name", 121))
    }
}

data class User(val name: String, val age: Int)