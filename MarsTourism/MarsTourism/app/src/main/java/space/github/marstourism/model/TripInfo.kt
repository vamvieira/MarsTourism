package space.github.marstourism.model

import java.util.*

data class TripInfo(
    var tickets: MutableList<Ticket> = mutableListOf(),
    var startDate: Date? = null,
    var endDate: Date? = null
)
