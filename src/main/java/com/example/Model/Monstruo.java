package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "monstruo")
public class Monstruo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int vida;
    @Enumerated(EnumType.STRING)
    private TipoMonstruo tipo;
    private int fuerza;

    @ManyToOne
    @JoinColumn(name = "bosque_id")
    private Bosque bosque;

    public Monstruo() {
    }

    public Monstruo(String nombre, int vida, TipoMonstruo tipo, int fuerza, Bosque bosque) {
        this.nombre = nombre;
        this.vida = vida;
        this.tipo = tipo;
        this.fuerza = fuerza;
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

    public int getVida() {
        if (vida<0) {
            vida = 0;
        }
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public TipoMonstruo getTipo() {
        return tipo;
    }

    public void setTipo(TipoMonstruo tipo) {
        this.tipo = tipo;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void atacar(Mago mago) {
        mago.setVida(mago.getVida() - this.fuerza);
    }

}
