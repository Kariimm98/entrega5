package com.example.entrega5;

import java.util.Locale;

public class Partida {

    Jugador  jugador;
     int rondes;
     String paraula;

    public Partida(Jugador jugador, String paraula){
        this.jugador = jugador;
        this.paraula = paraula;
    }

    public int getIndexChar(String lletra){
        rondes++;
        return paraula.toLowerCase(Locale.ROOT).indexOf(lletra);
    }

    public String getParaula(){
        return this.paraula;
    }
}
