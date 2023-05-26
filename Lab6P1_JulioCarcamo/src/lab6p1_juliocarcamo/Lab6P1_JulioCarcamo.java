/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_juliocarcamo;

import java.util.Scanner;
import java.util.Random;

public class Lab6P1_JulioCarcamo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean seguir = true;
        while (seguir) {
            System.out.println("1. Cuantos primos tienes?");
            System.out.println("2. Frecuencia de letras");
            System.out.println("3. Salir");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    // Uso de los primos
                    System.out.print("Ingrese el tamaño del arreglo a generar: ");
                    int size = sc.nextInt();

                    System.out.print("Ingrese el límite inferior: ");
                    int lowerLimit = sc.nextInt();

                    System.out.print("Ingrese el límite superior: ");
                    int upperLimit = sc.nextInt();

                    int[] array = generateArray(size, lowerLimit, upperLimit);
                    int[] primeCounts = countPrimes(array);

                    System.out.print("Arreglo generado: ");
                    printArray(array);

                    System.out.print("No. divisores primos: ");
                    printArray(primeCounts);
                    break;

                case 2:
                    // Lógica para el caso 2 - Frecuencia de letras
                    System.out.print("Ingrese una palabra: ");
                    String palabra = sc.next().toLowerCase();

                    if (!validarPalabra(palabra)) {
                        System.out.println("La palabra ingresada contiene caracteres inválidos. Intente nuevamente.");
                        break;
                    }

                    int[] frecuencias = extraerFrecuencias(palabra);

                    System.out.println("Frecuencias para la palabra: " + palabra);
                    printFrecuencias(frecuencias);
                    break;

                case 3:
                    seguir = false;
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }

            public static int[] generateArray(int size, int lowerLimit, int upperLimit) {
                if (upperLimit <= lowerLimit) {
                    throw new IllegalArgumentException("El límite superior debe ser mayor que el límite inferior.");
                }

                Random random = new Random();
                int[] array = new int[size];
                for (int i = 0; i < size; i++) {
                    array[i] = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                }
                return array;
            }

            public static boolean esPrimo(int number) {
                if (number < 2) {
                    return false;
                }

                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        return false;
                    }
                }
                return true;
            }

            public static int countPrimes(int number) {
                int count = 0;
                for (int i = 2; i <= number; i++) {
                    if (esPrimo(i) && number % i == 0) {
                        count++;
                    }
                }
                return count;
            }

            public static int[] countPrimes(int[] array) {
                int[] primeCounts = new int[array.length];
                for (int i = 0; i < array.length; i++) {
                    primeCounts[i] = countPrimes(array[i]);
                }
                return primeCounts;
            }

            public static void printArray(int[] array) {
                System.out.print("[");
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i]);
                    if (i != array.length - 1) {
                        System.out.print("][");
                    }
                }
                System.out.println("]");
            }

            public static boolean validarPalabra(String palabra) {
                for (char c : palabra.toCharArray()) {
                    if (!((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))) {
                        return false;
                    }
                }
                return true;
            }

            public static int[] extraerFrecuencias(String palabra) {
                int[] frecuencias = new int[36];
                for (char c : palabra.toCharArray()) {
                    if (c >= 'a' && c <= 'z') {
                        frecuencias[c - 'a']++;
                    } else if (c >= '0' && c <= '9') {
                        frecuencias[c - '0' + 26]++;
                    }
                }
                return frecuencias;
            }

            public static void printFrecuencias(int[] frecuencias) {
                System.out.print("[");
                for (int i = 0; i < frecuencias.length; i++) {
                    System.out.print(frecuencias[i]);
                    if (i != frecuencias.length - 1) {
                        System.out.print("][");
                    }
                }
                System.out.println("]");

                System.out.print("[");
                for (int i = 0; i < 26; i++) {
                    System.out.print((char) ('a' + i));
                    if (i != 25) {
                        System.out.print("][");
                    }
                }
                for (int i = 0; i < 10; i++) {
                    System.out.print(i);
                    if (i != 9) {
                        System.out.print("][");
                    }
                }
                System.out.println("]");
    }
}
