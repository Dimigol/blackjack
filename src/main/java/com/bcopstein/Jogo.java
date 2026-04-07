package com.bcopstein;

import java.util.Scanner;

public class Jogo {
    private final Jogador jogador1;
    private final Jogador jogador2;
    private final Baralho baralho;
    private final Scanner scanner;

    public Jogo(Jogador jogador1, Jogador jogador2, Baralho baralho, Scanner scanner) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.baralho = baralho;
        this.scanner = scanner;
    }

    public void iniciar() {
        baralho.embaralha();
        distribuirCartasIniciais();

        while (true) {
            System.out.println("\nSituação atual:");
            exibirJogador(jogador1);
            exibirJogador(jogador2);

            boolean jogou = false;

            if (jogadorVaiJogar(jogador1)) {
                jogou = true;
                if (verificarResultado(jogador1, jogador2)) {
                    break;
                }
            }

            if (jogadorVaiJogar(jogador2)) {
                jogou = true;
                if (verificarResultado(jogador2, jogador1)) {
                    break;
                }
            }

            if (!jogou) {
                finalizarPontuacao();
                break;
            }

            if (jogador1.pontuacao() > 21 || jogador2.pontuacao() > 21) {
                break; // já tratado em verificarResultado, mas segurança adicional.
            }
        }
    }

    private void distribuirCartasIniciais() {
        for (int i = 0; i < 2; i++) {
            entregarCarta(jogador1);
            entregarCarta(jogador2);
        }
    }

    private void entregarCarta(Jogador jogador) {
        Carta carta = baralho.pegaDeCima();
        if (carta != null) {
            jogador.recebeCarta(carta);
        }
    }

    private void exibirJogador(Jogador jogador) {
        System.out.println("Cartas do jogador: " + jogador.getNome());
        for (Carta carta : jogador.cartas()) {
            System.out.println(carta);
        }
        System.out.println("Somatorio: " + jogador.pontuacao());
        System.out.println("----------------------");
    }

    private boolean jogadorVaiJogar(Jogador jogador) {
        if (!querMaisCarta(jogador)) {
            return false;
        }
        Carta carta = baralho.pegaDeCima();
        if (carta == null) {
            System.out.println("Baralho vazio. Não é possível distribuir mais cartas.");
            return false;
        }
        jogador.recebeCarta(carta);
        System.out.printf("%s recebeu: %s%n", jogador.getNome(), carta);
        return true;
    }

    private boolean querMaisCarta(Jogador jogador) {
        while (true) {
            System.out.printf("%s, deseja mais uma carta? (s/n): ", jogador.getNome());
            String linha = scanner.nextLine().trim().toLowerCase();
            if (linha.isEmpty()) {
                continue;
            }
            char c = linha.charAt(0);
            if (c == 's') {
                return true;
            }
            if (c == 'n') {
                return false;
            }
            System.out.println("Resposta inválida. Digite s ou n.");
        }
    }

    private boolean verificarResultado(Jogador jogador, Jogador outro) {
        int soma = jogador.pontuacao();
        if (soma > 21) {
            System.out.printf("%s estourou com %d! %s vence.%n", jogador.getNome(), soma, outro.getNome());
            return true;
        }
        if (soma == 21) {
            System.out.printf("%s fez Blackjack (21)! %s vence.%n", jogador.getNome(), jogador.getNome());
            return true;
        }
        return false;
    }

    private void finalizarPontuacao() {
        int soma1 = jogador1.pontuacao();
        int soma2 = jogador2.pontuacao();
        System.out.printf("Nenhum jogador pediu carta. Pontuação final: %s=%d vs %s=%d%n", jogador1.getNome(), soma1, jogador2.getNome(), soma2);
        if (soma1 > soma2) {
            System.out.printf("%s vence!%n", jogador1.getNome());
        } else if (soma2 > soma1) {
            System.out.printf("%s vence!%n", jogador2.getNome());
        } else {
            System.out.println("Empate!\n");
        }
    }
}
