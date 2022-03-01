package org.iesfm.airline.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "passengers")
public class Passenger {
     @Id
    private PassengerId passengerId;

     private String email;
     private String name;
     private String surname;
     private int sit;
    private List<Luggage> luggages;

    public Passenger(PassengerId passengerId, String email, String name, String surname, int sit, List<Luggage> luggages) {
        this.passengerId = passengerId;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.sit = sit;
        this.luggages = luggages;
    }

    public Passenger(){

    }

    public PassengerId getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(PassengerId passengerId) {
        this.passengerId = passengerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSit() {
        return sit;
    }

    public void setSit(int sit) {
        this.sit = sit;
    }

    public List<Luggage> getLuggages() {
        return luggages;
    }

    public void setLuggages(List<Luggage> luggages) {
        this.luggages = luggages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return sit == passenger.sit && Objects.equals(passengerId, passenger.passengerId) && Objects.equals(email, passenger.email) && Objects.equals(name, passenger.name) && Objects.equals(surname, passenger.surname) && Objects.equals(luggages, passenger.luggages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerId, email, name, surname, sit, luggages);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sit=" + sit +
                ", luggages=" + luggages +
                '}';
    }
}
