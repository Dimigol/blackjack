package com.bcopstein;

public class App {
    public static void exibeJogador(Jogador j){
        System.out.println("Cartas do jogador: "+j.getNome());
        j.getDeck().posicionaNoInicio();
        Carta aux = j.getDeck().devolveProxima();
        while(aux != null){
            System.out.println(aux.toString());
            aux = j.getDeck().devolveProxima();
        }
        System.out.println("Somatorio: "+j.somaCartas());
        System.out.println("----------------------");
    }
    public static void main(String[] args) {
        // Exemplo de como poderia ser o jogo
        //Cria os jogadores
        Jogador j1 = new Jogador("Huguinho");
        Jogador j2 = new Jogador("Luizinho");
        // Cria o baralho e embaralha
        Baralho baralho = new Baralho();
        baralho.embaralha();
        // Distribui as primeiras duas cartas para cada jogador
        j1.getDeck().insereEmbaixo(baralho.pegaDeCima());
        j1.getDeck().insereEmbaixo(baralho.pegaDeCima());
        j2.getDeck().insereEmbaixo(baralho.pegaDeCima());
        j2.getDeck().insereEmbaixo(baralho.pegaDeCima());
        // Exibe a situação de cada jogador
        exibeJogador(j1);
        exibeJogador(j2);
        /*
            A partir daqui fazer um loop:
                Exibe a situação dos jogadores
                Pergunta se j1 quer mais cartas
                Se sim:
                    Da mais uma carta para j1
                    Verifica se ele ganhou ou perdeu e encerra
                    Senão continua 
                Pergunta se j2 quer mais cartas
                Se sim:
                    Da mais uma carta para j2
                    Verifica se ele ganhou ou perdeu e encerra
                    Senão continua 
            fim do loop
        */ 



    }
}
