package co.edu.uniquindio.empresaTransporte.model;

import java.util.ArrayList;
import java.util.List;

public class Propietario {
    private String nombre;
    private String numeroIdentificacion;
    private String email;
    private String numeroCelular;
    private Vehiculo vehiculo;
    private int edad;
    private List<VehiculoCarga> listaVehiculosAsociados = new ArrayList<>();

    public Propietario() {}

    public Propietario(String nombre, String numeroIdentificacion, String email, String numeroCelular, Vehiculo vehiculo, int edad) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.vehiculo = vehiculo;
        this.edad = edad;
    }

    public void actualizarDatos(String nombre, String email, String celular, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.numeroCelular = celular;
        this.edad = edad;
    }

    // CRUD de vehículos asociados
    public void agregarVehiculoAsociado(VehiculoCarga v) { listaVehiculosAsociados.add(v); }

    public VehiculoCarga buscarVehiculoAsociadoPorPlaca(String placa) {
        for (VehiculoCarga v : listaVehiculosAsociados) {
            if (v.getPlaca().equalsIgnoreCase(placa)) return v;
        }
        return null;
    }

    public boolean eliminarVehiculoAsociadoPorPlaca(String placa) {
        return listaVehiculosAsociados.removeIf(v -> v.getPlaca().equalsIgnoreCase(placa));
    }

    public boolean actualizarVehiculoAsociado(String placa, String modelo, String marca, String color, double capacidad, int ejes) {
        VehiculoCarga v = buscarVehiculoAsociadoPorPlaca(placa);
        if (v != null) {
            v.actualizarDatos(modelo, marca, color, capacidad, ejes);
            return true;
        }
        return false;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNumeroIdentificacion() { return numeroIdentificacion; }
    public void setNumeroIdentificacion(String numeroIdentificacion) { this.numeroIdentificacion = numeroIdentificacion; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNumeroCelular() { return numeroCelular; }
    public void setNumeroCelular(String numeroCelular) { this.numeroCelular = numeroCelular; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public List<VehiculoCarga> getListaVehiculosAsociados() { return listaVehiculosAsociados; }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombre='" + nombre + '\'' +
                ", numeroIdentificacion='" + numeroIdentificacion + '\'' +
                ", email='" + email + '\'' +
                ", numeroCelular='" + numeroCelular + '\'' +
                ", edad=" + edad +
                '}';
    }
}