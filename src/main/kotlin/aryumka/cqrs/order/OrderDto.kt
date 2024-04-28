package aryumka.cqrs.order

data class OrderDto(
  val id: String,
  val price: Int,
  val quantity: Int,
  val productId: String,
  val userId: String
)
