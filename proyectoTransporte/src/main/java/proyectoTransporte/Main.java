package proyectoTransporte;

import javax.swing.JOptionPane;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmpresaTransporte empresa = EmpresaTransporte.getInstance("La Carreta");

        empresa.inicializarDatosPrueba();

        empresa.crearPropietarioVehiculoCargaJOption();

        Map<String,Integer> pasajerosPorPlaca = empresa.registrarPasajerosJOption();

        // Funcionalidad a)
        JOptionPane.showMessageDialog(null, empresa.consultarPropietariosPorPesoJOption());
        // Funcionalidad b)
        JOptionPane.showMessageDialog(null, empresa.consultarUsuariosPorPlacaJOption(pasajerosPorPlaca));
        // Funcionalidad c)
        JOptionPane.showMessageDialog(null, empresa.consultarPropietariosMayoresDe40JOption());

        JOptionPane.showMessageDialog(null, "Estado final de la empresa:\n" + empresa);
    }
}