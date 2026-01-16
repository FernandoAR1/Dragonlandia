package com.example.model;

public enum HechizoEnum {
    Bola_de_fuego(10),
    Rayo(20),
    Bola_de_nieve(999999),
    Descarga(10),
    Maldicion_duende(10);

    private final int efecto;

    HechizoEnum(int efecto) {
        this.efecto = efecto;
    }

    public int getEfecto() {
        return efecto;
    }
}
