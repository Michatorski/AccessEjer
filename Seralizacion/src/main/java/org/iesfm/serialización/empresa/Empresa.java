package org.iesfm.serialización.empresa;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Empresa {

    private String nombre;
    private List<Departamento> departamentos;

    public Empresa() {

    }

    public List<Empleado> getListaEmpleados(String departNombre){
        List<Empleado> empleadosLista = new LinkedList<>();

        for (Departamento departamento: departamentos) {
            if (departamento.getNombre().equals(departNombre)){
                empleadosLista.addAll(departamento.getEmpleados());
            }
        }
        return empleadosLista;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(nombre, empresa.nombre) && Objects.equals(departamentos, empresa.departamentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, departamentos);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", departamentos=" + departamentos +
                '}';
    }
}