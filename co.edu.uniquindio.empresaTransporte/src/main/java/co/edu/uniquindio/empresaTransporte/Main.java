package co.edu.uniquindio.empresaTransporte;

import co.edu.uniquindio.empresaTransporte.factory.ModelFactory;

import javax.swing.JOptionPane;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();

        // Crear la empresa por ventana
        modelFactory.crearEmpresaJOption();

        boolean salir = false;
        Map<String, Integer> pasajerosPorPlaca = null;
        while (!salir) {
            String opcion = JOptionPane.showInputDialog("""
                            MENÚ PRINCIPAL:
                Selecccione la opcion que necesite:
                
                1. Vehículos de Carga
                2. Vehículos de Pasajeros
                3. Propietarios
                4. Registrar pasajeros en vehículos de pasajeros
                5. Consulta Propietarios por peso ((a) enunciado)
                6. Consulta Pasajeros por placa ((b)enunciado)
                7. Consulta Propietarios > 40 años ((c)enunciado)
                8. Mostrar estado empresa
                0. Salir
                """);
            if (opcion == null || opcion.equals("0")) break;
            switch (opcion) {
                case "1" -> modelFactory.menuCrudVehiculoCargaJOption();
                case "2" -> modelFactory.menuCrudVehiculoPasajeroJOption();
                case "3" -> modelFactory.menuCrudPropietarioJOption();
                case "4" -> pasajerosPorPlaca = modelFactory.registrarPasajerosJOption();
                case "5" -> JOptionPane.showMessageDialog(null, modelFactory.consultarPropietariosPorPesoJOption());
                case "6" -> {
                    if (pasajerosPorPlaca == null) {
                        JOptionPane.showMessageDialog(null, "Registra pasajeros primero (opción 4)");
                    } else {
                        JOptionPane.showMessageDialog(null, modelFactory.consultarUsuariosPorPlacaJOption(pasajerosPorPlaca));
                    }
                }
                case "7" -> JOptionPane.showMessageDialog(null, modelFactory.consultarPropietariosMayoresDe40JOption());
                case "8" -> JOptionPane.showMessageDialog(null, modelFactory.getEmpresaTransporte());
                default -> JOptionPane.showMessageDialog(null, "Opción incorrecta.");
            }
        }
        JOptionPane.showMessageDialog(null, "Estamos trabajando para brindarle un mejor servicio " +
                ", GRACIAS ¡HASTA LA PROXIMA!");
    }
}