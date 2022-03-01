package org.iesfm.airline.pojo;

import java.io.Serializable;
import java.util.Objects;

public class PassengerId implements Serializable {
    private String nif;
    private int flightNumber;

    public PassengerId(String nif, int flightNumber) {
        this.nif = nif;
        this.flightNumber = flightNumber;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerId that = (PassengerId) o;
        return flightNumber == that.flightNumber && Objects.equals(nif, that.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, flightNumber);
    }

    @Override
    public String toString() {
        return "PassengerId{" +
                "nif='" + nif + '\'' +
                ", flightNumber=" + flightNumber +
                '}';
    }
}
