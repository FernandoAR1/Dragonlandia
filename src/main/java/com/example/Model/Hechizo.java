package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hechizo")
public class Hechizo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private HechizoEnum nombre;

    private int efecto;

    @ManyToOne
    @JoinColumn(name = "mago_id")
    private Mago mago;   // ← Dueño de la relación

    public Hechizo() {}

    public Hechizo(HechizoEnum nombre,Mago mago) {
        this.nombre = nombre;
        this.efecto = nombre.getEfecto();
        this.mago = mago;
    }

    public int getId() {
        return id;
    }

    public HechizoEnum getNombre() {
        return nombre;
    }

    public void setNombre(HechizoEnum nombre) {
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
