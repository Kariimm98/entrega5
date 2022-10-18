package com.example.entrega5;

import java.io.Serializable;

public class Jugador implements Serializable {
    String nom;
    int intents=0;

    public Jugador(String nom){
        this.nom = nom;
    }

    public void restarIntent(){
        intents--;
    }

    public boolean teIntents(){
        return intents!=0;
    }
}
