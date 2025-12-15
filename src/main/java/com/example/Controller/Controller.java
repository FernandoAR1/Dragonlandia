package com.example.Controller;

import com.example.Model.Hechizo;
import com.example.Model.Mago;
import com.example.Model.Monstruo;
import com.example.Model.nombreHechizo;

public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void simularBatalla(Mago mago, Monstruo monstruo) {
        int i=1;

        Hechizo hechizo1 = new Hechizo(nombreHechizo.Bola_de_nieve, mago);
        Hechizo hechizo2 = new Hechizo(nombreHechizo.Descarga, mago);

        if (mago.LanzarHechizo(monstruo, hechizo2)) {
            System.out.println("El hechizo ha impactado correctamente.");
        } else {
            System.out.println("El hechizo ha fallado.");
        }

        if (mago.LanzarHechizo(monstruo, hechizo1)) {
            System.out.println("El hechizo ha impactado correctamente.");
        } else {
            System.out.println("El hechizo ha fallado.");
        }


        while (mago.getVida() > 0 && monstruo.getVida() > 0) {
            mago.lanzarHechizo(monstruo);
            monstruo.atacar(mago);
            System.out.println("Ronda "+ i );
            System.out.println("Vida del mago " + mago.getNombre() + ": " + mago.getVida());
            System.out.println("Vida del monstruo " + monstruo.getNombre() + ": " + monstruo.getVida());
            i++;
        }

        if (mago.getVida() > 0) {
            System.out.println("El mago " + mago.getNombre() + " domina el bosque!");
        } else {
            System.out.println("El monstruo " + monstruo.getNombre() + " domina el bosque!");
        }
    }
}
