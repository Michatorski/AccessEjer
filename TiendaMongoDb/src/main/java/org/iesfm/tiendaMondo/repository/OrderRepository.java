package org.iesfm.tiendaMondo.repository;

import org.iesfm.tiendaMondo.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderRepository extends MongoRepository<Order, Integer> {


    List<Order> findByOrder(String nif);

    List<Order> findByClientNif(String nif);

}
