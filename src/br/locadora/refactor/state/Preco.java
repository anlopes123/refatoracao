package br.locadora.refactor.state;

public abstract class Preco {
      public abstract int getPreco();

      /*
                        aqui percebemos que este método utiliza informações de Aluguel e não utiliza nenhuma informação
                        de cliente, então este método não está no lugar certo, temos que refatora novamente
                        pois não há necessidade deste método estar aqui.
                     */
      public abstract double getValor(int diasAluguel);

    public int getPontos(int diasAluguel) {
        return 1;
    }
}
