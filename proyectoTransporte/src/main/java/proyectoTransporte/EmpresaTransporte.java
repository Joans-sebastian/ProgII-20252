package proyectoTransporte;

import proyectoTransporte.model.*;
import java.util.*;
import javax.swing.JOptionPane;

public class EmpresaTransporte {
    private static EmpresaTransporte instancia;
    private String nombre;
    private List<Vehiculo> listaVehiculos = new ArrayList<>();
    private List<Propietario> listaPropietarios = new ArrayList<>();

    private EmpresaTransporte(String nombre) {
        this.nombre = nombre;
    }

    public static EmpresaTransporte getInstance(String nombre) {
        if (instancia == null) {
            instancia = new EmpresaTransporte(nombre);
        }
        return instancia;
    }

    public void inicializarDatosPrueba() {
        // Vehículos de pasajeros
        listaVehiculos.add(new proyectoTransporte.model.VehiculoPasajero(proyectoTransporte.model.TamanoVehiculo.MEDIANO, "VAL001", "2021", "Renault", "Azul", 30));
        listaVehiculos.add(new proyectoTransporte.model.VehiculoPasajero(proyectoTransporte.model.TamanoVehiculo.GRANDE, "VAL002", "2022", "Chevrolet", "Rojo", 40));
        listaVehiculos.add(new proyectoTransporte.model.VehiculoPasajero(proyectoTransporte.model.TamanoVehiculo.MEDIANO, "VAL003", "2023", "Mercedes", "Verde", 35));
    }

    public void crearPropietarioVehiculoCargaJOption() {
        String nombre = JOptionPane.showInputDialog("Nombre propietario:");
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID propietario:"));
        String email = JOptionPane.showInputDialog("Email propietario:");
        String celular = JOptionPane.showInputDialog("Celular propietario:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad propietario:"));
        String placaCarga = JOptionPane.showInputDialog("Placa vehículo de carga:");
        String modelo = JOptionPane.showInputDialog("Modelo vehículo de carga:");
        String marca = JOptionPane.showInputDialog("Marca vehículo de carga:");
        String color = JOptionPane.showInputDialog("Color vehículo de carga:");
        double capacidadCarga = Double.parseDouble(JOptionPane.showInputDialog("Capacidad de carga (kg):"));
        int numeroEjes = Integer.parseInt(JOptionPane.showInputDialog("Número de ejes (Entero) :"));
        TamanoVehiculo tamano = TamanoVehiculo.valueOf(
                JOptionPane.showInputDialog("Tamaño (PEQUENO, MEDIANO, GRANDE):").toUpperCase().trim()
        );

        listaVehiculos.add(new proyectoTransporte.model.VehiculoCarga(tamano, placaCarga, modelo, marca, color, capacidadCarga, numeroEjes));
        listaPropietarios.add(new proyectoTransporte.model.Propietario(nombre, id, email, celular, placaCarga, edad));

        JOptionPane.showMessageDialog(null, "Propietario y vehículo de carga registrados correctamente.");
    }

    public Map<String,Integer> registrarPasajerosJOption() {
        Map<String, Integer> pasajerosPorPlaca = new HashMap<>();
        for (Vehiculo v : listaVehiculos) {
            if (v instanceof VehiculoPasajero) {
                boolean valido = false;
                int pasajeros = 0;
                while (!valido) {
                    String input = JOptionPane.showInputDialog(
                            "Placa " + v.getPlaca() + " - Pasajeros transportados hoy:"
                    );
                    try {
                        pasajeros = Integer.parseInt(input);
                        valido = pasajeros >= 0;
                        if (!valido) {
                            JOptionPane.showMessageDialog(null, "Por favor ingresa un número positivo.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Por favor ingresa un número válido.");
                    }
                }
                pasajerosPorPlaca.put(v.getPlaca(), pasajeros);
            }
        }
        int total = calcularTotalPasajeros(pasajerosPorPlaca);
        JOptionPane.showMessageDialog(null, "TOTAL DE PASAJEROS TRANSPORTADOS HOY: " + total);
        return pasajerosPorPlaca;
    }

    public int calcularTotalPasajeros(Map<String, Integer> pasajerosPorPlaca) {
        int total = 0;
        for (int cant : pasajerosPorPlaca.values()) {
            total += cant;
        }
        return total;
    }

    // --- Funcionalidad a)
    public String consultarPropietariosPorPesoJOption() {
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor mínimo de peso del vehículo de carga:"));

        StringBuilder resultado = new StringBuilder("Propietarios con vehículo de carga superior a " + peso + " kg:\n");
        boolean hayProp = false;
        for (Propietario prop : listaPropietarios) {
            for (Vehiculo v : listaVehiculos) {
                if (v instanceof VehiculoCarga vehCarga
                        && prop.getVehiculo().equals(vehCarga.getPlaca())
                        && vehCarga.getCapacidadCarga() > peso) {
                    resultado.append(prop.getNombre()).append(" (Placa: ")
                            .append(prop.getVehiculo()).append(", Capacidad: ")
                            .append(vehCarga.getCapacidadCarga()).append("kg)\n");
                    hayProp = true;
                }
            }
        }
        if (!hayProp)
            resultado.append("Ninguno");
        return resultado.toString();
    }

    // --- Funcionalidad b)
    public String consultarUsuariosPorPlacaJOption(Map<String, Integer> pasajerosPorPlaca) {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo de transporte:");
        Integer cantidad = pasajerosPorPlaca.get(placa);
        if (cantidad != null) {
            return "Número de usuarios transportados en el vehículo con placa " + placa + ": " + cantidad;
        } else {
            return "No se encontró información de pasajeros para la placa ingresada.";
        }
    }

    // --- Funcionalidad c)
    public String consultarPropietariosMayoresDe40JOption() {
        int total = 0;
        for (Propietario prop : listaPropietarios) {
            if (prop.getEdad() > 40) {
                total++;
            }
        }
        return "Número de propietarios mayores de 40 años: " + total;
    }

    @Override
    public String toString() {
        return "EmpresaTransporte{" +
                "\nnombre='" + nombre + '\'' +
                ",\nlistaVehiculos=" + listaVehiculos +
                ",\nlistaPropietarios=" + listaPropietarios +
                "\n}";
    }
}
