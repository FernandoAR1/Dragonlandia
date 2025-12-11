package com.example.Model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "bosque")
public class Bosque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int nivelPeligro;
    
    @OneToOne
    @JoinColumn(name = "monstruoJefe_id")
    private Monstruo monstruoJefe;

    // Relación bidireccional: usa la FK bosque_id en Monstruo, evita tabla intermedia bosque_monstruo
    @OneToMany(mappedBy = "bosque")
    private List<Monstruo> monstruos;

    public Bosque() {
    }

    public Bosque(String nombre, int nivelPeligro) {
        this.nombre = nombre;
        this.nivelPeligro = nivelPeligro;
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

    public int getNivelPeligro() {
        return nivelPeligro;
    }

    public void setNivelPeligro(int nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }

    public Monstruo getMonstruoJefe() {
        return monstruoJefe;
    }

    public void setMonstruoJefe(Monstruo monstruoJefe) {
        this.monstruoJefe = monstruoJefe;
    }

    public void mostrarJefe() {
        System.out.println("Monstruo Jefe: " + monstruoJefe.getNombre() + ", Vida: " + monstruoJefe.getVida() + ", Tipo: " + monstruoJefe.getTipo() + ", Fuerza: " + monstruoJefe.getFuerza());
    }

    public void cambiarJefe(Monstruo nuevoJefe) {
        this.monstruoJefe = nuevoJefe;
    }
}