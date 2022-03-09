package by.godevelopment.daggerlearn.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.godevelopment.daggerlearn.data.DataSource
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

class MainViewModel (
    private val dataSource: DataSource
) : ViewModel() {

    val message: String = "I am ViewModel, data = ${dataSource.dataList.size}"
}

class MainViewModelFactory @AssistedInject constructor(
    @Assisted("newsId") private val newsId: String,
    private val dataSource: DataSource
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == MainViewModel::class.java)
        return MainViewModel(dataSource) as T
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted("newsId") newsId: String): MainViewModelFactory
    }
}