package com.example.smartcv.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.launch



class InformationViewModel: ViewModel() {

    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _saveStatus = MutableLiveData<Boolean>()
    val saveStatus: LiveData<Boolean> get() = _saveStatus

    fun personalInformation(name: String, surname: String, telephone: String, birthDate: String, gender: String?){
        viewModelScope.launch {
            val userId = auth.currentUser?.uid
            if (userId != null) {
                val userData = mapOf(
                    "name" to name,
                    "surname" to surname,
                    "telephone" to telephone,
                    "birthDate" to birthDate,
                    "gender" to gender
                )

                firestore.collection("users")
                    .document(userId)
                    .update(userData)
                    .addOnSuccessListener {
                        Log.d("Firestore", "Kullanıcı bilgileri başarıyla güncellendi.")
                        _saveStatus.value = true
                    }
                    .addOnFailureListener { e ->
                        Log.e("Firestore", "Kullanıcı bilgileri güncellenemedi.", e)
                        _saveStatus.value = false
                    }
            } else {
                Log.e("Auth", "Kullanıcı giriş yapmamış.")
                _saveStatus.value = false
            }
        }
    }
}