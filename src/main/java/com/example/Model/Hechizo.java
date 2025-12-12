package com.example.Model;

public class Hechizo {

    private nombreHechizo nombre;
    private int efecto;

    public Hechizo() {
    }

    public Hechizo(nombreHechizo nombre, int efecto) {
        this.nombre = nombre;
        this.efecto = efecto;
    }

    public nombreHechizo getNombre() {
        return nombre;
    }

    public void setNombre(nombreHechizo nombre) {
        this.nombre = nombre;
    }

    public int getEfecto() {
        efecto = 0;
        if (nombre == nombreHechizo.Bola_de_fuego) {
            efecto = 10;
        }else if (nombre == nombreHechizo.Rayo) {
            efecto = 20;
        }else if (nombre == nombreHechizo.Bola_de_nieve) {
            efecto = 999999;
        }else if (nombre == nombreHechizo.Descarga) {
            efecto = 10;
        }else if (nombre == nombreHechizo.Maldicion_duende) {
            efecto = 10;
        }
        return efecto;
    }

    public void setEfecto(int efecto) {
        this.efecto = efecto;
    }
}
