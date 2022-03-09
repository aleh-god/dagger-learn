package by.godevelopment.daggerlearn.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.godevelopment.daggerlearn.data.DataSource

class MainViewModel(
    private val dataSource: DataSource
) : ViewModel() {

    val message: String = "I am ViewModel ${dataSource.dataList.first().message}"
}

class MyMainViewModelFactory(private val dataSource: DataSource) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == MainViewModel::class)
        return MainViewModel(dataSource) as T
    }
}