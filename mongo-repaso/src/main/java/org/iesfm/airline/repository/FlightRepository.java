package org.iesfm.airline.repository;

import org.iesfm.airline.pojo.Flight;
import org.iesfm.airline.pojo.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends MongoRepository<Flight, Integer> {

    //save
    //findALl
    Flight findByFlightNumber(int flightNumber);
}
