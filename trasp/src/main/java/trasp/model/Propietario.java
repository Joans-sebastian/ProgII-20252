package trasp.model;

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

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(int numeroId) {
        this.numeroId = numeroId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
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