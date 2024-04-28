package aryumka.cqrs.order

import org.axonframework.modelling.command.TargetAggregateIdentifier

class OrderCommand {
  data class CreateOrder(
    val price: Int,
    val quantity: Int,
    val productId: String,
  )
}
