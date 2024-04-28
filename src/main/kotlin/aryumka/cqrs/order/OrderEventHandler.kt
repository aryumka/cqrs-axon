package aryumka.cqrs.order

import org.axonframework.eventhandling.EventHandler
import org.springframework.stereotype.Component

@Component
class OrderEventHandler {
  @EventHandler
  fun on(event: OrderEvent.OrderCreated) {
    println("Order created: $event")

  }
}
