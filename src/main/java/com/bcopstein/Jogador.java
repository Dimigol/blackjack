package com.bcopstein;

import java.util.Collections;
import java.util.List;

public class Jogador {
    private final String nome;
    private final Deck deck;

    public Jogador(String nome) {
        this.nome = nome;
        this.deck = new Deck();
    }

    public int somaCartas() {
        int soma = 0;
        deck.posicionaNoInicio();
        Carta aux = deck.devolveProxima();
        while(aux != null){
            soma = soma + aux.valorInteiro();
            aux = deck.devolveProxima();
        }
        return soma;
    }

    public void recebeCarta(Carta carta) {
        deck.insereEmbaixo(carta);
    }

    public int pontuacao() {
        return somaCartas();
    }

    public List<Carta> cartas() {
        return Collections.unmodifiableList(deck.copiaCartas());
    }

    public String getNome() {
        return nome;
    }
}
