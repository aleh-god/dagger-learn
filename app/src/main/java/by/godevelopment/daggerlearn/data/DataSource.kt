package by.godevelopment.daggerlearn.data

class DataSource(private val initKey: String) {

    val dataList = (0..5).map {
        DataEntity(
            id = it,
            message = "$initKey.$it"
        )
    }
}