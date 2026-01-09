package com.example.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import com.example.Controller.Controller;
import com.example.Controller.ControllerBosque;
import com.example.Controller.ControllerDragon;
import com.example.Controller.ControllerMago;
import com.example.Controller.ControllerMonstruo;

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
    private ControllerBosque controllerBosque;
    private ControllerMonstruo controllerMonstruo;
    private ControllerDragon controllerDragon;
    private ControllerMago controllerMago;

    public Interfaz() {
        this.scanner = new Scanner(System.in);
        this.controller = Controller.getInstance();
        this.controllerBosque = new ControllerBosque();
        this.controllerMonstruo = new ControllerMonstruo();
        this.controllerDragon = new ControllerDragon();
        this.controllerMago = new ControllerMago();
    }

    public void iniciar() {

        Bosque bosque = crearBosque();
        controllerBosque.guardarBosque(bosque);

        Monstruo monstruo = crearMonstruo("Monstruo jefe del bosque:", bosque);
        controllerMonstruo.guardarMonstruo(monstruo);

        Monstruo monstruo2 = crearMonstruo("Segundo monstruo:", bosque);
        controllerMonstruo.guardarMonstruo(monstruo2);

        Monstruo monstruo3 = crearMonstruo("Tercer monstruo:", bosque);
        controllerMonstruo.guardarMonstruo(monstruo3);

        bosque.setMonstruoJefe(monstruo);
        controllerBosque.actualizarBosque(bosque);

        Dragon dragon = crearDragon(bosque);
        controllerDragon.guardarDragon(dragon);

        Mago mago = crearMago();
        controllerMago.guardarMago(mago);

        Mago mago2 = crearMago();
        controllerMago.guardarMago(mago2);

        System.out.println("Iniciando batalla entre el mago " + mago.getNombre() + " y el monstruo " + monstruo.getNombre());
        controller.simularBatalla(mago, monstruo, mago2, monstruo2, monstruo3, dragon);

        scanner.close();
        Controller.close();
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
        
        Random random = new Random();
        nombreHechizo[] hechizosDisponibles = nombreHechizo.values();
        
        for (int i = 0; i < 2; i++) {
            nombreHechizo nombreAleatorio = hechizosDisponibles[random.nextInt(hechizosDisponibles.length)];
            hechizos.add(new Hechizo(nombreAleatorio, mago));
        }

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
