package com.example.smartcv.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class InformationViewModel: ViewModel() {

    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _saveStatus = MutableLiveData<Boolean>()
    val saveStatus: LiveData<Boolean> get() = _saveStatus

    // 'selectedLanguages' yerine 'allLanguages' StateFlow oluşturuyoruz
    private val _allLanguages = MutableStateFlow<List<Pair<String, String>>>(emptyList())
    val allLanguages: StateFlow<List<Pair<String, String>>> = _allLanguages

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

    fun LanguageInformation(languages: List<Pair<String, String>>) {
        viewModelScope.launch {
            val userId = auth.currentUser?.uid
            if (userId != null) {

                val userDoc = firestore.collection("users").document(userId).get().await()

                if (userDoc.exists()) {

                    val existingLanguages = userDoc.get("languages") as? List<Map<String, String>> ?: emptyList()

                    // Yeni dil bilgilerini mevcut dil bilgilerine ekle
                    val updatedLanguages = existingLanguages.toMutableList().apply {
                        languages.forEach { newLang ->
                            // Eğer dil zaten mevcutsa, tekrar ekleme
                            val exists = any { it["language"] == newLang.first }
                            if (!exists) {
                                add(mapOf("language" to newLang.first, "level" to newLang.second))
                            }
                        }
                    }
                    val languageData = mapOf("languages" to updatedLanguages)

                    firestore.collection("users")
                        .document(userId)
                        .set(languageData, SetOptions.merge())  // Mevcut veriye ekler
                        .addOnSuccessListener {
                            Log.d("Firestore", "Dil bilgisi başarıyla kaydedildi.")
                        }
                        .addOnFailureListener { e ->
                            Log.e("Firestore", "Dil bilgisi kaydedilemedi.", e)
                        }
                } else {
                    Log.e("Firestore", "Kullanıcı verisi bulunamadı.")
                }
            } else {
                Log.e("Auth", "Kullanıcı giriş yapmamış.")
            }
        }
    }
    fun contactInformation(github: String, linkedn:String){
        viewModelScope.launch {
            val userId = auth.currentUser?.uid
            if (userId != null) {
                val contactData = mapOf(
                    "github" to github,
                    "linkedn" to linkedn
                )
                firestore.collection("users")
                    .document(userId)
                    .update(contactData)
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