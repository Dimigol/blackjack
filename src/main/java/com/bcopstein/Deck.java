package com.bcopstein;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private static final int NUMERO_TENTATIVAS_EMBARALHAMENTO = 1000; // tentativas de troca durante o embaralhamento
    private final List<Carta> cartas;
    private int corrente;
    private int topo;

    public Deck() {
        this.cartas = new ArrayList<>();
        corrente = 0;
        topo = 0;
    }

    public Carta pegaDeCima() {
        if (cartasRestantes() == 0) {
            return null;
        }
        Carta carta = cartas.get(topo);
        topo++;
        if (topo >= cartas.size()) {
            cartas.clear();
            topo = 0;
            corrente = 0;
        }
        return carta;
    }

    public void insereEmbaixo(Carta carta) {
        cartas.add(carta);
    }

    public void posicionaNoInicio() {
        corrente = 0;
    }

    public Carta devolveProxima() {
        if (corrente >= cartas.size()) {
            return null;
        }
        Carta aux = cartas.get(corrente);
        corrente++;
        return aux;
    }

    public void embaralha() {
        int tamanhoAtivo = cartasRestantes();
        if (tamanhoAtivo <= 1) {
            return;
        }
        Random r = new Random();
        for (int i = 0; i < NUMERO_TENTATIVAS_EMBARALHAMENTO; i++) {
            int p1 = topo + r.nextInt(tamanhoAtivo);
            int p2 = topo + r.nextInt(tamanhoAtivo);
            Carta aux = cartas.get(p1);
            cartas.set(p1, cartas.get(p2));
            cartas.set(p2, aux);
        }
    }

    public int cartasRestantes() {
        return cartas.size() - topo;
    }

    public List<Carta> copiaCartas() {
        if (topo == 0) {
            return new ArrayList<>(cartas);
        }
        return new ArrayList<>(cartas.subList(topo, cartas.size()));
    }
}
