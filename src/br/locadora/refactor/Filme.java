package br.locadora.refactor;

import br.locadora.refactor.state.Preco;
import br.locadora.refactor.state.PrecoInfantil;
import br.locadora.refactor.state.PrecoLancamento;
import br.locadora.refactor.state.PrecoNormal;

public class Filme {
    public static final int NORMAL = 0;
    public static final int INFANTIL = 1;
    public static final int LANCAMENTO = 2;

    private String titulo;
    Preco preco;

    public Filme(String titulo, int preco) {
        this.titulo = titulo;
       setPreco(preco);
    }


    public int getPreco() {
        return preco.getPreco();
    }

    public void setPreco(int preco) {
        switch (preco) {
            case Filme.NORMAL:
                this.preco = new PrecoNormal();
                break;
            case Filme.INFANTIL:
                this.preco = new PrecoInfantil();
                break;
            case Filme.LANCAMENTO:
                this.preco = new PrecoLancamento();
                break;
            default:
                throw new IllegalArgumentException("Código do Preço inválido");
        }

    }

    public String getTitulo() {
        return titulo;
    }

    public double getValor(int diasAluguel) {
        return preco.getValor(diasAluguel);
    }
    public int getPontos(int diasAluguel) {
        return preco.getPontos(diasAluguel);
    }
}
