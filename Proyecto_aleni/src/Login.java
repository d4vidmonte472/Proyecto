/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;
public class Login {
    
    public static void main(String[] args) {
        // Credenciales del administrador
        String adminUsername = "admin";
        String adminPassword = "password123";

        // Solicitar nombre de usuario
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicitar nombre de usuario
            System.out.print("Ingrese nombre de usuario: ");
            String username = scanner.nextLine();
            
            // Solicitar contraseña
            System.out.print("Ingrese contraseña: ");
            String password = scanner.nextLine();
            
            // Verificar credenciales
            if (username.equals(adminUsername) && password.equals(adminPassword)) {
                System.out.println("¡Acceso concedido! Bienvenido, administrador.");
            } else {
                System.out.println("Acceso denegado. Credenciales incorrectas.");
            }
        }
    }
}
