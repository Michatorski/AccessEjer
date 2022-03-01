package org.iesfm.tiendamongo.repository;

import org.iesfm.tiendamongo.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderRepository extends MongoRepository<Order, Integer> {


   Order findByOrder(String nif);

    List<Order> findByClientNif(String nif);

}
