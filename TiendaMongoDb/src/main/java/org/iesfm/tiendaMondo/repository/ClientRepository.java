package org.iesfm.tiendaMondo.repository;

import org.iesfm.tiendaMondo.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientRepository extends MongoRepository<Client, String> {

    //ya existe el nameClass.save para hacer de insert

}
