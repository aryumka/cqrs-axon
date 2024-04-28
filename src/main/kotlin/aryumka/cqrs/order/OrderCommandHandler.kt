package aryumka.cqrs.order

import aryumka.cqrs.product.Product
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.modelling.command.Repository
import org.springframework.stereotype.Component
import java.util.*

@Component
class OrderCommandHandler(
  private val orderRepository: Repository<Order>,
  private val productRepository: Repository<Product>
) {
  @CommandHandler
  fun handle(command: OrderCommand.CreateOrder) {
    productRepository.load(command.productId)
      .execute {  product ->
        product.depreciateStock(command.quantity)
      }

    val order = Order(
      id = UUID.randomUUID(),
      price = command.price,
      quantity = command.quantity,
      productId = command.productId
    )

    orderRepository.newInstance { order }
  }
}
