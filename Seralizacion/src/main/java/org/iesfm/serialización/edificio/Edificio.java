package org.iesfm.serialización.edificio;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Edificio {

    private String direccion;
    private String municipio;
    private List<Apartamento> apartamentos;

    public Edificio() {

    }

    public List<Apartamento> getApartamentoList(int planta){
        List<Apartamento> apartamentosLista = new LinkedList<>();

        for (Apartamento apartamento : apartamentos) {
            if (apartamento.getPlanta() == planta) {
                apartamentosLista.add(apartamento);
            }
        }

        return apartamentosLista;
    }

    public Edificio(String direccion, String municipio, List<Apartamento> apartamentos) {
        this.direccion = direccion;
        this.municipio = municipio;
        this.apartamentos = apartamentos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public List<Apartamento> getApartamentos() {
        return apartamentos;
    }

    public void setApartamentos(List<Apartamento> apartamentos) {
        this.apartamentos = apartamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edificio edificio = (Edificio) o;
        return Objects.equals(direccion, edificio.direccion) && Objects.equals(municipio, edificio.municipio) && Objects.equals(apartamentos, edificio.apartamentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccion, municipio, apartamentos);
    }

    @Override
    public String toString() {
        return "Edificio{" +
                "direccion='" + direccion + '\'' +
                ", municipio='" + municipio + '\'' +
                ", apartamentos=" + apartamentos +
                '}';
    }
}
