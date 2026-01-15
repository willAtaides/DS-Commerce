package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.OrderDTO;
import com.devsuperior.dscommerce.dto.OrderItemDTO;
import com.devsuperior.dscommerce.entities.*;
import com.devsuperior.dscommerce.repositories.OrderItemRepository;
import com.devsuperior.dscommerce.repositories.OrderRepository;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import com.devsuperior.dscommerce.services.excepitions.ResouceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private AuthService authService;

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Optional<Order> result = repository.findById(id);
        Order order = result.orElseThrow(
                () -> new ResouceNotFoundException("Recurso não encontrado"));
        authService.validateSelfOrAdmin(order.getClient().getId());
        OrderDTO dto = new OrderDTO(order);
        return dto;
    }

    @Transactional
    public OrderDTO insert(@Valid OrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticated();
        order.setClient(user);

        for(OrderItemDTO itemDTO : dto.getItems()){
            Product product = productRepository.getReferenceById(itemDTO.getProductId());
            OrderItem item = new OrderItem(order, product, product.getPrice() , itemDTO.getQuantity());
            order.getItems().add(item);
        }
        repository.save(order);
        orderItemRepository.saveAll(order.getItems());
        return new OrderDTO(order);
    }

}
