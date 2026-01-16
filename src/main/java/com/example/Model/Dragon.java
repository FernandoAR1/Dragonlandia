package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dragon")
public class Dragon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int intensidadFuego;
    private int resistencia;

    @ManyToOne
    @JoinColumn(name = "bosque_id")
    private Bosque bosque;

    public Dragon() {
    }

    public Dragon(String nombre, int intensidadFuego, int resistencia, Bosque bosque) {
        this.nombre = nombre;
        this.intensidadFuego = intensidadFuego;
        this.resistencia = resistencia;
        this.bosque = bosque;
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

    public int getIntensidadFuego() {
        return intensidadFuego;
    }

    public void setIntensidadFuego(int intensidadFuego) {
        this.intensidadFuego = intensidadFuego;
    }

    public int getResistencia() {
        if (resistencia < 0) {
            resistencia = 0;
        }
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public Bosque getBosque() {
        return bosque;
    }

    public void setBosque(Bosque bosque) {
        this.bosque = bosque;
    }

    public void exhalar(Monstruo monstruo) {
        int nuevaVida = monstruo.getVida() - this.intensidadFuego;
        monstruo.setVida(nuevaVida);
    }
}
