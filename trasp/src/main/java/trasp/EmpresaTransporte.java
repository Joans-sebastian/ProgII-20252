package trasp;

import java.util.*;
import trasp.model.*;

public class EmpresaTransporte {
    private String nombre;
    private List<Vehiculo> listaVehiculos = new ArrayList<>();
    private List<Propietario> listaPropietarios = new ArrayList<>();

    public EmpresaTransporte(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public List<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }

    public void setListaPropietarios(List<Propietario> listaPropietarios) {
        this.listaPropietarios = listaPropietarios;
    }

    public int calcularTotalPasajeros(Map<String, Integer> pasajerosPorPlaca) {
        int total = 0;
        for (int cant : pasajerosPorPlaca.values()) {
            total += cant;
        }
        return total;
    }

    @Override
    public String toString() {
        return "EmpresaTransporte{" +
                "nombre='" + nombre + '\'' +
                ", listaVehiculos=" + listaVehiculos +
                ", listaPropietarios=" + listaPropietarios +
                '}';
    }
}