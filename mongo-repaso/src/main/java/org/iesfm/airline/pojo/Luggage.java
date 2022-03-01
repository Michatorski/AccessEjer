package org.iesfm.airline.pojo;

import java.util.Objects;

public class Luggage {
    private int code;
    private String description;

    public Luggage(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public Luggage(){

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Luggage luggage = (Luggage) o;
        return code == luggage.code && Objects.equals(description, luggage.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description);
    }

    @Override
    public String toString() {
        return "Luggage{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}
