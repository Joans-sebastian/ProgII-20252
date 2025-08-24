package co.edu.uniquindio.empresaTransporte.factory;

import co.edu.uniquindio.empresaTransporte.model.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.util.Map;
import java.util.HashMap;

public class ModelFactory {
    private static ModelFactory instance;
    private EmpresaTransporte empresaTransporte;

    private ModelFactory() { }

    public static ModelFactory getInstance() {
        if (instance == null) instance = new ModelFactory();
        return instance;
    }

    public EmpresaTransporte getEmpresaTransporte() { return empresaTransporte; }

    // ------ CREAR EMPRESA por ventana ------
    public void crearEmpresaJOption() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la Empresa:");
        empresaTransporte = new EmpresaTransporte();
        empresaTransporte.setNombre(nombre);
        JOptionPane.showMessageDialog(null, "Empresa '" + nombre + "' creada correctamente.");
    }

    // =========== CRUD VehiculoCarga ==========
    public void menuCrudVehiculoCargaJOption() {
        String opc = JOptionPane.showInputDialog("""
            Gestionar Vehículo de Carga
            1. Crear
            2. Buscar
            3. Actualizar
            4. Eliminar
            0. Volver
            """);
        if (opc == null || opc.equals("0")) return;
        switch (opc) {
            case "1" -> crearVehiculoCargaJOption();
            case "2" -> buscarVehiculoCargaJOption();
            case "3" -> actualizarVehiculoCargaJOption();
            case "4" -> eliminarVehiculoCargaJOption();
        }
    }
    public void crearVehiculoCargaJOption() {
        String placa = JOptionPane.showInputDialog("Placa:");
        String modelo = JOptionPane.showInputDialog("Modelo:");
        String marca = JOptionPane.showInputDialog("Marca:");
        String color = JOptionPane.showInputDialog("Color:");
        double capacidad = Double.parseDouble(JOptionPane.showInputDialog("Capacidad carga:"));
        int ejes = Integer.parseInt(JOptionPane.showInputDialog("Número de ejes:"));
        VehiculoCarga v = new VehiculoCarga(placa, modelo, marca, color, capacidad);
        v.setNumeroEjes(ejes);
        empresaTransporte.agregarVehiculoCarga(v);
        JOptionPane.showMessageDialog(null, "Vehículo de carga creado.");
    }
    public void buscarVehiculoCargaJOption() {
        String placa = JOptionPane.showInputDialog("Placa a buscar:");
        VehiculoCarga v = empresaTransporte.buscarVehiculoCargaPorPlaca(placa);
        JOptionPane.showMessageDialog(null, v != null ? v : "No existe.");
    }
    public void actualizarVehiculoCargaJOption() {
        String placa = JOptionPane.showInputDialog("Placa a actualizar:");
        VehiculoCarga v = empresaTransporte.buscarVehiculoCargaPorPlaca(placa);
        if (v == null) {
            JOptionPane.showMessageDialog(null, "No existe.");
            return;
        }
        String modelo = JOptionPane.showInputDialog("Modelo actual: "+v.getModelo()+"\nNuevo modelo:");
        String marca = JOptionPane.showInputDialog("Marca actual: "+v.getMarca()+"\nNueva marca:");
        String color = JOptionPane.showInputDialog("Color actual: "+v.getColor()+"\nNuevo color:");
        double capacidad = Double.parseDouble(JOptionPane.showInputDialog("Capacidad actual: "+v.getCapacidadCarga()+"\nNueva capacidad:"));
        int ejes = Integer.parseInt(JOptionPane.showInputDialog("Ejes actual: "+v.getNumeroEjes()+"\nNuevo número de ejes:"));
        v.actualizarDatos(modelo, marca, color, capacidad, ejes);
        JOptionPane.showMessageDialog(null, "Actualizado.");
    }
    public void eliminarVehiculoCargaJOption() {
        String placa = JOptionPane.showInputDialog("Placa a eliminar:");
        boolean elim = empresaTransporte.eliminarVehiculoCargaPorPlaca(placa);
        JOptionPane.showMessageDialog(null, elim ? "Eliminado." : "No existe.");
    }

    // =========== CRUD VehiculoPasajero ==========
    public void menuCrudVehiculoPasajeroJOption() {
        String opc = JOptionPane.showInputDialog("""
            Gestionar Vehículo de Pasajeros
            1. Crear
            2. Buscar
            3. Actualizar
            4. Eliminar
            0. Volver
            """);
        if (opc == null || opc.equals("0")) return;
        switch (opc) {
            case "1" -> crearVehiculoPasajeroJOption();
            case "2" -> buscarVehiculoPasajeroJOption();
            case "3" -> actualizarVehiculoPasajeroJOption();
            case "4" -> eliminarVehiculoPasajeroJOption();
        }
    }
    public void crearVehiculoPasajeroJOption() {
        String placa = JOptionPane.showInputDialog("Placa:");
        String modelo = JOptionPane.showInputDialog("Modelo:");
        String marca = JOptionPane.showInputDialog("Marca:");
        String color = JOptionPane.showInputDialog("Color:");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Capacidad máxima pasajeros:"));
        VehiculoPasajero v = new VehiculoPasajero(placa, modelo, marca, color, capacidad);
        empresaTransporte.agregarVehiculoPasajero(v);
        JOptionPane.showMessageDialog(null, "Vehículo de pasajeros creado.");
    }
    public void buscarVehiculoPasajeroJOption() {
        String placa = JOptionPane.showInputDialog("Placa a buscar:");
        VehiculoPasajero v = empresaTransporte.buscarVehiculoPasajeroPorPlaca(placa);
        JOptionPane.showMessageDialog(null, v != null ? v : "No existe.");
    }
    public void actualizarVehiculoPasajeroJOption() {
        String placa = JOptionPane.showInputDialog("Placa a actualizar:");
        VehiculoPasajero v = empresaTransporte.buscarVehiculoPasajeroPorPlaca(placa);
        if (v == null) {
            JOptionPane.showMessageDialog(null, "No existe.");
            return;
        }
        String modelo = JOptionPane.showInputDialog("Modelo actual: "+v.getModelo()+"\nNuevo modelo:");
        String marca = JOptionPane.showInputDialog("Marca actual: "+v.getMarca()+"\nNueva marca:");
        String color = JOptionPane.showInputDialog("Color actual: "+v.getColor()+"\nNuevo color:");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Capacidad actual: "+v.getNumeroMaximoPasajeros()+"\nNueva capacidad:"));
        v.actualizarDatos(modelo, marca, color, capacidad);
        JOptionPane.showMessageDialog(null, "Actualizado.");
    }
    public void eliminarVehiculoPasajeroJOption() {
        String placa = JOptionPane.showInputDialog("Placa a eliminar:");
        boolean elim = empresaTransporte.eliminarVehiculoPasajeroPorPlaca(placa);
        JOptionPane.showMessageDialog(null, elim ? "Eliminado." : "No existe.");
    }

    // =========== CRUD Propietario ==========
    public void menuCrudPropietarioJOption() {
        String opc = JOptionPane.showInputDialog("""
            Gestionar Propietarios
            1. Crear
            2. Buscar
            3. Actualizar
            4. Eliminar
            0. Volver
            """);
        if (opc == null || opc.equals("0")) return;
        switch (opc) {
            case "1" -> crearPropietarioJOption();
            case "2" -> buscarPropietarioJOption();
            case "3" -> actualizarPropietarioJOption();
            case "4" -> eliminarPropietarioJOption();
        }
    }
    public void crearPropietarioJOption() {
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String id = JOptionPane.showInputDialog("ID:");
        String email = JOptionPane.showInputDialog("Email:");
        String celular = JOptionPane.showInputDialog("Celular:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
        Propietario p = new Propietario();
        p.setNombre(nombre); p.setNumeroIdentificacion(id); p.setEmail(email); p.setNumeroCelular(celular); p.setEdad(edad);
        empresaTransporte.agregarPropietario(p);
        JOptionPane.showMessageDialog(null, "Propietario creado.");
    }
    public void buscarPropietarioJOption() {
        String id = JOptionPane.showInputDialog("ID propietario:");
        Propietario p = empresaTransporte.buscarPropietarioPorId(id);
        JOptionPane.showMessageDialog(null, p != null ? p : "No existe.");
    }
    public void actualizarPropietarioJOption() {
        String id = JOptionPane.showInputDialog("ID propietario a actualizar:");
        Propietario p = empresaTransporte.buscarPropietarioPorId(id);
        if (p == null) {
            JOptionPane.showMessageDialog(null, "No existe.");
            return;
        }
        String nombre = JOptionPane.showInputDialog("Nombre actual: "+p.getNombre()+"\nNuevo nombre:");
        String email = JOptionPane.showInputDialog("Email actual: "+p.getEmail()+"\nNuevo email:");
        String celular = JOptionPane.showInputDialog("Celular actual: "+p.getNumeroCelular()+"\nNuevo celular:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad actual: "+p.getEdad()+"\nNueva edad:"));
        p.actualizarDatos(nombre, email, celular, edad);
        JOptionPane.showMessageDialog(null, "Actualizado.");
    }
    public void eliminarPropietarioJOption() {
        String id = JOptionPane.showInputDialog("ID propietario a eliminar:");
        boolean elim = empresaTransporte.eliminarPropietarioPorId(id);
        JOptionPane.showMessageDialog(null, elim ? "Eliminado." : "No existe.");
    }

    // ======= CONSULTAS DEL ENUNCIADO Y PASAJEROS =======
    public Map<String,Integer> registrarPasajerosJOption() {
        Map<String, Integer> pasajerosPorPlaca = new HashMap<>();
        for (VehiculoPasajero vp : empresaTransporte.getListaVehiculosPasajeros()) {
            int pasajeros = Integer.parseInt(JOptionPane.showInputDialog("Placa " + vp.getPlaca() + " - Pasajeros hoy:"));
            pasajerosPorPlaca.put(vp.getPlaca(), pasajeros);
        }
        return pasajerosPorPlaca;
    }
    public String consultarPropietariosPorPesoJOption() {
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Valor mínimo peso carga:"));
        StringBuilder sb = new StringBuilder("Propietarios con vehículo de carga > " + peso + "kg:\n");
        boolean ok = false;
        for(Propietario p : empresaTransporte.getListaPropietarios()) {
            if (p.getVehiculo() instanceof VehiculoCarga vc && vc.getCapacidadCarga() > peso) {
                sb.append(p.getNombre()).append(" (").append(vc.getPlaca()).append(", ")
                        .append(vc.getCapacidadCarga()).append("kg)\n");
                ok = true;
            }
        }
        if (!ok) sb.append("Ninguno");
        return sb.toString();
    }
    public String consultarUsuariosPorPlacaJOption(Map<String,Integer> pasajerosPorPlaca) {
        String placa = JOptionPane.showInputDialog("Placa vehículo pasajeros:");
        Integer cant = pasajerosPorPlaca.get(placa);
        return cant != null ? "Usuarios transportados en " + placa + ": " + cant : "No existe.";
    }
    public String consultarPropietariosMayoresDe40JOption() {
        int total = 0;
        for(Propietario p : empresaTransporte.getListaPropietarios()) if (p.getEdad() > 40) total++;
        return "Propietarios mayores de 40 años: " + total;
    }
}
