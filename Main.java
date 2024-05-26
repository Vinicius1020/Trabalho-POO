import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar conta");
            System.out.println("2. Remover conta");
            System.out.println("3. Encontrar conta pelo nome do titular");
            System.out.println("4. Imprimir a lista de todas as contas cadastradas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir a nova linha

            switch (opcao) {
                case 1:
                    cadastrarConta(banco, scanner);
                    break;
                case 2:
                    removerConta(banco, scanner);
                    break;
                case 3:
                    encontrarConta(banco, scanner);
                    break;
                case 4:
                    banco.imprimeContas();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void cadastrarConta(Banco banco, Scanner scanner) {
        System.out.print("Titular: ");
        String titular = scanner.nextLine();
        System.out.print("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // consumir a nova linha
        System.out.print("Agência: ");
        String agencia = scanner.nextLine();
        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine(); // consumir a nova linha
        System.out.print("Tipo de conta (1 - Corrente, 2 - Poupança): ");
        int tipoConta = scanner.nextInt();
        scanner.nextLine(); // consumir a nova linha

        boolean isContaCorrente = tipoConta == 1;
        banco.armazenaConta(titular, numero, agencia, saldo, isContaCorrente);
        System.out.println("Conta cadastrada com sucesso.");
    }

    private static void removerConta(Banco banco, Scanner scanner) {
        System.out.print("Titular da conta a ser removida: ");
        String titular = scanner.nextLine();
        banco.removeConta(titular);
    }

    private static void encontrarConta(Banco banco, Scanner scanner) {
        System.out.print("Titular da conta a ser encontrada: ");
        String titular = scanner.nextLine();
        if (!banco.buscaConta(titular)) {
            System.out.println("Conta não encontrada.");
        }
    }
}
