package com.example.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.Controller.Controller;
import com.example.Model.Bosque;
import com.example.Model.Dragon;
import com.example.Model.Hechizo;
import com.example.Model.Mago;
import com.example.Model.Monstruo;
import com.example.Model.nombreHechizo;
import com.example.Model.tipo;

public class Interfaz {
    private Scanner scanner;
    private Controller controller;

    public Interfaz() {
        this.scanner = new Scanner(System.in);
        this.controller = Controller.getInstance();
    }

    public void iniciar() {
        Mago mago = crearMago();
        controller.guardarMago(mago);

        Bosque bosque = crearBosque();
        controller.guardarBosque(bosque);

        Monstruo monstruo = crearMonstruo("Monstruo jefe del bosque:", bosque);
        controller.guardarMonstruo(monstruo);

        Monstruo monstruo2 = crearMonstruo("Segundo monstruo:", bosque);
        controller.guardarMonstruo(monstruo2);

        Dragon dragon = crearDragon(bosque);
        controller.guardarDragon(dragon);

        bosque.setMonstruoJefe(monstruo);
        controller.actualizarBosque(bosque);

        System.out.println(
                "Iniciando batalla entre el mago " + mago.getNombre() + " y el monstruo " + monstruo.getNombre());
        controller.simularBatalla(mago, monstruo);

        scanner.close();
    }

    private Mago crearMago() {
        System.out.println("Mago:");
        System.out.print("Introduce el nombre del mago: ");
        String nombreMago = scanner.nextLine();
        System.out.print("Introduce la vida del mago: ");
        int vidaMago = scanner.nextInt();
        System.out.print("Introduce el nivel de magia del mago: ");
        int nivelMagia = scanner.nextInt();
        scanner.nextLine();

        Mago mago = new Mago(nombreMago, vidaMago, nivelMagia);
        List<Hechizo> hechizos = new ArrayList<>();
        hechizos.add(new Hechizo(nombreHechizo.Bola_de_fuego, mago));
        hechizos.add(new Hechizo(nombreHechizo.Rayo, mago));
        hechizos.add(new Hechizo(nombreHechizo.Bola_de_nieve, mago));

        mago.setHechizos(hechizos);

        return mago;
    }

    private Bosque crearBosque() {
        return new Bosque("Bosque Encantado", 2);
    }

    private Monstruo crearMonstruo(String mensaje, Bosque bosque) {
        System.out.println(mensaje);
        System.out.print("Introduce el nombre del monstruo: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce la vida del monstruo: ");
        int vida = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduce el tipo del monstruo (OGRO, TROLL, ESPECTRO): ");
        String tipoStr = scanner.nextLine();
        tipo tipoMonstruo = tipo.valueOf(tipoStr.toUpperCase());
        System.out.print("Introduce el poder de ataque del monstruo: ");
        int poderAtaque = scanner.nextInt();
        scanner.nextLine();

        return new Monstruo(nombre, vida, tipoMonstruo, poderAtaque, bosque);
    }

    private Dragon crearDragon(Bosque bosque) {
        return new Dragon("Fuego", 50, 100, bosque);
    }
}
