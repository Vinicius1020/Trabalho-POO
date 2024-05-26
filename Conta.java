public abstract class Conta {
    private String titular;
    private int numero;
    private String agencia;
    private double saldo;

    public Conta(String titular, int numero, String agencia, double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void saca(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente ou valor inválido.");
        }
    }

    public void deposita(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo.");
        }
    }

    public void transfere(Conta destino, double valor) {
        if (destino != null) {
            saca(valor);
            destino.deposita(valor);
        } else {
            throw new IllegalArgumentException("Conta de destino inválida.");
        }
    }

    public void imprimeDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Número: " + numero);
        System.out.println("Agência: " + agencia);
        System.out.println("Saldo: " + saldo);
    }
}
