package org.iesfm.airline.repository;

import org.iesfm.airline.pojo.Flight;
import org.iesfm.airline.pojo.Luggage;
import org.iesfm.airline.pojo.Passenger;
import org.iesfm.airline.pojo.PassengerId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirlineTest {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private PassengerRepository passengerRepository;

    @Test
    public void saveFlightTest(){
        flightRepository.save(new Flight(
                111,
                "Spain",
                "Ucrania",
                new Date()
        ));
    }

    @Test
    public void listFlightsTest(){
       List<Flight> flights= flightRepository.findAll();
        for (Flight f:
             flights) {
            System.out.println(f);
        }
    }


    @Test
    public void insertByFlightNumber(){
      Passenger passenger = passengerRepository.save(new Passenger(
              new PassengerId("AAA", 111),
              "falso@emial.com",
              "Mic",
              "Hom",
              1,
              List.of()
      ));
   passengerRepository.save(passenger);
    }

    @Test
    public void listPassengersByFlightNumberTest(){
        List<Passenger> passengers = passengerRepository.findByFlightNumber(111);
        for (Passenger passenger :
                passengers) {
            System.out.println(passenger);
        }
    }

    @Test
    public void addLuggageTest(){
        Passenger passenger = passengerRepository.findByPassengerId(
                new PassengerId("AAA", 111));
       passenger.getLuggages().add(new Luggage(123, "Es una maleta"));
       passengerRepository.save(passenger);
    }

    @Test
    public void listLuggageTest(){
        Passenger passenger = passengerRepository.findByPassengerId(
                new PassengerId("AAA", 111)
        );

        List<Luggage> luggages = passenger.getLuggages();

        for (Luggage luggage:
             luggages  ) {
            System.out.println(luggage);
        }
    }
}
