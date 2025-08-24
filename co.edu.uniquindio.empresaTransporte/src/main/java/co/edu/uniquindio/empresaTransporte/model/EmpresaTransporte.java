package co.edu.uniquindio.empresaTransporte.model;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransporte {
    private String nombre;
    private List<VehiculoCarga> listaVehiculosCarga = new ArrayList<>();
    private List<VehiculoPasajero> listaVehiculosPasajeros = new ArrayList<>();
    private List<Propietario> listaPropietarios = new ArrayList<>();

    public EmpresaTransporte() {}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<VehiculoCarga> getListaVehiculosCarga() { return listaVehiculosCarga; }
    public List<VehiculoPasajero> getListaVehiculosPasajeros() { return listaVehiculosPasajeros; }
    public List<Propietario> getListaPropietarios() { return listaPropietarios; }

    //------ CRUD VehiculoCarga ------
    public void agregarVehiculoCarga(VehiculoCarga v) { listaVehiculosCarga.add(v); }
    public VehiculoCarga buscarVehiculoCargaPorPlaca(String placa) {
        for (VehiculoCarga v : listaVehiculosCarga)
            if (v.getPlaca().equalsIgnoreCase(placa)) return v;
        return null;
    }
    public boolean eliminarVehiculoCargaPorPlaca(String placa) {
        return listaVehiculosCarga.removeIf(v -> v.getPlaca().equalsIgnoreCase(placa));
    }

    //------ CRUD VehiculoPasajero ------
    public void agregarVehiculoPasajero(VehiculoPasajero v) { listaVehiculosPasajeros.add(v); }
    public VehiculoPasajero buscarVehiculoPasajeroPorPlaca(String placa) {
        for (VehiculoPasajero v : listaVehiculosPasajeros)
            if (v.getPlaca().equalsIgnoreCase(placa)) return v;
        return null;
    }
    public boolean eliminarVehiculoPasajeroPorPlaca(String placa) {
        return listaVehiculosPasajeros.removeIf(v -> v.getPlaca().equalsIgnoreCase(placa));
    }

    //------ CRUD Propietario ------
    public void agregarPropietario(Propietario p) { listaPropietarios.add(p); }
    public Propietario buscarPropietarioPorId(String id) {
        for (Propietario p : listaPropietarios)
            if (p.getNumeroIdentificacion().equalsIgnoreCase(id)) return p;
        return null;
    }
    public boolean eliminarPropietarioPorId(String id) {
        return listaPropietarios.removeIf(p -> p.getNumeroIdentificacion().equalsIgnoreCase(id));
    }
    public boolean actualizarEmailPropietario(String id, String nuevoEmail) {
        Propietario p = buscarPropietarioPorId(id);
        if (p != null) { p.setEmail(nuevoEmail); return true; }
        return false;
    }

    @Override
    public String toString() {
        return "EmpresaTransporte{\n" +
                "nombre='" + nombre + "',\n" +
                "listaVehiculosCarga=" + listaVehiculosCarga + ",\n" +
                "listaVehiculosPasajeros=" + listaVehiculosPasajeros + ",\n" +
                "listaPropietarios=" + listaPropietarios + "\n}";
    }
}
