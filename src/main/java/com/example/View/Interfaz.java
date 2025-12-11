package com.example.View;

import java.util.Scanner;

import com.example.Controller.Controller;
import com.example.Model.Bosque;
import com.example.Model.Mago;
import com.example.Model.Monstruo;
import com.example.Model.tipo;

public class Interfaz {
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();

        System.out.println("Mago:");
        System.out.print("Introduce el nombre del mago: ");
        String nombreMago = scanner.nextLine();
        System.out.print("Introduce la vida del mago: ");
        int vidaMago = scanner.nextInt();
        System.out.print("Introduce el nivel de magia del mago: ");
        int nivelMagia = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Mago mago = new Mago(nombreMago, vidaMago, nivelMagia);

        controller.guardarMago(mago);

        Bosque bosque = new Bosque("Bosque Encantado", 2);
        controller.guardarBosque(bosque);

        System.out.println("Monstruo jefe del bosque:");
        System.out.print("Introduce el nombre del monstruo: ");
        String nombreMonstruo = scanner.nextLine();
        System.out.print("Introduce la vida del monstruo: ");
        int vidaMonstruo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Introduce el tipo del monstruo (OGRO, TROLL, ESPECTRO): ");
        String tipoMonstruoStr = scanner.nextLine();
        tipo tipoMonstruo = tipo.valueOf(tipoMonstruoStr.toUpperCase());
        System.out.print("Introduce el poder de ataque del monstruo: ");
        int poderAtaque = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Monstruo monstruo = new Monstruo(nombreMonstruo, vidaMonstruo, tipoMonstruo, poderAtaque, bosque);

        controller.guardarMonstruo(monstruo);

        System.out.println("Monstruo jefe del bosque:");
        System.out.print("Introduce el nombre del monstruo: ");
        String nombreMonstruo2 = scanner.nextLine();
        System.out.print("Introduce la vida del monstruo: ");
        int vidaMonstruo2 = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Introduce el tipo del monstruo (OGRO, TROLL, ESPECTRO): ");
        String tipoMonstruoStr2 = scanner.nextLine();
        tipo tipoMonstruo2 = tipo.valueOf(tipoMonstruoStr2.toUpperCase());
        System.out.print("Introduce el poder de ataque del monstruo: ");
        int poderAtaque2 = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Monstruo monstruo2 = new Monstruo(nombreMonstruo2, vidaMonstruo2, tipoMonstruo2, poderAtaque2, bosque);

        controller.guardarMonstruo(monstruo2);

        bosque.setMonstruoJefe(monstruo);
        controller.actualizarBosque(bosque);

        System.out.println("Iniciando batalla entre el mago " + mago.getNombre() + " y el monstruo " + monstruo.getNombre());
        controller.simularBatalla(mago, monstruo);

        scanner.close();
        
    }
}
