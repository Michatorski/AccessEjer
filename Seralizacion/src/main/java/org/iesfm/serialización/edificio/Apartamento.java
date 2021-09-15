package org.iesfm.serialización.edificio;

import java.util.List;
import java.util.Objects;

public class Apartamento {
    private int planta;
    private String puerta;
    private List<Propietario> propietarios;

    public Apartamento(){

    }

    public Apartamento(int planta, String puerta, List<Propietario> propietarios) {
        this.planta = planta;
        this.puerta = puerta;
        this.propietarios = propietarios;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public List<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartamento that = (Apartamento) o;
        return planta == that.planta && Objects.equals(puerta, that.puerta) && Objects.equals(propietarios, that.propietarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planta, puerta, propietarios);
    }

    @Override
    public String toString() {
        return "Apartamento{" +
                "numPlanta=" + planta +
                ", Puerta='" + puerta + '\'' +
                ", propietarios=" + propietarios +
                '}';
    }
}
