package com.bcopstein;

public class Baralho {
    private final Deck deck;

    public Baralho() {
        deck = new Deck();
        inicializa();
    }

    private void inicializa(){
        for(Naipe n:Naipe.values()){
            for(Valor v:Valor.values()){
                Carta c = new Carta(n,v);
                deck.insereEmbaixo(c);
            }
        }
    }

    public void embaralha() {
        deck.embaralha();
    }

    public Carta pegaDeCima() {
        return deck.pegaDeCima();
    }

    public void insereEmbaixo(Carta carta) {
        deck.insereEmbaixo(carta);
    }
}