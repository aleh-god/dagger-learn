package by.godevelopment.daggerlearn.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import by.godevelopment.daggerlearn.data.DataSource
import by.godevelopment.daggerlearn.domain.DataRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel (
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

//    val message: String = "I am ViewModel, data = ${dataSource.dataList.size}"

    data class StateUi(
        val isLoading: Boolean = false,
        val message: String = ""
    )
}

class MainViewModelFactory @AssistedInject constructor(
    @Assisted("newsId") private val newsId: String,
    private val dataRepository: DataRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == MainViewModel::class.java)
        return MainViewModel(dataRepository) as T
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted("newsId") newsId: String): MainViewModelFactory
    }
}