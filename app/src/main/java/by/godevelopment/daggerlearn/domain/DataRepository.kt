package by.godevelopment.daggerlearn.domain

import by.godevelopment.daggerlearn.data.DataEntity
import kotlinx.coroutines.flow.Flow

interface DataRepository {
    fun getAllData(): Flow<List<DataEntity>>
}