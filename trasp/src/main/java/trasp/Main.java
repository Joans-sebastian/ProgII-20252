package trasp;

import trasp.model.*;
import javax.swing.JOptionPane;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmpresaTransporte empresa = inicializarDatosPrueba();

        crearPropietarioVehiculoCarga(empresa);

        // Registrar pasajeros por placa y guardar el map
        Map<String, Integer> pasajerosPorPlaca = calcularTotalPasajerosTransportadosRetMap(empresa);

        // Funcionalidad a)
        mostrarPropietariosPorPeso(empresa);

        // Funcionalidad b)
        mostrarUsuariosPorPlaca(empresa, pasajerosPorPlaca);

        // Funcionalidad c)
        mostrarCantidadPropietariosMayores40(empresa);

        JOptionPane.showMessageDialog(null, "Estado final de la empresa: \n" + empresa);
    }

    private static EmpresaTransporte inicializarDatosPrueba() {
        EmpresaTransporte empresa = new EmpresaTransporte("La Carreta");

        // Vehículos de pasajeros de prueba
        VehiculoPasajero bus1 = new VehiculoPasajero(TamanoVehiculo.MEDIANO, "VAL001", "2021", "Renault", "Azul", 30);
        VehiculoPasajero bus2 = new VehiculoPasajero(TamanoVehiculo.GRANDE, "VAL002", "2022", "Chevrolet", "Rojo", 40);
        VehiculoPasajero bus3 = new VehiculoPasajero(TamanoVehiculo.MEDIANO, "VAL003", "2023", "Mercedes", "Verde", 35);

        empresa.getListaVehiculos().add(bus1);
        empresa.getListaVehiculos().add(bus2);
        empresa.getListaVehiculos().add(bus3);

        return empresa;
    }

    private static void crearPropietarioVehiculoCarga(EmpresaTransporte empresa) {
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
        int numeroEjes = Integer.parseInt(JOptionPane.showInputDialog("Número de ejes:"));
        TamanoVehiculo tamano = TamanoVehiculo.valueOf(
                JOptionPane.showInputDialog("Tamaño (PEQUENO, MEDIANO, GRANDE):").toUpperCase().trim()
        );

        VehiculoCarga vehiculoCarga = new VehiculoCarga(tamano, placaCarga, modelo, marca, color, capacidadCarga, numeroEjes);
        Propietario propietario = new Propietario(nombre, id, email, celular, placaCarga, edad);

        empresa.getListaVehiculos().add(vehiculoCarga);
        empresa.getListaPropietarios().add(propietario);

        JOptionPane.showMessageDialog(null, "Propietario y vehículo de carga registrados correctamente.");
    }

    private static Map<String, Integer> calcularTotalPasajerosTransportadosRetMap(EmpresaTransporte empresa) {
        Map<String, Integer> pasajerosPorPlaca = new HashMap<>();
        for (Vehiculo v : empresa.getListaVehiculos()) {
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
        int total = empresa.calcularTotalPasajeros(pasajerosPorPlaca);
        JOptionPane.showMessageDialog(null, "TOTAL DE PASAJEROS TRANSPORTADOS HOY: " + total);
        return pasajerosPorPlaca;
    }

    // a) Lista de propietarios con vehículo de carga superior a peso dado
    private static void mostrarPropietariosPorPeso(EmpresaTransporte empresa) {
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor mínimo de peso del vehículo de carga:"));

        StringBuilder resultado = new StringBuilder("Propietarios con vehículo de carga superior a " + peso + " kg:\n");
        boolean hayProp = false;
        for (Propietario prop : empresa.getListaPropietarios()) {
            for (Vehiculo v : empresa.getListaVehiculos()) {
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
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    // b) Número de usuarios que se movieron en vehículo por placa
    private static void mostrarUsuariosPorPlaca(EmpresaTransporte empresa, Map<String, Integer> pasajerosPorPlaca) {
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo de transporte:");
        Integer cantidad = pasajerosPorPlaca.get(placa);
        String mensaje;

        if (cantidad != null) {
            mensaje = "Número de usuarios transportados en el vehículo con placa " + placa + ": " + cantidad;
        } else {
            mensaje = "No se encontró información de pasajeros para la placa ingresada.";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // c) Número de propietarios mayores de 40 años
    private static void mostrarCantidadPropietariosMayores40(EmpresaTransporte empresa) {
        int total = 0;
        for (Propietario prop : empresa.getListaPropietarios()) {
            if (prop.getEdad() > 40) {
                total++;
            }
        }
        String mensaje = "Número de propietarios mayores de 40 años: " + total;
        JOptionPane.showMessageDialog(null, mensaje);
    }
}