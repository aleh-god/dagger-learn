package by.godevelopment.daggerlearn.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.godevelopment.daggerlearn.domain.DataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val dataRepository: DataRepository
) : ViewModel() {

    private val _stateUi = MutableStateFlow<StateUi>(StateUi())
    val stateUi: StateFlow<StateUi> = _stateUi

    init {
        var count = 0
        viewModelScope.launch {
            dataRepository.getAllData()
                .onStart {
                    _stateUi.value = StateUi(isLoading = true)
                }
                .collect {
                    _stateUi.value = StateUi(
                        isLoading = false,
                        message = "I am a Flow ($count)= ${it.message} + ${it.id}"
                    )
                    count++
            }
        }
    }

    data class StateUi(
        val isLoading: Boolean = false,
        val message: String = ""
    )
}