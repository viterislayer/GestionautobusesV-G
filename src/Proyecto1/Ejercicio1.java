

package Proyecto1; // En esta linia nos indica que este archivo pertenese al paquete llamado proyecto1

import java.util.ArrayList; // Nos importa la clase llamada arralist  
                            // Que es como una lista dinamica donde podemos guardar elementos 

import java.util.HashMap; //Nos Importa la clase HashMap, que funciona como una especie de diccionario
import java.util.HashSet;
import java.util.List; // Tambien nos importa la interfaz List, que define el comportamiento básico de una lista 
import java.util.Map;    // Aca Importa la interfaz Map, que define cómo debería comportarse cualquier clase que guarde pares clave-valor, como HashMap.
import java.util.Scanner; // Importa la clase Scanner, que permite leer lo que el usuario escribe.
import java.util.Set;
import java.util.stream.IntStream;

/**
 *
 * @author vieri
 */
public class Ejercicio1 {
        
                        //Proyecto hecho por Guillermo oliva , Vieri López
                               //(Sistema de gestion de transportes)
    
    public static void main() {
        System.out.println("\nOpciones disponibles:");
        System.out.println("1. Ver autobuses");
        System.out.println("2. Administrar autobuses (Registrar o Dar de baja)");
        System.out.println("3. Cambiar ruta de un autobus");
        System.out.println("4. Cambiar estado de un autobus");
        System.out.println("5. Reportes financieros y operativos )");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opcion: ");
    }
 

    public static void main(String[] args) {      // Método principal que nos ejecuta el programa
        Scanner sc = new Scanner(System.in);

        String placa1 = "P123ABC";    // Identificacion de el  autobus 
        String modelo1 = "Mercedes";   // Identifica la marca 
        int capacidad1 = 50;        // Nos marca el limite de pasajeros 
        String estado1 = "Activo";    // Estado operativo 
        int ruta1 = 1;           //La ruta asignada 
        
         //Asi sucesivamente con los demas
                                        
        String placa2 = "M456XYZ";
        String modelo2 = "Volvo";
        int capacidad2 = 45;
        String estado2 = "En mantenimiento";
        int ruta2 = 2;

        String placa3 = "T789GUA";
        String modelo3 = "Toyota";
        int capacidad3 = 60;
        String estado3 = "Activo";
        int ruta3 = 3;

        
         // Lista que nos guarda los autobuses nuevos que se vayan registrando
        ArrayList<String> nuevosAutobuses = new ArrayList<>();
        
        // Esta variable nos controla si el programa debe seguir ejecutándose...
        boolean programaActivo = true;

        
        // En este ciclo principal del programa se repite mientras el programa este activo y sea verdadero
        while (programaActivo) {
        while (programaActivo) {
            main(); 
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                        // Muestra los autobuses registrados
                    System.out.println("\n--- Autobuses Registrados ---");
                    
                    if (placa1 != null) {   // Nos muestra si el primer autobús está registrado, lo muestra
                        System.out.println("Autobus 1: Placa: " + placa1 + " | Modelo: " + modelo1 + " | Capacidad: " + capacidad1 + " | Estado: " + estado1 + " | Ruta: " + ruta1);
                    }
                    if (placa2 != null) {
                        System.out.println("Autobus 2: Placa: " + placa2 + " | Modelo: " + modelo2 + " | Capacidad: " + capacidad2 + " | Estado: " + estado2 + " | Ruta: " + ruta2);
                    }
                    if (placa3 != null) {
                        System.out.println("Autobus 3: Placa: " + placa3 + " | Modelo: " + modelo3 + " | Capacidad: " + capacidad3 + " | Estado: " + estado3 + " | Ruta: " + ruta3);
                    }
                    for (String bus : nuevosAutobuses) {
                        System.out.println("Nuevo Autobus: " + bus);
                    }
                    break;

                case 2:
                    // En esta opción nos ayuda a registrar o dar de baja un autobús
                    System.out.println("\n=Opciones de registrar o dar de baja=");
                    System.out.println("1. Registrar un nuevo autobus");
                    System.out.println("2. Dar de baja un autobus");
                    System.out.print("Seleccione una opcion: ");
                    int adminOpcion = sc.nextInt();//Nos sirve para leer un número entero del usuario y luego limpiar el buffer del scanner
                    sc.nextLine();

                    switch (adminOpcion) {
                        case 1:
                            System.out.print("Ingrese la placa del nuevo autobus: ");
                            String nuevaPlaca = sc.nextLine();
                            System.out.print("Ingrese el modelo del nuevo autobus: ");
                            String nuevoModelo = sc.nextLine();
                            System.out.print("Ingrese la capacidad del nuevo autobus: ");
                            int nuevaCapacidad = sc.nextInt();
                            sc.nextLine();//Después de int nuevaCapacidad = sc.nextInt();, es correcto y necesario usar sc.nextLine();.
                            //Esto evita que nuevoEstado = sc.nextLine(); lea accidentalmente una cadena vacía.
                            System.out.print("Ingrese el estado del nuevo autobus (Activo, En mantenimiento, Reparacion): ");
                            String nuevoEstado = sc.nextLine();
                            System.out.print("Ingrese la ruta asignada al nuevo autobus (1, 2 o 3): ");
                            int nuevaRuta = sc.nextInt();

                            String info = "Placa: " + nuevaPlaca + " | Modelo: " + nuevoModelo + " | Capacidad: " + nuevaCapacidad + " | Estado: " + nuevoEstado + " | Ruta: " + nuevaRuta;
                            nuevosAutobuses.add(info);

                            System.out.println("\nNuevo autobus registrado exitosamente:");
                            System.out.println(info);
                            break;

                        case 2:
                            // Opción para dar de baja un autobus
                            System.out.println("\n--- Autobuses Disponibles para Baja ---");
                            if (placa1 != null) System.out.println("1. " + placa1);
                            if (placa2 != null) System.out.println("2. " + placa2);
                            if (placa3 != null) System.out.println("3. " + placa3);
                            System.out.print("Seleccione el numero del autobus a dar de baja: ");
                            int baja = sc.nextInt();
                            sc.nextLine();

                             // Dependiendo de la opción, eliminamos el autobús de los registrados
                                switch (baja) {
                                case 1:
                                    placa1 = null;
                                    break; // es un bloque switch muy básico, y lo que hace es ejecutar una 
                                    // acción dependiendo del valor de la variable baja.
                                case 2:
                                    placa2 = null;
                                    break;
                                case 3:
                                    placa3 = null;
                                    break;
                                default:
                                    System.out.println("Opcion invalida.");
                            }
                            break;

                        default:
                            System.out.println("Opcion no valida.");
                    }
                    break;

                case 3: 
                    
                    System.out.println("\n--- Cambiar la ruta del autobus ---");
                    if (placa1 != null) System.out.println("1. " + placa1);
                    if (placa2 != null) System.out.println("2. " + placa2);
                    if (placa3 != null) System.out.println("3. " + placa3);// Muestra la lista de autobuses disponibles.
                    // Solo se muestran si no han sido dados de baja (es decir, si su placa no es null).
                    System.out.print("Seleccione el numero del autobus para cambiar su ruta: ");
                    int seleccionRuta = sc.nextInt();
                    sc.nextLine();// Limpia el buffer
                     // El usuario selecciona qué autobús desea modificar, escribiendo 1, 2 o 3.

       
                    System.out.print("Ingrese la nueva ruta (1, 2 o 3): ");
                    int nuevaRutaAsignada = sc.nextInt();
                    sc.nextLine();

                    switch (seleccionRuta)   { // Este segundo switch determina a qué autobús aplicar el cambio:
                        case 1:// Si el usuario eligió el autobús 1, se actualiza ruta1, pero solo si placa1 no es null 
                            //(es decir, si el autobús no fue dado de baja).Al igual que caso 1 y 2.
                            if (placa1 != null) ruta1 = nuevaRutaAsignada;
                            break;
                        case 2:
                            if (placa2 != null) ruta2 = nuevaRutaAsignada;
                            break;
                        case 3:
                            if (placa3 != null) ruta3 = nuevaRutaAsignada;
                            break;
                        default:
                            System.out.println("Opcion invalida.");
                    } // Si el número ingresado no es 1, 2 o 3, se muestra "Opción inválida".
                    System.out.println("Ruta registrada con exito Gracias..");
                    break;

                case 4: // Este case nos indica que el autobus cambiara de estado
                    System.out.println("\n--- Cambiar estado de autobus ---");
                    if (placa1 != null) System.out.println("1. " + placa1 + " | Estado actual: " + estado1);
                    if (placa2 != null) System.out.println("2. " + placa2 + " | Estado actual: " + estado2);
                    if (placa3 != null) System.out.println("3. " + placa3 + " | Estado actual: " + estado3);
                    System.out.print("Seleccione el numero del autobus para cambiar su estado: ");
                    int seleccionEstado = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el nuevo estado (Activo, En mantenimiento, Reparacion): ");
                    String nuevoEstadoBus = sc.nextLine();

                    switch (seleccionEstado) {
                        case 1:
                            if (placa1 != null) estado1 = nuevoEstadoBus;
                            break;
                        case 2:
                            if (placa2 != null) estado2 = nuevoEstadoBus;
                            break;
                        case 3:
                            if (placa3 != null) estado3 = nuevoEstadoBus;
                            break;
                        default:
                            System.out.println("Opcion invalida.");
                    }
                    System.out.println("Estado actualizado correctamente.");
                    break;

                case 5:
                    programaActivo = false; // Cambia el valor de programaActivo a false
                    System.out.println("Terminando gracias por usar el programa...");
                    break;

                default: // Para que sirve el default?
                    // Si el usuario ingresa un número que no corresponde a ninguno de los case definidos, se ejecuta este bloque.
                   // Muestra un mensaje de error y deja que el programa siga corriendo (porque no cambia programaActivo).
                    System.out.println("Opcion no valida, intente de nuevo.");
            }
        }
    }
}
    public static void ejercicio2() {
        // Esta clase nos sirve para guardar los dato de cada ruta del cliente.... 
        class Ruta {
            int id;              // Es la variable que identifica la ruta
            String destino;      // Identifica el lugar o destino donde va el cliente 
            String origen;       // El lugar de donde sale
            String horarios;     // Registra las horas en que sale el cliente ("08:00 AM, 10:00 AM")
            int frecuencia;      // Registra en cada cuántos minutos sale un bus
            
            // Aquí es donde se creamos las rutas
            Ruta(int idRuta, String destinoRuta, String origenRuta, String horariosRuta, int frecuenciaRuta) {
                id = idRuta;
                destino = destinoRuta;
                origen = origenRuta;
                horarios = horariosRuta;
                frecuencia = frecuenciaRuta;
            }
        }

        // ArrayList es donde nosotros guardamos todas las rutas...
        List<Ruta> rutas = new ArrayList<>();

        // Contador para darle un número diferente a cada ruta...
        int contadorId = 1;

        // Agregamos las rutas 
        rutas.add(new Ruta(contadorId++, "Guastatoya", "Ciudad de Guatemala", "05:00 AM, 11:00 AM, 04:00 PM", 90));
        rutas.add(new Ruta(contadorId++, "Antigua Guatemala", "Ciudad de Guatemala", "08:00 AM, 10:00 AM, 12:00 PM", 30));
        rutas.add(new Ruta(contadorId++, "Escuintla", "Ciudad de Guatemala", "09:00 AM, 11:00 AM, 01:00 PM", 60));
        rutas.add(new Ruta(contadorId++, "Quetzaltenango", "Ciudad de Guatemala", "06:00 AM, 09:00 AM, 12:00 PM", 120));
        rutas.add(new Ruta(contadorId++, "Petén", "Ciudad de Guatemala", "07:00 AM, 03:00 PM", 180));
        rutas.add(new Ruta(contadorId++, "Puerto San José", "Ciudad de Guatemala", "06:30 AM, 02:00 PM", 60));

        // Scanner para leer lo que escribe el usuario
        Scanner sc = new Scanner(System.in);

        while (true) {
            
            // Menú principal
            System.out.println("\n==Control de Rutas==");
            System.out.println("1. Registrar nueva ruta");
            System.out.println("2. Ver rutas activas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); 

            if (opcion == 1) {
                
                // Aca nos pregunta los datos para crear una ruta nueva
                System.out.print("Ingrese el destino: ");
                String destino = sc.nextLine();          // Nos Guarda el nombre ingresado

                System.out.print("Punto de partida: ");
                String origen = sc.nextLine();
                System.out.print("Ingrese los horarios (ejemplo: 08:00 AM, 10:00 AM): ");
                String horarios = sc.nextLine();
                System.out.print("Ingrese la frecuencia en minutos: ");
                int frecuencia = sc.nextInt();

                // Nos guarda la nueva ruta 
                rutas.add(new Ruta(contadorId++, destino, origen, horarios, frecuencia));
                System.out.println("Ruta registrada con éxito.");
            } 
            
            else if (opcion == 2) {
                // Nos muestra todas las rutas guardadas
                System.out.println("\nRutas activas:");
                for (Ruta ruta : rutas) {
                    System.out.println("ID: " + ruta.id + " | Destino: " + ruta.destino + " | Origen: " + ruta.origen +
                            " | Horarios: " + ruta.horarios + " | Frecuencia: " + ruta.frecuencia + " minutos.");
                }
            } 
            else if (opcion == 3) {
                // Salimos del programa si lo deseamos..
                System.out.println("Hasta pronto");
                break;
            } 
            else {
                System.out.println("Esa opcion no existe, por favor elige entre 1 y 3.");
            }
        }
    }

    public static void ejercicio3() {
        Scanner sc = new Scanner(System.in);

        // Datos de los autobuses
        String[] placas = {"ABC123", "XYZ789", "DEF456", "GHI321", "JKL654", "MNO987", "PQR246", "STU135", "VWX864", "YZA753",
                           "BCD159", "EFG753", "HIJ852", "KLM951", "NOP369", "QRS147", "TUV258", "WXY369", "ZAB741", "CDE963"};
        // Las placas se almacenan en las matrículas de los autobuses

        String[] modelos = {"Mercedes", "Volvo", "Scania", "Toyota", "Hyundai", "Daewoo", "Hino", "MAN", "Iveco", "Renault",
                            "Mercedes", "Volvo", "Scania", "Toyota", "Hyundai", "Daewoo", "Hino", "MAN", "Iveco", "Renault"};
        // Los modelos se guardan porque para cada placa hay un modelo correspondiente.

        String[] estados = {"Activo", "En mantenimiento", "Inactivo", "Activo", "Inactivo", "Activo", "En mantenimiento", "Activo", "Activo", "Inactivo",
                            "Activo", "En mantenimiento", "Inactivo", "Activo", "Inactivo", "Activo", "En mantenimiento", "Activo", "Activo", "Inactivo"};
        // "Los estados contienen el estado de cada autobus.

        // Rutas
        String[] rutas = {"Antigua", "Escuintla", "Xela", "Mixco", "Villa Nueva", "Chimaltenango", "Amatitlan", "San Lucas", "Jalapa", "Jutiapa",
                          "Santa Lucia", "Mazatenango", "Coban", "Huehuetenango", "Chiquimula", "Solola", "Totonicapan", "Zacapa", "Retalhuleu", "San Marcos"};
        // Las rutas almacenan los nombres de las rutas de los autobuses.

        String[] horarios = {"06:00 AM", "07:30 AM", "09:00 AM", "10:30 AM", "12:00 PM", "01:30 PM", "03:00 PM", "04:30 PM", "06:00 PM", "07:30 PM",
                             "08:00 AM", "09:30 AM", "11:00 AM", "12:30 PM", "02:00 PM", "03:30 PM", "05:00 PM", "06:30 PM", "08:00 PM", "09:30 PM"};
        // Los horarios guardan de salida de cada ruta.

        double[] distancias = {45.5, 60.0, 200.0, 15.0, 20.0, 85.0, 25.5, 30.0, 140.0, 155.0,
                               100.0, 110.5, 180.0, 250.0, 130.0, 95.0, 105.5, 175.0, 165.0, 240.0};
        // Las distancias correspondientes de cada ruta.

        //Conductores 
        String[] nombresConductores = {"Carlos", "Luis", "Marta", "Jose", "Ana", "Pedro"};
        // Contiene los nombres de los conductores disponibles.

        String[] dpisConductores = {"1234567890101", "2345678901212", "3456789012323", "4567890123434", "5678901234545", "6789012345656"};
        //  Almacena los números de DPI (identificación) de cada conductor.

        String[] licencias = {"Tipo A", "Tipo B", "Tipo C", "Tipo A", "Tipo B", "Tipo C"};
        // Guarda el tipo de licencia que tiene cada conductor.

        // Nos sirve para asignar conductores a autobuses
        String[] conductoresAsignados = new String[placas.length];
        
        // Conductores 
        while (true) {                                  // El bucle principal nos mantiene el menú activo.
            
            System.out.println("\n=== GESTION DE CONDUCTORES ===");
            System.out.println("1. Registrar conductor");
            System.out.println("2. Actualizar conductor");
            System.out.println("3. Eliminar conductor");
            System.out.println("4. Asignar conductor a autobus");
            System.out.println("5. Ver conductores asignados");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opcion: ");
            int opcion = sc.nextInt(); 
            sc.nextLine(); 

            switch (opcion) {
                case 1: // Registra el conductor
                    System.out.print("Introdusca el nombre del conductor: ");
                    String nombre = sc.nextLine(); 
                    System.out.print("Introdusca el DPI del conductor: ");
                    String dpi = sc.nextLine(); 
                    System.out.print("Introdusca el tipo de licencia: ");
                    String licencia = sc.nextLine(); 
                    System.out.println("Conductor registrado: " + nombre + ", DPI: " + dpi + ", Licencia: " + licencia);
                    break;

                case 2:
                    for (int i = 0; i < nombresConductores.length; i++) {
                        if (nombresConductores[i] != null) {
                            System.out.println((i + 1) + ". Nombre: " + nombresConductores[i] + ", DPI: " + dpisConductores[i]);
                        }
                    }
                    System.out.print("Introdusca el DPI del conductor a actualizar: ");
                    String dpiActualizar = sc.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < dpisConductores.length; i++) {
                        if (dpiActualizar.equals(dpisConductores[i])) {
                            encontrado = true;
                            System.out.print("Nuevo nombre: ");
                            nombresConductores[i] = sc.nextLine(); 
                            System.out.print("Nuevo tipo de licencia: ");
                            licencias[i] = sc.nextLine(); 
                            System.out.println("Conductor actualizado.");
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("=Conductor no encontrado=");
                    }
                    break;

                case 3: // Eliminar un conductor.
                    for (int i = 0; i < nombresConductores.length; i++) {
                        if (nombresConductores[i] != null) {
                            System.out.println((i + 1) + ". Nombre: " + nombresConductores[i] + ", DPI: " + dpisConductores[i]);
                        }
                    }
                    System.out.print("Introduce el DPI del conductor a eliminar: ");
                    String dpiEliminar = sc.nextLine(); // Captura el DPI del conductor a eliminar.
                    boolean eliminado = false;
                    for (int i = 0; i < dpisConductores.length; i++) {
                        if (dpiEliminar.equals(dpisConductores[i])) {
                            eliminado = true;
                            nombresConductores[i] = null; // Nos ayuda a eliminar el nombre del conductor.
                            dpisConductores[i] = null; // Tambien elimina el DPI del conductor.
                            licencias[i] = null; // Y elimina el tipo de licencia 
                            System.out.println("Conductor eliminado.");
                            break;
                        }
                    }
                    if (!eliminado) {
                        System.out.println("=Conductor no encontrado=");
                    }
                    break;

                case 4: // Nos Asigna un conductor de un autobús.
                    for (int i = 0; i < 6; i++) {
                        System.out.println((i + 1) + ". Placa: " + placas[i]);
                    }
                    System.out.print("Selecciona un autobus (1-6): ");
                    int autobusSeleccionado = sc.nextInt() - 1; 
                    sc.nextLine();

                    for (int i = 0; i < 6; i++) {
                        if (nombresConductores[i] != null) {
                            System.out.println((i + 1) + ". Nombre: " + nombresConductores[i] + ", DPI: " + dpisConductores[i]);
                        }
                    }
                    System.out.print("Selecciona un conductor (1-6): ");
                    int conductorSeleccionado = sc.nextInt() - 1; 
                    sc.nextLine();

                    conductoresAsignados[autobusSeleccionado] = nombresConductores[conductorSeleccionado]; 
                    System.out.println("Conductor " + nombresConductores[conductorSeleccionado] + " asignado al autobus con placa " + placas[autobusSeleccionado]);
                    break;

                case 5: // Ver los conductores asignados a los autobuses.
                    System.out.println("\n=Conductores asignados a autobuses=");
                    System.out.println("1. Ver todos");
                    System.out.println("2. Ver solo asignados");
                    System.out.println("3. Buscar por placa");
                    System.out.print("Selecciona una opcion: ");
                    int subopcion = sc.nextInt(); 
                    sc.nextLine();

                    switch (subopcion) {
                        case 1:
                            System.out.println("\n--Lista e todos los conductores de autobuses--");
                            for (int i = 0; i < 6; i++) {
                                System.out.println((i + 1) + ". Placa: " + placas[i] + " | Conductor   : " +
                                        (conductoresAsignados[i] != null ? conductoresAsignados[i] : "Asignado"));
                            }
                            break;
                        case 2:
                            System.out.println("\n--Autobuses con conductor asignado--");
                            boolean hayAsignados = false;
                            for (int i = 0; i < 6; i++) {
                                if (conductoresAsignados[i] != null) {
                                    hayAsignados = true;
                                    System.out.println((i + 1) + ". Placa: " + placas[i] + " | Conductor: " + conductoresAsignados[i]);
                                }
                            }
                            if (!hayAsignados) {
                                System.out.println("No hay conductores asignados actualmente.");
                            }
                            break;
                        case 3:
                            System.out.print("Ingresa la placa del autobus: ");
                            String placaBuscar = sc.nextLine(); // Captura la placa para buscar asignación.
                            boolean encontradoPlaca = false;
                            // Esta variable te permite saber más adelante si se encontró la placa o no, 
                            // para poder mostrar un mensaje si no está.
                            for (int i = 0; i < 6; i++) {
                                if (placas[i].equalsIgnoreCase(placaBuscar)) {
                                    // Se recorre el arreglo placas[] (que debería tener 6 elementos) 
                                    // y se compara cada una con la placa ingresada, sin importar mayúsculas o minúsculas (equalsIgnoreCase).
                                    encontradoPlaca = true;
                                    String conductor = conductoresAsignados[i] != null ? conductoresAsignados[i] : "Asignados";
                                    System.out.println("Autobus " + placas[i] + " - Conductor: " + conductor);
                                    break;
                                }
                            }
                            if (!encontradoPlaca) {
                                System.out.println("Placa no encontrada.");
                            }
                            break;
                        default:
                            System.out.println("Opcion no valida.");
                    }
                    break;

                case 6: 
                    System.out.println("Hasta luego");
                    return; // Sale del bucle y termina el método.

                default: 
                    System.out.println("Opcion invalida intententelo de nuevo.");
            }
        }
    }
       
    public static void ejercicio4() {
        class Pasajero {
            String nombre;            //Nos guarda el nombre del pasajero, por ejemplo "Luis Perez"
            String documentoID;       // similarmente en  el DPI o documento de identificación 

            
            Pasajero(String nombre, String documentoID) {
                this.nombre = nombre;       // Nos asigna el nombre que se ingresa 
                this.documentoID = documentoID; // Asigna el documento 
            }
        }

        class Ruta {
            String destino;           // Indica a qué lugar va la ruta, por ejemplo "Antigua"
            String horario;           // Representa la hora de salida, como AM o PM
            int capacidadTotal;       // Nos indica el máximo de personas que pueden ir en esa ruta
            int boletosVendidos = 0;  // Contador de boletos vendidos, iniciando en cero

            Ruta(String destino, String horario, int capacidadTotal) {
                this.destino = destino;              
                this.horario = horario;             
                this.capacidadTotal = capacidadTotal; 
            }

            boolean hayBoletosDisponibles() {
                String[] horaYAmPm = horario.split(" "); 
                String[] horaParts = horaYAmPm[0].split(":"); 
                int hora = Integer.parseInt(horaParts[0]);   
                String amPm = horaYAmPm[1];                   

                // Si son las 5 PM o más tarde, no se venden boletos
                if (amPm.equals("PM") && hora >= 5) {
                    return false;
                }

                // Si ya se vendieron 30 boletos, no se permite más
                if (boletosVendidos >= 30) {
                    return false;
                }

                
                return boletosVendidos < capacidadTotal;
            }

            boolean venderBoleto(Pasajero pasajero) {
                if (hayBoletosDisponibles()) {
                    boletosVendidos++; // El número de boletos vendidos
                    System.out.println("Boleto vendido a " + pasajero.nombre + " para " + destino + " a las " + horario);
                    System.out.println("Su boleto ha sido aprobado exitosamente.");
                    return true;
                }
                System.out.println("Cupo lleno para la ruta a " + destino + " a las " + horario);
                return false;
            }
        }

        Scanner scanner = new Scanner(System.in); // Nos sirve para leer datos desde el teclado

        System.out.print("Ingrese el nombre del pasajero: ");
        String nombre = scanner.nextLine();          // Nos Guarda el nombre ingresado

        System.out.print("Ingrese el documento DPI del pasajero: ");
        String documentoID = scanner.nextLine();     

        Pasajero pasajero = new Pasajero(nombre, documentoID); // Nos crea un objeto pasajero con los datos

        System.out.print("Ingrese el destino de la ruta: ");
        String destino = scanner.nextLine();         // Tambien nos guarda el destino

        System.out.print("Ingrese el horario de la ruta: ");
        String hora = scanner.nextLine();            
        System.out.print("Ingrese AM o PM: ");
        String amPm = scanner.nextLine().toUpperCase(); // Guarda si es AM o PM

        String horario = hora + " " + amPm;          // Une hora y AM.PM para formar 3:00 PM

        System.out.print("Ingrese la capacidad total de la ruta: ");
        int capacidadTotal = Integer.parseInt(scanner.nextLine()); 

        Ruta ruta = new Ruta(destino, horario, capacidadTotal); // Crea una ruta con los datos dados

        if (ruta.hayBoletosDisponibles()) {
            boolean resultado = ruta.venderBoleto(pasajero); 
            if (resultado) {
                System.out.println("Venta aprobada.");      
            } else {
                System.out.println("Venta rechazada.");     
            }
        } else {
            System.out.println("Boleto rechazado: Cupo lleno para la ruta a " + destino + " a las " + horario);
        }
    }
   
    
public static void ejercicio5() {
    // Clases originales 
    class Venta {
        String idBus;
        String ruta;
        String fecha;
        int boletosVendidos;
        double precioBoleto;

        Venta(String idBusParam, String rutaParam, String fechaParam, int boletosParam, double precioParam) {
            idBus = idBusParam;
            ruta = rutaParam;
            fecha = fechaParam;
            boletosVendidos = boletosParam;
            precioBoleto = precioParam;
        }
    }

    class Conductor {
        String idConductor; 
        String nombreConductor;
        String idBus; 
        String fechaAsignacion; 

        Conductor(String idConductorParam, String nombreConductorParam, String idBusParam, String fechaAsignacionParam) {
            idConductor = idConductorParam;
            nombreConductor = nombreConductorParam;
            idBus = idBusParam;
            fechaAsignacion = fechaAsignacionParam;
        }
    }

    Scanner sc = new Scanner(System.in);

    // Datos ajustados a buses numerados (1-8)
    List<Venta> ventas = new ArrayList<>();
    ventas.add(new Venta("1", "Guate-Zacapa", "2023-01-10", 15, 25.0));
    ventas.add(new Venta("2", "Guate-Peten", "2023-02-15", 20, 30.5));
    ventas.add(new Venta("3", "Guate-Huehue", "2023-03-20", 18, 20.0));
    ventas.add(new Venta("4", "Guate-Jalapa", "2023-04-25", 22, 15.75));
    ventas.add(new Venta("5", "Guate-Chimaltenango", "2023-05-05", 30, 18.0));
    ventas.add(new Venta("6", "Guate-Izabal", "2023-06-12", 12, 40.0));
    ventas.add(new Venta("7", "Guate-Solola", "2023-07-18", 25, 22.5));
    ventas.add(new Venta("8", "Guate-Retalhuleu", "2023-08-30", 17, 35.0));

    List<Conductor> conductores = new ArrayList<>();
    conductores.add(new Conductor("C001", "Juan Perez", "1", "2023-01-05"));
    conductores.add(new Conductor("C002", "Maria Garcia", "2", "2023-02-10"));
    conductores.add(new Conductor("C003", "Carlos Lopez", "3", "2023-03-15"));
    conductores.add(new Conductor("C004", "Ana Martinez", "4", "2023-04-20"));
    conductores.add(new Conductor("C005", "Luis Rodriguez", "5", "2023-05-01"));
    conductores.add(new Conductor("C006", "Sofia Hernandez", "6", "2023-06-05"));
    conductores.add(new Conductor("C007", "Pedro Gonzalez", "7", "2023-07-10"));
    conductores.add(new Conductor("C008", "Lucia Diaz", "8", "2023-08-15"));

    // Menu principal
    while (true) {
       
        System.out.println("1. Lista de todos los conductores");
        System.out.println("2. Reporte de ventas");
        System.out.println("3. Conductores por bus");
        System.out.println("4. Salir");
        System.out.print("Elija una opcion: ");
        int opcion = Integer.parseInt(sc.nextLine());

        if (opcion == 1) {
            System.out.println("\n---Lista completa---");
            conductores.forEach(c -> System.out.println(
                "ID: " + c.idConductor + " | Nombre: " + c.nombreConductor + 
                " | Bus: " + c.idBus + " | Fecha asignacion: " + c.fechaAsignacion
            ));
        } else if (opcion == 2) {
            // Reportes de ventas c
            System.out.println("\n---Reporte de ventas---");
            System.out.println("A partir del 1/02/2023 encontramos registros ");
            System.out.print("Fecha inicial (Dia/Mes/A/o): ");
            String inicio = sc.nextLine();
            System.out.print("Fecha final (Dia/Mes/A/o): ");
            String fin = sc.nextLine();

            double totalGanancias = 0;
            int totalBoletos = 0;
            Map<String, Double> gananciasPorRuta = new HashMap<>();
            Map<String, Integer> boletosPorRuta = new HashMap<>();

            System.out.println("\n---Detalles de ventas---");
            for (Venta v : ventas) {
                if (v.fecha.compareTo(inicio) >= 0 && v.fecha.compareTo(fin) <= 0) {
                    double ganancia = v.boletosVendidos * v.precioBoleto;
                    totalGanancias += ganancia;
                    totalBoletos += v.boletosVendidos;
                    
                    // Acumular por ruta
                    gananciasPorRuta.merge(v.ruta, ganancia, Double::sum);
                    boletosPorRuta.merge(v.ruta, v.boletosVendidos, Integer::sum);
                    
                    System.out.println(
                        v.fecha + " | Bus " + v.idBus + " (" + v.ruta + "): " +
                        v.boletosVendidos + " boletos | Q" + ganancia
                    );
                }
            }

            System.out.println("\n---Totales por ruta---");
            gananciasPorRuta.forEach((ruta, ganancia) -> {
                System.out.println(
                    ruta + ": " + boletosPorRuta.get(ruta) + 
                    " boletos | Q" + ganancia
                );
            });

            System.out.println("\n---Total general---");
            System.out.println("Boletos vendidos: " + totalBoletos);
            System.out.println("=Ganancias totales=: Q" + totalGanancias);

        } else if (opcion == 3) {
            
            System.out.println("\n=Conductores por Bus=");
            
            
            
            for (int i = 1; i <= 8; i++) {
                System.out.println("Bus " + i);
            }
            
            System.out.print("Ingrese el numero de bus a desear (1-8): ");
            String idBus = sc.nextLine();
            
            
            boolean busExiste = ventas.stream().anyMatch(v -> v.idBus.equals(idBus));
            if (!busExiste) {
                System.out.println("Error: Bus no encontrado");
                continue;
            }
            
           
            System.out.println("\n===Datos del Bus=== " + idBus );
            // Muestra el encabezado con el ID del bus que se está consultando.
            ventas.stream()
            // Convierte la lista ventas (probablemente un ArrayList<Venta>) en un Stream,
            // que te permite trabajar con una secuencia de elementos de forma funcional.
                .filter(v -> v.idBus.equals(idBus))
                    // Aplica un filtro para quedarse solo con las ventas del bus cuyo ID coincide con idBus.
                .findFirst()
                    // Busca el primer elemento que cumpla con el filtro. Devuelve un Optional<Venta>.
                .ifPresent(v -> System.out.println(
                    "Ruta: " + v.ruta + "\n" +
                    "Ultima venta: " + v.fecha + "\n" +
                    "Boletos vendidos: " + v.boletosVendidos + "\n" +
                    "Precio boleto: Q" + v.precioBoleto
                ));
            
            
            System.out.println("\n==Conductor asignado==");
            conductores.stream()
                .filter(c -> c.idBus.equals(idBus))
                .findFirst()
                .ifPresentOrElse(
                    c -> System.out.println(
                        "Nombre: " + c.nombreConductor + "\n" +
                        "ID: " + c.idConductor + "\n" +
                        "Fecha asignacion: " + c.fechaAsignacion
                    ),
                    () -> System.out.println("Sin conductor asignado")
                );
            
            
            System.out.println("\n---Conductores Disponibles---");
            conductores.stream()
                .filter(c -> !c.idBus.equals(idBus))
                .forEach(c -> System.out.println(
                    "Nombre: " + c.nombreConductor + 
                    " | Bus actual: " + c.idBus +
                    " | ID: " + c.idConductor
                ));
            
        } else if (opcion == 4) {
            System.out.println("Saliendo del sistema Gracias...");
            break;
        } else {
            System.out.println("Opcion invalida. Intente de nuevo.");
        }
      }
  }
       }