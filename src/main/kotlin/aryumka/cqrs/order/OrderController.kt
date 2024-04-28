package aryumka.cqrs.order

import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
  private val commandGateway: CommandGateway
) {
  @PostMapping("/order")
  //todo 컨트롤러에서
  // order command를 받을지 orderDto를 받을지 고민해보자.
  fun createOrder(orderDto: OrderDto) {
    // command gateway는 command를 command bus로 보낸다.
    // 동기적, 비동기적 처리가 가능하다. sendAndWait()는 동기적 처리를 한다.
    commandGateway.sendAndWait<Order>(
      OrderCommand.CreateOrder(
        orderDto.price,
        orderDto.quantity,
        orderDto.productId
      )
    )
  }
}
