import javax.swing.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.swing.JOptionPane.showInputDialog;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crear una instancia del taller
        Gimnasio gimnasio = new Gimnasio("Gimnasio MJ", 2251, "Via 4 Km 35 Izq");

        //Menu
        /*int opcion;
        do {
            String menu = "Opciones del Menú:\n" + " 1. Registrar Cliente \n" + "2. Registrar entrenador \n" + "0. Salir";
            opcion = Integer.parseInt(showInputDialog(null, menu));
            switch (opcion) {
                case 1:
                    //Registrar Cliente
                    String nombreSocio = showInputDialog(null, "Ingrese su nombre");
                    int cedulaSocio = Integer.parseInt(showInputDialog(null, "Ingrese su cedula"));
                    String resultadoSocio = gimnasio.registrarSocio(nombreSocio, cedulaSocio);
                    JOptionPane.showMessageDialog(null, resultadoSocio);
                    break;
                case 2:
                    //Registrar Entrenador
                    String nombreEntrenador = showInputDialog(null, "Ingrese su nombre entrenador");
                    String claseImpartida = showInputDialog(null, "Ingrese la clase que va a impartir");
                    int cedulaEntrenador = Integer.parseInt(showInputDialog(null, "Ingrese su cedula"));
                    String resultadoEntrenador = gimnasio.registrarEntrenadores(nombreEntrenador, claseImpartida, cedulaEntrenador);
                    JOptionPane.showMessageDialog(null, resultadoEntrenador);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");

            }
        } while (opcion != 0);
        System.out.println("Socios registrados: " + gimnasio.getListSocios().size());*/

        System.out.println(gimnasio.registrarSocio("Maria", 1004));

        System.out.println(gimnasio.registrarMembresia(1004,"Premium","05/02/2026","07/03/2026",80000));
        System.out.println(gimnasio.sociosVencidos());


    }




}