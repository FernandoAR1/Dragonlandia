package com.example.Model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "mago")
public class Mago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int vida;
    private int nivelMagia;
    private List<String> hechizos;

    public Mago() {
    }

    public Mago(String nombre, int vida, int nivelMagia) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivelMagia = nivelMagia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

    public void setNivelMagia(int nivelMagia) {
        this.nivelMagia = nivelMagia;
    }

    public List<String> getHechizos() {
        return hechizos;
    }

    public void setHechizos(List<String> hechizos) {
        this.hechizos = hechizos;
    }
    
    public void lanzarHechizo(Monstruo mostruo) {
        int nuevaVida = mostruo.getVida() - this.nivelMagia;
        mostruo.setVida(nuevaVida);
    }

    public boolean LanzarHechizo(Monstruo monstruo,Hechizo hechizo) {
        boolean pegar=false;
        if (hechizos.contains(hechizo.getNombre().toString())) {
            int nuevaVida = monstruo.getVida() - hechizo.getEfecto();
            monstruo.setVida(nuevaVida);
            pegar=true;
        }else{
            this.vida -= 1;
        }
        return pegar;
    }
}
