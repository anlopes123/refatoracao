package br.locadora.test;

import br.locadora.norefactor.Aluguel;
import br.locadora.norefactor.Cliente;
import br.locadora.norefactor.Filme;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClientTest {

    @Test
    public void testClientFilmeInfantil(){
        String expectedMsg = "Registro de Aluguéis do cliente: Anizair\n" +
                "\tPor toda minha vida\t = R$ 3.5\n" +
                "Total gasto com aluguéis: R$ 3.5\n" +
                " Pontos ganhos: 1";
        Cliente cliente = new Cliente("Anizair");
        Filme filme = new Filme("Por toda minha vida", 1);
        Aluguel aluguel = new Aluguel(filme, 3);
        cliente.addAluguel(aluguel);
        assertEquals(expectedMsg, cliente.exibirRegistroAlugueis());

    }
    @Test
    public void testClientFilmeNormal(){
        String expectedMsg = "Registro de Aluguéis do cliente: Anizair\n" +
                "\tPor toda minha vida\t = R$ 1.5\n" +
                "Total gasto com aluguéis: R$ 1.5\n" +
                " Pontos ganhos: 1";
        Cliente cliente = new Cliente("Anizair");
        Filme filme = new Filme("Por toda minha vida", 0);
        Aluguel aluguel = new Aluguel(filme, 3);
        cliente.addAluguel(aluguel);
        assertEquals(expectedMsg, cliente.exibirRegistroAlugueis());

    }

    @Test
    public void testClientFilmeLancamento(){
        String expectedMsg = "Registro de Aluguéis do cliente: Anizair\n" +
                "\tPor toda minha vida\t = R$ 9.0\n" +
                "Total gasto com aluguéis: R$ 9.0\n" +
                " Pontos ganhos: 2";
        Cliente cliente = new Cliente("Anizair");
        Filme filme = new Filme("Por toda minha vida", 2);
        Aluguel aluguel = new Aluguel(filme, 3);
        cliente.addAluguel(aluguel);
        assertEquals(expectedMsg, cliente.exibirRegistroAlugueis());

    }
}
