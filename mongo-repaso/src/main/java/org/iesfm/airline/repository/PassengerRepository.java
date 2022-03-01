package org.iesfm.airline.repository;

import org.iesfm.airline.pojo.Passenger;
import org.iesfm.airline.pojo.PassengerId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends MongoRepository<Passenger, PassengerId> {

    @Query("{'passengerId.flightNumber':?0}")
    List<Passenger> findByFlightNumber(int flightNumber);

    //addLuggage

    Passenger findByPassengerId(PassengerId passengerId);
}
