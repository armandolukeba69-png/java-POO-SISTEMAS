package ao.universidade.poo.banco;

import java.util.ArrayList;
import java.util.List;

public class BancoApp {

    public static void main(String[] args) {

        List<Conta> contas = new ArrayList<>();

        ContaCorrente cc1 =
                new ContaCorrente("001", 500, 300);

        ContaPoupanca cp1 =
                new ContaPoupanca("002", 1000, 0.01);

        contas.add(cc1);
        contas.add(cp1);

        System.out.println("Estado inicial:");

        imprimirContas(contas);

        for (Conta c : contas) {
            c.depositar(200);
        }

        System.out.println("\nApós depósito:");

        imprimirContas(contas);

        try {

            cc1.sacar(1000);

            System.out.println("\nSaque efetuado.");

        } catch (SaldoInsuficienteException e) {

            System.out.println("Erro: " + e.getMessage());
        }

        try {

            cp1.transferir(cc1, 300);

            System.out.println("\nTransferência efetuada.");

        } catch (SaldoInsuficienteException e) {

            System.out.println("Erro: " + e.getMessage());
        }

        cp1.aplicarRendimento();

        System.out.println("\nApós rendimento:");

        imprimirContas(contas);
    }

    private static void imprimirContas(
            List<Conta> contas
    ) {

        for (Conta c : contas) {
            System.out.println(c);
        }
    }
}
}
