import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void armazenaConta(String titular, int numero, String agencia, double saldo, boolean isContaCorrente) {
        Conta novaConta;
        if (isContaCorrente) {
            novaConta = new ContaCorrente(titular, numero, agencia, saldo);
        } else {
            novaConta = new ContaPoupanca(titular, numero, agencia, saldo);
        }
        contas.add(novaConta);
    }

    public void removeConta(String titular) {
        Conta contaParaRemover = null;
        for (Conta conta : contas) {
            if (conta.getTitular().equalsIgnoreCase(titular)) {
                contaParaRemover = conta;
                break;
            }
        }
        if (contaParaRemover != null) {
            contas.remove(contaParaRemover);
        } else {
            System.out.println("Conta não encontrada para o titular: " + titular);
        }
    }

    public boolean buscaConta(String titular) {
        for (Conta conta : contas) {
            if (conta.getTitular().equalsIgnoreCase(titular)) {
                conta.imprimeDados();
                return true;
            }
        }
        System.out.println("Conta não encontrada para o titular: " + titular);
        return false;
    }

    public void imprimeContas() {
        Collections.sort(contas, Comparator.comparing(Conta::getTitular, String.CASE_INSENSITIVE_ORDER));
        for (Conta conta : contas) {
            conta.imprimeDados();
            System.out.println();
        }
    }
}
