package Proyecto1;

import java.util.Scanner;

/**
 *
 * @author vieri
 */
public class Main {
   
    private static void mostrarOpciones() {
        
        System.out.println("1. Ver autobuses");
        System.out.println("2. Administrar autobuses (Registrar o Dar de baja)");
        System.out.println("3. Cambiar ruta de un autobus");
        System.out.println("4. Cambiar estado de un autobus");
        System.out.println("5. Reportes financieros y operativos");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean programaActivo = true;
        
       
        System.out.println("--Proyecto de Sistemas de Gestion de Transportes--");

        while (programaActivo) {
            mostrarOpciones(); 
            int opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Ver autobuses ---");
                    Ejercicio1.main(new String[]{}); 
                    break;
                    
                case 2:
                    System.out.println("\n--- Administrar autobuses ---");
                    Ejercicio1.ejercicio2(); 
                    break;
                    
                case 3:
                    System.out.println("\n--- Cambiar ruta ---");
                    Ejercicio1.ejercicio3(); 
                    break;
                    
                case 4:
                    System.out.println("\n--- Cambiar estado ---");
                    Ejercicio1.ejercicio4(); 
                    break;
                    
                case 5:
                    System.out.println("\n---Ventas y operaciones---");
                    Ejercicio1.ejercicio5(); 
                    break;
                    
                case 6:
                    programaActivo = false;
                    System.out.println("Saliendo del programa...");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        
        sc.close();
    }
}




