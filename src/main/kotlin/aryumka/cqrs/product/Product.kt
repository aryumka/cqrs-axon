package aryumka.cqrs.product

import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.spring.stereotype.Aggregate
import java.util.*

@Aggregate
class Product(
  @AggregateIdentifier
  val id: UUID,
  val name: String,
  val price: Int,
  var stock: Int,
  val description: String
) {
  fun depreciateStock(quantity: Int) {
    if (stock < quantity) {
      throw IllegalArgumentException("Not enough stock")
    }
    stock -= quantity
  }
}
