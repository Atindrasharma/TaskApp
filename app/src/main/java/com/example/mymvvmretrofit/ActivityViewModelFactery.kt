package com.example.mymvvmretrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ActivityViewModelFactery(private val repositary: Repositary):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ActivityViewModal(repositary) as T
    }
}