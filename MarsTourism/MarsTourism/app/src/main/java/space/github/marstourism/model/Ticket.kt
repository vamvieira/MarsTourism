package space.github.marstourism.model

data class Ticket(
    val ticketType:TicketTypeEnum
)

enum class TicketTypeEnum(var preco:Double) {
    ADULTO(preco = 4450.0),
    CRIANCA(preco = 2450.0),
    IDOSO(preco = 3450.0)
}
