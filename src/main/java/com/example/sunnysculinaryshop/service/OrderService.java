package com.example.sunnysculinaryshop.service;

import com.example.sunnysculinaryshop.model.entity.Meal;
import com.example.sunnysculinaryshop.model.entity.Order;
import com.example.sunnysculinaryshop.model.entity.User;
import com.example.sunnysculinaryshop.repository.OrderRepository;
import com.example.sunnysculinaryshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MealService mealService;


    public OrderService(OrderRepository orderRepository, MealService mealService) {
        this.orderRepository = orderRepository;
        this.mealService = mealService;
    }


    public void addMealByIdToOrderByUser(Long id, String username) {
        Order order = orderRepository.findByUser_Username(username).get();

        Meal meal = mealService.getMealById(id);

        order.addMealToOrder(meal);

        orderRepository.save(order);
    }

    public Map<Meal,Integer> getOrderByUserConvertedToMap(String username) {
        Optional<Order> orderTry = orderRepository.findByUser_Username(username);
        if(!orderTry.isPresent()){
            return null;
        }
        Order order = orderTry.get();
        Map<Meal,Integer> ordersMap = new HashMap<>();

        for (Meal meal : order.getMeals()) {
            if(!ordersMap.containsKey(meal)){
                ordersMap.put(meal,1);
            } else{
                ordersMap.put(meal,ordersMap.get(meal) +1);
            }
        }
        return ordersMap;
    }

    public BigDecimal getTotalByLoggedUser(String username) {
        return orderRepository.findByUser_Username(username).get().getMeals()
                .stream()
                .map(Meal::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


    }
}
