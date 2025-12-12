package com.example.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "hechizo")
public class Hechizo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private nombreHechizo nombre;

    private int efecto;

    @ManyToOne
    @JoinColumn(name = "mago_id")
    private Mago mago;   // ← Dueño de la relación

    public Hechizo() {}

    public Hechizo(nombreHechizo nombre, int efecto, Mago mago) {
        this.nombre = nombre;
        this.efecto = efecto;
        this.mago = mago;
    }

    public int getId() {
        return id;
    }

    public nombreHechizo getNombre() {
        return nombre;
    }

    public void setNombre(nombreHechizo nombre) {
        this.nombre = nombre;
    }

    public int getEfecto() {
        return efecto;
    }

    public void setEfecto(int efecto) {
        this.efecto = efecto;
    }

    public Mago getMago() {
        return mago;
    }

    public void setMago(Mago mago) {
        this.mago = mago;
    }
}
