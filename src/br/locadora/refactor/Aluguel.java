package br.locadora.refactor;

public class Aluguel {
    Filme filme;
    private int diasAluguel;

    public Aluguel(Filme filme, int diasAluguel) {
        this.filme = filme;
        this.diasAluguel = diasAluguel;
    }

    public int getPontos() {
       return filme.getPontos(diasAluguel);
    }

    public double getValor() {
        return filme.preco.getValor(diasAluguel);
    }

    public Filme getFilme() {
        return filme;
    }

    public int getDiasAluguel() {
        return diasAluguel;
    }
}
