package org.iesfm.serialización.empresa;

import java.util.List;
import java.util.Objects;

public class Departamento {
    private String nombre;
    private List <Empleado> empleados;

    public Departamento(){

    }

    public Departamento(String nombre, List<Empleado> empleados) {
        this.nombre = nombre;
        this.empleados = empleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(empleados, that.empleados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, empleados);
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "name='" + nombre + '\'' +
                ", empleados=" + empleados +
                '}';
    }
}
