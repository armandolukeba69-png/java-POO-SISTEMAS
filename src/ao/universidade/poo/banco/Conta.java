package ao.universidade.poo.banco;

public class Conta {

    protected String numero;
    protected double saldo;

    public Conta(String numero, double saldoInicial) {

        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Número inválido");
        }

        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        saldo += valor;
    }

    public void sacar(double valor)
            throws SaldoInsuficienteException {

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        if (saldo < valor) {
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente"
            );
        }

        saldo -= valor;
    }

    public void transferir(Conta destino, double valor)
            throws SaldoInsuficienteException {

        sacar(valor);
        destino.depositar(valor);
    }

    @Override
    public String toString() {
        return String.format(
                "Conta %s - Saldo: %.2f",
                numero,
                saldo
        );
    }
}
