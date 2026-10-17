package com.kawanova.takkendrill.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "takken_prefs")

class TakkenQuizRepository(private val context: Context) {

    private object PreferencesKeys {
        val ANSWERED_QUESTION_IDS = stringSetPreferencesKey("answered_question_ids")
        val CORRECT_QUESTION_IDS = stringSetPreferencesKey("correct_question_ids")
        val BOOKMARKED_QUESTION_IDS = stringSetPreferencesKey("bookmarked_question_ids")
    }

    val answeredQuestionIdsFlow: Flow<Set<Int>> = context.dataStore.data.map { prefs ->
        prefs[PreferencesKeys.ANSWERED_QUESTION_IDS]?.mapNotNull { it.toIntOrNull() }?.toSet() ?: emptySet()
    }

    val correctQuestionIdsFlow: Flow<Set<Int>> = context.dataStore.data.map { prefs ->
        prefs[PreferencesKeys.CORRECT_QUESTION_IDS]?.mapNotNull { it.toIntOrNull() }?.toSet() ?: emptySet()
    }

    val bookmarkedQuestionIdsFlow: Flow<Set<Int>> = context.dataStore.data.map { prefs ->
        prefs[PreferencesKeys.BOOKMARKED_QUESTION_IDS]?.mapNotNull { it.toIntOrNull() }?.toSet() ?: emptySet()
    }

    suspend fun saveAnswer(questionId: Int, isCorrect: Boolean) {
        context.dataStore.edit { prefs ->
            val currentAnswered = prefs[PreferencesKeys.ANSWERED_QUESTION_IDS]?.toMutableSet() ?: mutableSetOf()
            currentAnswered.add(questionId.toString())
            prefs[PreferencesKeys.ANSWERED_QUESTION_IDS] = currentAnswered

            val currentCorrect = prefs[PreferencesKeys.CORRECT_QUESTION_IDS]?.toMutableSet() ?: mutableSetOf()
            if (isCorrect) {
                currentCorrect.add(questionId.toString())
            } else {
                currentCorrect.remove(questionId.toString())
            }
            prefs[PreferencesKeys.CORRECT_QUESTION_IDS] = currentCorrect
        }
    }

    suspend fun toggleBookmark(questionId: Int) {
        context.dataStore.edit { prefs ->
            val current = prefs[PreferencesKeys.BOOKMARKED_QUESTION_IDS]?.toMutableSet() ?: mutableSetOf()
            val idStr = questionId.toString()
            if (current.contains(idStr)) {
                current.remove(idStr)
            } else {
                current.add(idStr)
            }
            prefs[PreferencesKeys.BOOKMARKED_QUESTION_IDS] = current
        }
    }

    suspend fun resetAllProgress() {
        context.dataStore.edit { prefs ->
            prefs.remove(PreferencesKeys.ANSWERED_QUESTION_IDS)
            prefs.remove(PreferencesKeys.CORRECT_QUESTION_IDS)
        }
    }
}
