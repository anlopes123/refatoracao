package br.locadora.refactor;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Aluguel> alugueis;

    public Cliente(String nome) {
        this.nome = nome;
        this.alugueis = new ArrayList<>();
    }

    public void addAluguel(Aluguel aluguel) {
        this.alugueis.add(aluguel);
    }

    public String getNome() {
        return nome;
    }
    /*
      Aqui o gerente pode solicitar mais duas novas funcionalidades,
      que é exibir o registros dos alugueis em HTML e a adição de novos preços.
      notamos que este método está inpossível acrescentar essas novas funcionalidades,
      vamos ter que refatorá-lo.
    */

    public String exibirRegistroAlugueis() {
        double valorTotal = 0;
        int pontos = 0;
        StringBuilder dados = new StringBuilder();
        dados.append("Registro de Aluguéis do cliente: " + getNome() + "\n");
        for (Aluguel aluguel : this.alugueis) {
            double valor = 0;

            valor = aluguel.getValor();

            pontos = aluguel.getPontos();

            // Adiciona os dados desse aluguel
            dados.append("\t" + aluguel.getFilme().getTitulo() + "\t");
            dados.append(" = R$ ").append(valor).append("\n");

            valorTotal += valor;
        }

        // Rodapé
        dados.append("Total gasto com aluguéis: R$ ").append(valorTotal);
        dados.append("Pontos ganhos: ").append(pontos);

        return dados.toString();
    }

}
