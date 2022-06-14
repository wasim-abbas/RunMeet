package com.zat.runmeet.viewModels

import android.app.Application
import com.zat.runmeet.utils.source.DataRepository

class AuthViewModel(val dataRepository: DataRepository, application: Application) :
    BaseViewModel(application) {



    //login request
//    fun login(loginRequestModel: LoginRequestModel) {
//        viewModelScope.launch {
//            when (val apiResponse = dataRepository.login(loginRequestModel)) {
//
//                is ResultWrapper.NetworkError -> errorLiveData.postValue("Network Error")
//                is ResultWrapper.GenericError -> errorLiveData.postValue(apiResponse.error)
//                is ResultWrapper.Success -> {
//                    if (apiResponse.value.code() == 401) {
//                        errorLiveData.postValue("Unauthenticated User")
//                    } else {
//                        if (apiResponse.value.code() == 200) {
//                            loginLiveData.postValue(apiResponse.value.body())
//                        } else {
//                            errorLiveData.postValue(apiResponse.value.body()?.errors?.get(0))
//                        }
//                    }
//                }
//            }
//        }
//    }


}