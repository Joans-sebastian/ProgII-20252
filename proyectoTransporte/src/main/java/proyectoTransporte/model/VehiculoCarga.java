package proyectoTransporte.model;

public class VehiculoCarga extends Vehiculo {
    private double capacidadCarga;
    private int numeroEjes;

    public VehiculoCarga(TamanoVehiculo tamano, String placa, String modelo, String marca, String color, double capacidadCarga, int numeroEjes) {
        super(tamano, placa, modelo, marca, color);
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    @Override
    public String toString() {
        return "VehiculoCarga{" +
                "placa=" + getPlaca() +
                ", capacidadCarga=" + capacidadCarga +
                ", numeroEjes=" + numeroEjes +
                '}';
    }
}
