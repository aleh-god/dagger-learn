package by.godevelopment.daggerlearn.data

import by.godevelopment.daggerlearn.domain.DataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val dataSource: DataSource
) : DataRepository {

    override fun getAllData(): Flow<DataEntity> = dataSource.dataList.asFlow()
}