package pe.edu.upao.apidelivery.services;

import pe.edu.upao.apidelivery.models.Food;
import pe.edu.upao.apidelivery.models.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private List<Food> foodLot;
    private List<Order> orderLot;
    private double ratioHour;
    public OrderService(){
        this.foodLot = new ArrayList<>();
        this.orderLot = new ArrayList<>();
    }

    public List<Food> getAllFoods(){
        return this.foodLot;
    }
    public List<Order> getAllOrders(){
        return this.orderLot;
    }

    public String getOrderByStatus(String id) {
        Order order = findOrderById(id);
        if(order.getStatus().equals("En proceso")){
            return order.getStatus();
        } else if (order.getStatus().equals("En camino")) {
            return order.getStatus();
        } else if (order.getStatus().equals("Entregado")) {
            return order.getStatus();
        } else {
            throw new RuntimeException("Pedido no encontrado");
        }
        // return this.orderLot.stream().filter(order-> order.getStatus().equals(status)).findFirst();
    }
    public Order findOrderById(String orderId) {
        return orderLot.stream().filter(order -> orderId.equals(order.getId())).findFirst().orElse(null);
    }
}