package com.bcopstein;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public final int MAX_EMBARALHA = 1000;
    private final ArrayList<Carta> cartas;
    private int corrente;

    public Deck() {
        this.cartas = new ArrayList<>();
        corrente = 0;
    }

    public Carta pegaDeCima() {
        if (cartas.size() == 0){
            return null;
        }
        return cartas.removeFirst();
    }

    public void insereEmbaixo(Carta carta) {
        cartas.add(carta);
    }

    public void posicionaNoInicio() {
        corrente = 0;
    }

    public Carta devolveProxima() {
        if (corrente >= cartas.size()){
            return null;
        }
        Carta aux = cartas.get(corrente);
        corrente = corrente + 1; 
        return aux;
    }

    public void embaralha() {
        int tam = cartas.size();
        Random r = new Random();
        for(int i=0;i<MAX_EMBARALHA;i++){
            int p1 = r.nextInt(tam);
            int p2 = r.nextInt(tam);
            Carta aux = cartas.get(p1);
            cartas.set(p1,cartas.get(p2));
            cartas.set(p2,aux);
        }
    }
}