package proyectoTransporte.model;

public class Vehiculo {
    private TamanoVehiculo tamano;
    private String placa;
    private String modelo;
    private String marca;
    private String color;

    public Vehiculo(TamanoVehiculo tamano, String placa, String modelo, String marca, String color) {
        this.tamano = tamano;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "tamano=" + tamano +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
