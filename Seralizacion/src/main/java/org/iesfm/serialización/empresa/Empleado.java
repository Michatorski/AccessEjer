package org.iesfm.serialización.empresa;

import java.util.Objects;

public class Empleado {
    private String nif;
    private String nombre;
    private String apellidos;
    private String cargo;

    public Empleado(){

    }

    public Empleado(String nif, String nombre, String apellidos, String cargo) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cargo = cargo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(nif, empleado.nif) && Objects.equals(nombre, empleado.nombre) && Objects.equals(apellidos, empleado.apellidos) && Objects.equals(cargo, empleado.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, nombre, apellidos, cargo);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nif='" + nif + '\'' +
                ", name='" + nombre + '\'' +
                ", surname='" + apellidos + '\'' +
                ", position='" + cargo + '\'' +
                '}';
    }
}
