package br.locadora.norefactor;

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

    public String exibirRegistroAlugueis() {
        double valorTotal = 0;
        int pontos = 0;
        StringBuilder dados = new StringBuilder();
        dados.append("Registro de Aluguéis do cliente: " + getNome() + "\n");
        for (Aluguel aluguel : this.alugueis) {
            double valor = 0;

            // Calcula o valor do aluguel
            //vamos utilizar extrair Método
            // depois mover método
            //

            switch (aluguel.getFilme().getPreco()) {
                case Filme.NORMAL:
                    valor += 1.5;
                    if (aluguel.getDiasAluguel() > 3)
                        valor += (aluguel.getDiasAluguel() - 3) * 1.5;
                    break;
                case Filme.INFANTIL:
                    valor += 2;
                    if (aluguel.getDiasAluguel() > 2)
                        valor += (aluguel.getDiasAluguel() - 2) * 1.5;
                    break;
                case Filme.LANCAMENTO:
                    valor += aluguel.getDiasAluguel() * 3;
                    break;
            }

            // Adiciona um ponto
            //vamos utilizar extrair Método
            // depois mover método
            // depois que estiver no local correto vamos aplicar noamente
            // mover metodo para a classe Filme mais agora com um adendo que
            // é manter o método original na classe aluguel
            // a próxima refatoração a aplicar a técnica trocar condicional por polimorfismo
            // com isso ganhamos mais flexibilidade para modificar a classe;

            pontos++;

            // Bônus para mais de dois dias com um lançamento
            if (aluguel.getFilme().getPreco() == Filme.LANCAMENTO
                    && aluguel.getDiasAluguel() > 1)
                pontos++;

            // Adiciona os dados desse aluguel
            dados.append("\t" + aluguel.getFilme().getTitulo() + "\t");
            dados.append(" = R$ " + String.valueOf(valor) + "\n");

            valorTotal += valor;
        }

        // Rodapé
        dados.append("Total gasto com aluguéis: R$ ").append(valorTotal);
        dados.append("\n Pontos ganhos: ").append(pontos);

        return dados.toString();
    }
}
