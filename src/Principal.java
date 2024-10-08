import java.util.Random;
import java.util.Scanner;

public class Principal {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Object[][] garage = new Object[8][8];
        int vehiculosCreados = 0;

        // Menu con las diferentes opciones pa que funcione la cosa
        while (true) {
            System.out.println("\n      BIENVENIDO A BAMBINI FESTARROSSA    ");
            System.out.println("--------------------------------------------------");
            System.out.println("\n· <1> Producir coches");
            System.out.println("\n· <2> Parking");
            System.out.println("\n· <3> Informacion del vehículo");
            System.out.println("\n· <0> Fin de la ejecución");
            int opcion = scanner.nextInt();

            if (opcion == 0) {
                break;
            } else if (opcion == 1) {
                if (vehiculosCreados == 64) {
                    System.out.println("El garaje esta lleno.");
                    continue;
                }

                System.out.println("¿Que tipo de vehículo deseas crear? (coche/tractor):");
                String tipoVehiculo = scanner.next();

                if (tipoVehiculo.equals("coche")) {
                    System.out.println("¿Qué tipo de coche deseas crear? (Kart/Deportivo/SUV/4x4):");
                    String tipoCoche = scanner.next();

                    String id = "Vehículo-" + (vehiculosCreados + 1);
                    String matricula = generarMatricula();
                    int potencia = generarPotencia();
                    int longitud = generarLongitud();

                    Coche coche = new Coche(id, matricula, potencia, longitud, tipoCoche);

                    System.out.println("Coche creado:");
                    System.out.println(coche);

                    System.out.println("¿Dónde deseas guardar el coche? Coloque la Fila y la Columna (Empieza desde el 0):");
                    int fila = scanner.nextInt();
                    int columna = scanner.nextInt();

                    garage[fila][columna] = coche;
                    vehiculosCreados++;
                } else if (tipoVehiculo.equals("tractor")) {
                    String id = "Tractor-" + (vehiculosCreados + 1);

                    String matricula = generarMatricula();
                    int potencia = generarPotencia();
                    int longitud = generarLongitud();

                    System.out.println("¿Qué artilugio quiere poner al tractor? (aplanador/arador/regador):");
                    String artilugio = scanner.next();

                    Tractor tractor = new Tractor(id, matricula, potencia, longitud, artilugio);

                    System.out.println("Tractor creado:");
                    System.out.println(tractor);

                    System.out.println("¿Dónde deseas guardar el tractor? Coloque la Fila y la Columna (Empieza desde el 0):");
                    int fila = scanner.nextInt();
                    int columna = scanner.nextInt();

                    garage[fila][columna] = tractor;
                    vehiculosCreados++;
                } else {
                    System.out.println("Tipo de vehículo inválido.");
                }
            } else if (opcion == 2) {
                verGaraje(garage);
            } else if (opcion == 3) {
                System.out.println("Ingresa la fila y la columna del vehículo que deseas ver:");
                int fila = scanner.nextInt();
                int columna = scanner.nextInt();

                if (garage[fila][columna] != null) {
                    if (garage[fila][columna] instanceof Coche) {
                        Coche coche = (Coche) garage[fila][columna];
                        System.out.println("Información del coche:");
                        System.out.println(coche.getInfo());

                        System.out.println("¿Deseas encender o apagar el motor? (1 para encender, 0 para apagar):");
                        int motorOption = scanner.nextInt();
                        if (motorOption == 1) {
                            coche.encenderMotor();
                            System.out.println("Motor encendido.");
                        } else if (motorOption == 0) {
                            coche.apagarMotor();
                            System.out.println("Motor apagado.");
                        } else {
                            System.out.println("Opción inválida para motor.");
                        }

                        System.out.println("¿Deseas encender o apagar las luces? (1 para encender, 0 para apagar):");
                        int lucesOption = scanner.nextInt();
                        if (lucesOption == 1) {
                            coche.encenderLuces();
                            System.out.println("Luces encendidas.");
                        } else if (lucesOption == 0) {
                            coche.apagarLuces();
                            System.out.println("Luces apagadas.");
                        } else {
                            System.out.println("Opción inválida para luces.");
                        }
                    } else if (garage[fila][columna] instanceof Tractor) {
                        Tractor tractor = (Tractor) garage[fila][columna];
                        System.out.println("Información del tractor:");
                        System.out.println(tractor.getInfo());

                        System.out.println("¿Deseas encender o apagar el motor? (1 para encender, 0 para apagar):");
                        int motorOption = scanner.nextInt();
                        if (motorOption == 1) {
                            tractor.encenderMotor();
                            System.out.println("Motor encendido.");
                        } else if (motorOption == 0) {
                            tractor.apagarMotor();
                            System.out.println("Motor apagado.");
                        } else {
                            System.out.println("Opción inválida para motor.");
                        }

                        System.out.println("¿Deseas encender o apagar las luces? (1 para encender, 0 para apagar):");
                        int lucesOption = scanner.nextInt();
                        if (lucesOption == 1) {
                            tractor.encenderLuces();
                            System.out.println("Luces encendidas.");
                        } else if (lucesOption == 0) {
                            tractor.apagarLuces();
                            System.out.println("Luces apagadas.");
                        } else {
                            System.out.println("Opción inválida para luces.");
                        }
                    }
                } else {
                    System.out.println("No hay ningún vehículo en esa posición del garaje.");
                }
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }

    public static String generarMatricula() {
        Random random = new Random();
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder matricula = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            matricula.append(letras.charAt(random.nextInt(letras.length())));
        }

        for (int i = 0; i < 4; i++) {
            matricula.append(random.nextInt(10));
        }

        return matricula.toString();
    }

    public static int generarPotencia() {
        Random random = new Random();
        int[] potencias = {50, 100, 150, 200};
        return potencias[random.nextInt(potencias.length)];
    }

    public static int generarLongitud() {
        Random random = new Random();
        int[] longitudes = {4, 5, 6, 8};
        return longitudes[random.nextInt(longitudes.length)];
    }

    public static void verGaraje(Object[][] garage) {
        for (int i = 0; i < garage.length; i++) {
            for (int j = 0; j < garage[i].length; j++) {
                if (garage[i][j] == null) {
                    System.out.print("[   ] ");
                } else {
                    System.out.print(garage[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}