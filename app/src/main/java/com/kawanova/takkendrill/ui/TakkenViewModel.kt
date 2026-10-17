package com.kawanova.takkendrill.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kawanova.takkendrill.data.TakkenCategory
import com.kawanova.takkendrill.data.TakkenCheatData
import com.kawanova.takkendrill.data.TakkenCheatItem
import com.kawanova.takkendrill.data.TakkenQuestion
import com.kawanova.takkendrill.data.TakkenQuestionsData
import com.kawanova.takkendrill.data.TakkenQuizRepository
import com.kawanova.takkendrill.data.VisualizerScenario
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class TakkenUiState(
    val selectedCategory: TakkenCategory? = null,
    val bookmarkedOnly: Boolean = false,
    val currentQuestionIndex: Int = 0,
    val selectedOptionIndex: Int? = null,
    val isAnswerChecked: Boolean = false,
    val searchCheatQuery: String = "",
    val selectedScenario: VisualizerScenario = VisualizerScenario.DOUBLE_SALE,
    // Scenario Simulation States
    val simDoubleSaleStep: Int = 0, // 0: A sells to B, 1: A sells to C, 2: C registers, 3: Bad faith verdict
    val simArticle35Step: Int = 0, // 0: Comparison overview, 1: 35 Timing & Agent, 2: 37 Post-contract
    val simCoolingOffLocation: Int = 0 // 0: Hotel Lobby (Valid), 1: Office (Invalid), 2: Home requested (Invalid)
)

class TakkenViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TakkenQuizRepository(application)

    private val _uiState = MutableStateFlow(TakkenUiState())
    val uiState: StateFlow<TakkenUiState> = _uiState.asStateFlow()

    val answeredIds: StateFlow<Set<Int>> = repository.answeredQuestionIdsFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptySet())

    val correctIds: StateFlow<Set<Int>> = repository.correctQuestionIdsFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptySet())

    val bookmarkedIds: StateFlow<Set<Int>> = repository.bookmarkedQuestionIdsFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptySet())

    val allQuestions: List<TakkenQuestion> = TakkenQuestionsData.questions
    val allCheatItems: List<TakkenCheatItem> = TakkenCheatData.cheatItems

    // Filtered questions based on category and bookmark status
    val currentQuestionList: StateFlow<List<TakkenQuestion>> = combine(
        _uiState,
        bookmarkedIds
    ) { state, bookmarks ->
        allQuestions.filter { q ->
            val matchCategory = state.selectedCategory == null || q.category == state.selectedCategory
            val matchBookmark = !state.bookmarkedOnly || bookmarks.contains(q.id)
            matchCategory && matchBookmark
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), allQuestions)

    fun selectCategory(category: TakkenCategory?) {
        _uiState.value = _uiState.value.copy(
            selectedCategory = category,
            bookmarkedOnly = false,
            currentQuestionIndex = 0,
            selectedOptionIndex = null,
            isAnswerChecked = false
        )
    }

    fun setBookmarkedOnly(onlyBookmarks: Boolean) {
        _uiState.value = _uiState.value.copy(
            bookmarkedOnly = onlyBookmarks,
            currentQuestionIndex = 0,
            selectedOptionIndex = null,
            isAnswerChecked = false
        )
    }

    fun selectOption(index: Int) {
        if (!_uiState.value.isAnswerChecked) {
            _uiState.value = _uiState.value.copy(selectedOptionIndex = index)
        }
    }

    fun checkAnswer(question: TakkenQuestion) {
        val selected = _uiState.value.selectedOptionIndex ?: return
        val isCorrect = selected == question.correctAnswerIndex
        _uiState.value = _uiState.value.copy(isAnswerChecked = true)

        viewModelScope.launch {
            repository.saveAnswer(question.id, isCorrect)
        }
    }

    fun nextQuestion(totalCount: Int) {
        val nextIdx = (_uiState.value.currentQuestionIndex + 1).coerceAtMost(totalCount - 1)
        _uiState.value = _uiState.value.copy(
            currentQuestionIndex = nextIdx,
            selectedOptionIndex = null,
            isAnswerChecked = false
        )
    }

    fun previousQuestion() {
        val prevIdx = (_uiState.value.currentQuestionIndex - 1).coerceAtLeast(0)
        _uiState.value = _uiState.value.copy(
            currentQuestionIndex = prevIdx,
            selectedOptionIndex = null,
            isAnswerChecked = false
        )
    }

    fun jumpToQuestion(index: Int) {
        _uiState.value = _uiState.value.copy(
            currentQuestionIndex = index,
            selectedOptionIndex = null,
            isAnswerChecked = false
        )
    }

    fun toggleBookmark(questionId: Int) {
        viewModelScope.launch {
            repository.toggleBookmark(questionId)
        }
    }

    fun resetProgress() {
        viewModelScope.launch {
            repository.resetAllProgress()
        }
    }

    fun setSearchCheatQuery(query: String) {
        _uiState.value = _uiState.value.copy(searchCheatQuery = query)
    }

    fun selectScenario(scenario: VisualizerScenario) {
        _uiState.value = _uiState.value.copy(
            selectedScenario = scenario,
            simDoubleSaleStep = 0,
            simArticle35Step = 0,
            simCoolingOffLocation = 0
        )
    }

    fun setSimDoubleSaleStep(step: Int) {
        _uiState.value = _uiState.value.copy(simDoubleSaleStep = step)
    }

    fun setSimArticle35Step(step: Int) {
        _uiState.value = _uiState.value.copy(simArticle35Step = step)
    }

    fun setSimCoolingOffLocation(loc: Int) {
        _uiState.value = _uiState.value.copy(simCoolingOffLocation = loc)
    }
}
