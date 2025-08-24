package co.edu.uniquindio.empresaTransporte.model;

public class VehiculoCarga extends Vehiculo {
    private double capacidadCarga;
    private int numeroEjes;

    public VehiculoCarga() {}

    public VehiculoCarga(String placa, String modelo, String marca, String color, double capacidadCarga) {
        super(placa, modelo, marca, color);
        this.capacidadCarga = capacidadCarga;
    }

    public void actualizarDatos(String modelo, String marca, String color, double capacidad, int ejes) {
        super.actualizarDatos(modelo, marca, color);
        this.capacidadCarga = capacidad;
        this.numeroEjes = ejes;
    }

    public double getCapacidadCarga() { return capacidadCarga; }
    public void setCapacidadCarga(double capacidadCarga) { this.capacidadCarga = capacidadCarga; }
    public int getNumeroEjes() { return numeroEjes; }
    public void setNumeroEjes(int numeroEjes) { this.numeroEjes = numeroEjes; }

    @Override
    public String toString() {
        return "VehiculoCarga{" +
                "placa='" + getPlaca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", color='" + getColor() + '\'' +
                ", capacidadCarga=" + capacidadCarga +
                ", numeroEjes=" + numeroEjes +
                '}';
    }
}