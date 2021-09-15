package org.iesfm.tiendaMondo.api.controller;

import org.iesfm.tiendaMondo.Order;
import org.iesfm.tiendaMondo.repository.ClientRepository;
import org.iesfm.tiendaMondo.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class OrderController {

    private OrderRepository orderRepository;
    private ClientRepository clientRepository;

    public OrderController(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/orders")
    public void insert(
            @RequestBody Order order
    ) {
        orderRepository.save(order);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/clientes/{nif}/orders")
    public List<Order> findBy(
            @PathVariable("nif") String nif
    ) {
        if (!clientRepository.existsById(nif)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
        }
        return orderRepository.findByClientNif(nif);
    }


}
