package trasp.model;

public class VehiculoPasajero extends Vehiculo {
    private int capacidadPasajeros;

    public VehiculoPasajero(TamanoVehiculo tamano, String placa, String modelo, String marca, String color, int capacidadPasajeros) {
        super(tamano, placa, modelo, marca, color);
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    @Override
    public String toString() {
        return "VehiculoPasajero{" +
                "placa=" + getPlaca() +
                ", capacidadPasajeros=" + capacidadPasajeros +
                '}';
    }
}