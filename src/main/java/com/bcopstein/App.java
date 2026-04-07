package com.bcopstein;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Jogador j1 = new Jogador("Huguinho");
        Jogador j2 = new Jogador("Luizinho");
        Baralho baralho = new Baralho();

        try (Scanner sc = new Scanner(System.in)) {
            Jogo jogo = new Jogo(j1, j2, baralho, sc);
            jogo.iniciar();
        }
    }
}
