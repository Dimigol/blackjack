package com.bcopstein;

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

    public Deck getDeck() {
        return deck;
    }

    public String getNome() {
        return nome;
    }
}