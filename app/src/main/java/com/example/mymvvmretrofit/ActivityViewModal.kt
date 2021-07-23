package com.example.mymvvmretrofit

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymvvmretrofit.dataclass.Getdata
import kotlinx.coroutines.launch
import retrofit2.Response

class ActivityViewModal(private val repositary: Repositary):ViewModel() {
    @RequiresApi(Build.VERSION_CODES.O)
    private lateinit var item:String
    val data = MutableLiveData<String>()
    fun date(item: String) {
        data.value = item
    }


    val respone:MutableLiveData<Response<Getdata>> = MutableLiveData()
    @RequiresApi(Build.VERSION_CODES.O)
    fun getdata() {
        viewModelScope.launch {
          //  val date ="2012-08-10" + ".json"
           val myResponce: Response<Getdata> = repositary.getData(item)
            respone.value=myResponce
        }
    }
}