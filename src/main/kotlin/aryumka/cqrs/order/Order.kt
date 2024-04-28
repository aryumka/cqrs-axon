package aryumka.cqrs.order

import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate
import java.util.*

@Aggregate
class Order(
  @AggregateIdentifier
  val id: UUID,
  val price: Int,
  val quantity: Int,
  val productId: String
) {
  init {
    AggregateLifecycle.apply(
      OrderEvent.OrderCreated(
        id = id,
        price = price,
        quantity = quantity,
        productId = productId
      )
    )
  }

}
