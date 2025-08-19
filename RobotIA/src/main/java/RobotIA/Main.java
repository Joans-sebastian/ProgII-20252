package RobotIA;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}
//package co.edu.uniquindio.pr2.factory;
//
//import co.edu.uniquindio.pr2.model.EmpresaTransporte;
//import co.edu.uniquindio.pr2.model.Propietario;
//import co.edu.uniquindio.pr2.model.VehiculoCarga;
//import co.edu.uniquindio.pr2.model.VehiculoPasajero;
//
//public class ModelFactory {
//    private static ModelFactory instance;
//
//    EmpresaTransporte empresaTransporte;
//
//    private ModelFactory() {
//    }
//
//    public static ModelFactory getInstance() {
//        if(instance == null) {
//            instance = new ModelFactory();
//        }
//        return instance;
//    }
//
//    public EmpresaTransporte inicializarDatos() {
//        EmpresaTransporte empresa = new EmpresaTransporte();
//        empresa.setNombre("La carreta");
//        VehiculoCarga vehiculoCarga = new VehiculoCarga();
//        vehiculoCarga.setCapacidadCarga(200);
//        VehiculoCarga vehiculoCarga2 = new VehiculoCarga();
//        vehiculoCarga2.setCapacidadCarga(500);
//        VehiculoPasajero vehiculoPasajero = new VehiculoPasajero();
//        vehiculoPasajero.setNumeroMaximoPasajeros(10);
//        Propietario propietario = new Propietario();
//        propietario.setNombre("Pedro");
//        propietario.setVehiculo(vehiculoCarga);
//        propietario.getListaVehiculosAsociados().add(vehiculoCarga2);
//        empresa.getListaVehiculosCarga().add(vehiculoCarga);
//        empresa.getListaVehiculosPasajeros().add(vehiculoPasajero);
//        empresa.getListaPropietarios().add(propietario);
//        this.empresaTransporte = empresa;
//
//        return empresa;
//    }
//
//    public EmpresaTransporte getEmpresaTransporte() {
//        return empresaTransporte;
//    }
//
//
//    public void crearPropietarioVehiculoCarga(String propietario, String vehiculo) {
//        getEmpresaTransporte().crearPropietarioVehiculoCarga(propietario, vehiculo);
//    }
//}
/// /empresatransporte
//package co.edu.uniquindio.pr2.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class EmpresaTransporte {
//    private String nombre;
//
//    private List<VehiculoCarga> listaVehiculosCarga = new ArrayList<>();
//    private List<VehiculoPasajero> listaVehiculosPasajeros = new ArrayList<>();
//    private List<Propietario> listaPropietarios = new ArrayList<>();
//
//    public EmpresaTransporte() {
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public List<VehiculoCarga> getListaVehiculosCarga() {
//        return listaVehiculosCarga;
//    }
//
//    public void setListaVehiculosCarga(List<VehiculoCarga> listaVehiculosCarga) {
//        this.listaVehiculosCarga = listaVehiculosCarga;
//    }
//
//    public List<VehiculoPasajero> getListaVehiculosPasajeros() {
//        return listaVehiculosPasajeros;
//    }
//
//    public void setListaVehiculosPasajeros(List<VehiculoPasajero> listaVehiculosPasajeros) {
//        this.listaVehiculosPasajeros = listaVehiculosPasajeros;
//    }
//
//    public List<Propietario> getListaPropietarios() {
//        return listaPropietarios;
//    }
//
//    public void setListaPropietarios(List<Propietario> listaPropietarios) {
//        this.listaPropietarios = listaPropietarios;
//    }
//
//    public void crearPropietarioVehiculoCarga(String propietario, String vehiculo) {
//        Propietario propietarioObj = new Propietario();
//        propietarioObj.setNombre(propietario);
//        VehiculoCarga vehiculoObj = new VehiculoCarga();
//        vehiculoObj.setPlaca(vehiculo);
//        propietarioObj.setVehiculo(vehiculoObj);
//        listaPropietarios.add(propietarioObj);
//    }
//}
////Propietario
//package co.edu.uniquindio.pr2.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Propietario {
//    private String nombre;
//    private String numeroIdentificacion;
//    private String email;
//    private String numeroCelular;
//    private Vehiculo vehiculo;
//
//    private List<VehiculoCarga> listaVehiculosAsociados = new ArrayList<>();
//
//    EmpresaTransporte ownedByEmpresaTransporte;
//
//    public Propietario() {
//    }
//
//    public Propietario(String nombre, String numeroIdentificacion, String email, String numeroCelular, Vehiculo vehiculo) {
//        this.nombre = nombre;
//        this.numeroIdentificacion = numeroIdentificacion;
//        this.email = email;
//        this.numeroCelular = numeroCelular;
//        this.vehiculo = vehiculo;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getNumeroIdentificacion() {
//        return numeroIdentificacion;
//    }
//
//    public void setNumeroIdentificacion(String numeroIdentificacion) {
//        this.numeroIdentificacion = numeroIdentificacion;
//    }
//
//    @Override
//    public String toString() {
//        return "Propietario{" +
//                "nombre='" + nombre + '\'' +
//                ", numeroIdentificacion='" + numeroIdentificacion + '\'' +
//                ", email='" + email + '\'' +
//                ", numeroCelular='" + numeroCelular + '\'' +
//                '}';
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getNumeroCelular() {
//        return numeroCelular;
//    }
//
//    public void setNumeroCelular(String numeroCelular) {
//        this.numeroCelular = numeroCelular;
//    }
//
//    public Vehiculo getVehiculo() {
//        return vehiculo;
//    }
//
//    public void setVehiculo(Vehiculo vehiculo) {
//        this.vehiculo = vehiculo;
//    }
//
//    public List<VehiculoCarga> getListaVehiculosAsociados() {
//        return listaVehiculosAsociados;
//    }
//
//    public void setListaVehiculosAsociados(List<VehiculoCarga> listaVehiculosAsociados) {
//        this.listaVehiculosAsociados = listaVehiculosAsociados;
//    }
//
//}
//
////VehiculoCarga
//package co.edu.uniquindio.pr2.model;
//
//public class VehiculoCarga extends Vehiculo {
//    private double capacidadCarga;
//    private int numeroEjes;
//
//    public VehiculoCarga() {
//    }
//
//
//    public VehiculoCarga(String placa, String modelo, String marca, String color, double capacidadCarga) {
//        super(placa, modelo, marca, color);
//        this.capacidadCarga = capacidadCarga;
//    }
//
//    public double getCapacidadCarga() {
//        return capacidadCarga;
//    }
//
//    public void setCapacidadCarga(double capacidadCarga) {
//        this.capacidadCarga = capacidadCarga;
//    }
//
//    public int getNumeroEjes() {
//        return numeroEjes;
//    }
//
//    public void setNumeroEjes(int numeroEjes) {
//        this.numeroEjes = numeroEjes;
//    }
//
//    @Override
//    public void encender() {
//        System.out.println("Endenciendo el vehiculo para cargarlo");
//    }
//
//}
//
////VehiculoPasajero
//package co.edu.uniquindio.pr2.model;
//
//public class VehiculoPasajero extends Vehiculo {
//    private int numeroMaximoPasajeros;
//
//    public VehiculoPasajero() {
//    }
//
//    public VehiculoPasajero(String placa, String modelo, String marca, String color, int numeroMaximoPasajeros) {
//        super(placa, modelo, marca, color);
//        this.numeroMaximoPasajeros = numeroMaximoPasajeros;
//    }
//
//    public int getNumeroMaximoPasajeros() {
//        return numeroMaximoPasajeros;
//    }
//
//    public void setNumeroMaximoPasajeros(int numeroMaximoPasajeros) {
//        this.numeroMaximoPasajeros = numeroMaximoPasajeros;
//    }
//
//    @Override
//    public void encender() {
//        System.out.println("No me encendio......ayuda");
//    }
//
//}
//
////Vehiculo
//package co.edu.uniquindio.pr2.model;
//
//public class Vehiculo {
//    private String placa;
//    private String modelo;
//    private String marca;
//    private String color;
//
//    public Vehiculo() {
//    }
//
//    public Vehiculo(String placa, String modelo, String marca, String color) {
//        this.placa = placa;
//        this.modelo = modelo;
//        this.marca = marca;
//        this.color = color;
//    }
//
//    public String getPlaca() {
//        return placa;
//    }
//
//    public void setPlaca(String placa) {
//        this.placa = placa;
//    }
//
//    public String getModelo() {
//        return modelo;
//    }
//
//    public void setModelo(String modelo) {
//        this.modelo = modelo;
//    }
//
//    public String getMarca() {
//        return marca;
//    }
//
//    public void setMarca(String marca) {
//        this.marca = marca;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//
//
//    public void encender(){
//        System.out.println("Encendiendo mi vehiculo");
//    }
//
//    @Override
//    public String toString() {
//        return "Vehiculo{" +
//                "placa='" + placa + '\'' +
//                ", modelo='" + modelo + '\'' +
//                ", marca='" + marca + '\'' +
//                ", color='" + color + '\'' +
//                '}';
//    }
//
//}
//
////main
//package co.edu.uniquindio.pr2;
//
//import co.edu.uniquindio.pr2.factory.ModelFactory;
//import co.edu.uniquindio.pr2.model.*;
//
//public class Main {
//    public static void main(String[] args) {
//        ModelFactory modelFactory = ModelFactory.getInstance();
//        EmpresaTransporte empresaTransporte = modelFactory.inicializarDatos();
//        crearPropietarioVehiculoCarga(modelFactory);
//        calcularTotalPasajerosTransportados(empresaTransporte);
//    }
//
//    private static void calcularTotalPasajerosTransportados(EmpresaTransporte empresaTransporte) {
//
//    }
//
//    private static void crearPropietarioVehiculoCarga(ModelFactory modelFactory) {
//        String propietario = "Pepe";
//        String vehiculo = "ARM 2232";
//        modelFactory.crearPropietarioVehiculoCarga(propietario, vehiculo);
//    }
//}
//
////metodos
//// Ejercicio 1: Inicializar datos de prueba
//public void inicializarDatosPrueba() {
//    VehiculoPasajero vp1 = new VehiculoPasajero(TamanoVehiculo.MEDIANO, "AAA111", "2019", "Chevrolet", "Rojo", 40);
//    VehiculoPasajero vp2 = new VehiculoPasajero(TamanoVehiculo.MEDIANO, "BBB222", "2020", "Hyundai", "Blanco", 35);
//    VehiculoPasajero vp3 = new VehiculoPasajero(TamanoVehiculo.MEDIANO, "CCC333", "2021", "Renault", "Negro", 30);
//    listaVehiculos.add(vp1);
//    listaVehiculos.add(vp2);
//    listaVehiculos.add(vp3);
//}
//
//// Ejercicio 3: Calcular total pasajeros
//public int calcularTotalPasajeros(Map<String, Integer> pasajerosPorPlaca) {
//    int total = 0;
//    for (Vehiculo v : listaVehiculos) {
//        if (v instanceof VehiculoPasajero) {
//            total += pasajerosPorPlaca.getOrDefault(v.placa, 0);
//        }
//    }
//    return total;
//}
