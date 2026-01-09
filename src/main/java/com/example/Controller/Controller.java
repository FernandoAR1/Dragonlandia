package com.example.Controller;

import java.util.Random;

import com.example.Model.Dragon;
import com.example.Model.Hechizo;
import com.example.Model.Mago;
import com.example.Model.Monstruo;
import com.example.Model.nombreHechizo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Controller {

    private static Controller instance;
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Dragonlandia");

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void simularBatalla(Mago mago, Monstruo monstruo,Mago mago2, Monstruo monstruo2,Monstruo monstruo3, Dragon dragon) {

        Random random = new Random();
        int ronda = 1;

        // Monstruo jefe inicial
        Monstruo monstruoJefe = monstruo;

        while ((mago.getVida() > 0 || mago2.getVida() > 0) &&
            (monstruo.getVida() > 0 || monstruo2.getVida() > 0 || monstruo3.getVida() > 0)) {

            System.out.println("===== RONDA " + ronda + " =====");

            // ==========================
            // 1. MAGOS LANZAN HECHIZOS
            // ==========================
            nombreHechizo[] hechizosDisponibles = nombreHechizo.values();

            // ----- MAGO 1 -----
            if (mago.getVida() > 0 && monstruoJefe.getVida() > 0) {

                nombreHechizo h = hechizosDisponibles[random.nextInt(hechizosDisponibles.length)];
                boolean conoce = false;

                for (Hechizo hechizo : mago.getHechizos()) {
                    if (hechizo.getNombre() == h) {
                        conoce = true;
                        break;
                    }
                }

                if (conoce) {
                    mago.lanzarHechizo(monstruoJefe);
                } else {
                    mago.setVida(mago.getVida() - 1);
                }
            }

            // ----- MAGO 2 -----
            if (mago2.getVida() > 0 && monstruoJefe.getVida() > 0) {

                nombreHechizo h2 = hechizosDisponibles[random.nextInt(hechizosDisponibles.length)];
                boolean conoce2 = false;

                for (Hechizo hechizo : mago2.getHechizos()) {
                    if (hechizo.getNombre() == h2) {
                        conoce2 = true;
                        break;
                    }
                }

                if (conoce2) {
                    mago2.lanzarHechizo(monstruoJefe);
                } else {
                    mago2.setVida(mago2.getVida() - 1);
                }
            }

            // ==========================
            // 2. DRAGÓN ATACA AL JEFE
            // ==========================
            if (monstruoJefe.getVida() > 0) {
                dragon.exhalar(monstruoJefe);
            }

            // ==========================
            // 3. MONSTRUOS ATACAN
            // ==========================
            // Monstruo 1
            if (monstruo.getVida() > 0) {
                if (mago.getVida() > 0 && mago2.getVida() > 0) {
                    if (random.nextBoolean()) monstruo.atacar(mago);
                    else monstruo.atacar(mago2);
                } else if (mago.getVida() > 0) {
                    monstruo.atacar(mago);
                } else if (mago2.getVida() > 0) {
                    monstruo.atacar(mago2);
                }
            }

            // Monstruo 2
            if (monstruo2.getVida() > 0) {
                if (mago.getVida() > 0 && mago2.getVida() > 0) {
                    if (random.nextBoolean()) monstruo2.atacar(mago);
                    else monstruo2.atacar(mago2);
                } else if (mago.getVida() > 0) {
                    monstruo2.atacar(mago);
                } else if (mago2.getVida() > 0) {
                    monstruo2.atacar(mago2);
                }
            }

            // Monstruo 3
            if (monstruo3.getVida() > 0) {
                if (mago.getVida() > 0 && mago2.getVida() > 0) {
                    if (random.nextBoolean()) monstruo3.atacar(mago);
                    else monstruo3.atacar(mago2);
                } else if (mago.getVida() > 0) {
                    monstruo3.atacar(mago);
                } else if (mago2.getVida() > 0) {
                    monstruo3.atacar(mago2);
                }
            }

            // ==========================
            // 4. REASIGNAR MONSTRUO JEFE
            // ==========================
            if (monstruoJefe.getVida() <= 0) {
                if (monstruo.getVida() > 0) monstruoJefe = monstruo;
                else if (monstruo2.getVida() > 0) monstruoJefe = monstruo2;
                else if (monstruo3.getVida() > 0) monstruoJefe = monstruo3;
            }

            // ==========================
            // 5. MOSTRAR ESTADO
            // ==========================
            System.out.println("Magos:");
            System.out.println(mago.getNombre() + " -> Vida: " + mago.getVida());
            System.out.println(mago2.getNombre() + " -> Vida: " + mago2.getVida());

            System.out.println("Monstruos:");
            System.out.println(monstruo.getNombre() + " -> Vida: " + monstruo.getVida());
            System.out.println(monstruo2.getNombre() + " -> Vida: " + monstruo2.getVida());
            System.out.println(monstruo3.getNombre() + " -> Vida: " + monstruo3.getVida());

            System.out.println("Dragón " + dragon.getNombre() +
                    " -> Resistencia: " + dragon.getResistencia());

            if (monstruoJefe != null && monstruoJefe.getVida() > 0) {
                System.out.println("👑 Monstruo jefe: " + monstruoJefe.getNombre());
            }

            System.out.println();
            ronda++;
        }

        // ==========================
        // 6. RESULTADO FINAL
        // ==========================
        if (mago.getVida() > 0 || mago2.getVida() > 0) {
            System.out.println("✨ Los magos dominan el bosque!");
        } else {
            System.out.println("💀 Los monstruos dominan el bosque!");
        }

        // Eliminar entidades derrotadas
        if (mago.getVida()==0) {
            new ControllerMago().eliminarMago(mago);
        }else{
            new ControllerMago().actualizarMago(mago);
        }
        if (mago2.getVida()==0) {
            new ControllerMago().eliminarMago(mago2);
        }else{
            new ControllerMago().actualizarMago(mago2);
        }
        if (monstruo.getVida()==0) {
            new ControllerMonstruo().eliminarMonstruo(monstruo);
        }else{
            new ControllerMonstruo().actualizarMonstruo(monstruo);
        }
        if (monstruo2.getVida()==0) {
            new ControllerMonstruo().eliminarMonstruo(monstruo2);
        }else{
            new ControllerMonstruo().actualizarMonstruo(monstruo2);
        }
        if (monstruo3.getVida()==0) {
            new ControllerMonstruo().eliminarMonstruo(monstruo3);
        }else{
            new ControllerMonstruo().actualizarMonstruo(monstruo3);
        }
        if (dragon.getResistencia()==0) {
            new ControllerDragon().eliminarDragon(dragon);
        }else{
            new ControllerDragon().actualizarDragon(dragon);
        }
    }


    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    public static void close() {
        if (entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}