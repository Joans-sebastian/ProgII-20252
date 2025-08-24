package co.edu.uniquindio.empresaTransporte.model;

public class VehiculoPasajero extends Vehiculo {
    private int numeroMaximoPasajeros;

    public VehiculoPasajero() {}

    public VehiculoPasajero(String placa, String modelo, String marca, String color, int numPasajeros) {
        super(placa, modelo, marca, color);
        this.numeroMaximoPasajeros = numPasajeros;
    }

    public void actualizarDatos(String modelo, String marca, String color, int capacidad) {
        super.actualizarDatos(modelo, marca, color);
        this.numeroMaximoPasajeros = capacidad;
    }

    public int getNumeroMaximoPasajeros() { return numeroMaximoPasajeros; }
    public void setNumeroMaximoPasajeros(int numeroMaximoPasajeros) { this.numeroMaximoPasajeros = numeroMaximoPasajeros; }

    @Override
    public String toString() {
        return "VehiculoPasajero{" +
                "placa='" + getPlaca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", color='" + getColor() + '\'' +
                ", capacidadPasajeros=" + numeroMaximoPasajeros +
                '}';
    }
}