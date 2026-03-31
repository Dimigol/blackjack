package com.bcopstein;

public class Carta {
    private final Naipe naipe;
    private final Valor valor;

    public Carta(Naipe naipe, Valor valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public Naipe getNaipe() {
        return naipe;
    }

    public Valor getValor() {
        return valor;
    }

    public int valorInteiro(){
        return switch (valor) {
            case AS -> 1;
            case DOIS -> 2;
            case TRES -> 3;
            case QUATRO -> 4;
            case CINCO -> 5;
            case SEIS -> 6;
            case SETE -> 7;
            case OITO -> 8;
            case NOVE -> 9;
            case DEZ,VALETE,DAMA,REI -> 10;
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carta{");
        sb.append("naipe=").append(naipe);
        sb.append(", valor=").append(valor);
        sb.append('}');
        return sb.toString();
    }


}