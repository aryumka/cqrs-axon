package aryumka.cqrs.order

import java.util.UUID

class OrderEvent {
  data class OrderCreated(
    val id: UUID,
    val price: Int,
    val quantity: Int,
    val productId: String
  )
}
