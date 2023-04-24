package pe.edu.upao.apidelivery.controller;

import org.springframework.web.bind.annotation.*;
import pe.edu.upao.apidelivery.models.Food;
import pe.edu.upao.apidelivery.models.Order;
import pe.edu.upao.apidelivery.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/menu")
    public List<Food> getMenu() {
        return orderService.getMenu();
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest.getCustomerName(), orderRequest.getCustomerEmail(),
                orderRequest.getItemIds());
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public Order updateOrderStatus(@PathVariable Long id, @RequestBody OrderStatusRequest orderStatusRequest) {
        return orderService.updateOrderStatus(id, orderStatusRequest.getStatus());
    }
}