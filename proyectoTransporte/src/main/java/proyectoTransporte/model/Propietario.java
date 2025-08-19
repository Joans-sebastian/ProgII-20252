package proyectoTransporte.model;

public class Propietario {
    private String nombre;
    private int numeroId;
    private String email;
    private String celular;
    private String vehiculo; // Placa asociada
    private int edad;

    public Propietario(String nombre, int numeroId, String email, String celular, String vehiculo, int edad) {
        this.nombre = nombre;
        this.numeroId = numeroId;
        this.email = email;
        this.celular = celular;
        this.vehiculo = vehiculo;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }
    public String getNombre() {
        return nombre;
    }
    public String getVehiculo() {
        return vehiculo;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombre='" + nombre + '\'' +
                ", numeroId=" + numeroId +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", vehiculo='" + vehiculo + '\'' +
                ", edad=" + edad +
                '}';
    }
}
