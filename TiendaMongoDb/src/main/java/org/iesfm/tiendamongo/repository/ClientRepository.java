package org.iesfm.tiendamongo.repository;

import org.iesfm.tiendamongo.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClientRepository extends MongoRepository<Client, String> {

    //ya existe el nameClass.save para hacer de insert

}
