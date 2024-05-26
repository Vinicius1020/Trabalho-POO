public class ContaCorrente extends Conta implements Tributavel {

    public ContaCorrente(String titular, int numero, String agencia, double saldo) {
        super(titular, numero, agencia, saldo);
    }

    @Override
    public double getValorImposto() {
        return getSaldo() * 0.01;
    }

    @Override
    public void imprimeDados() {
        super.imprimeDados();
        System.out.println("Imposto: " + getValorImposto());
    }
}

