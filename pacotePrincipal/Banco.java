package pacotePrincipal;

import java.util.HashMap;
import java.util.Scanner;

public class Banco {
    public enum DiasDaSemana{
		Domingo,
		Segunda,
		Terca,
		Quarta,
		Quinta,
		Sexta,
		Sabado,
	}
    private static HashMap<Integer, Conta> contas = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        DiasDaSemana dia;
        System.out.println("Qual dia da semana quer? ");
        switch (dia) {
            case 1:
                Banco.DiasDaSemana d1 = DiasDaSemana.Domingo;
                System.out.println("Dia Escolhido: DOMINGO!");
            break;
            case 1:
                Banco.DiasDaSemana d2 = DiasDaSemana.Segunda;
                break;
            case 3:
                 Banco.DiasDaSemana d3 = DiasDaSemana.Terca;
                break;
            case 4:
                 Banco.DiasDaSemana d4 = DiasDaSemana.Quarta;
                break;
            case 5:
                 Banco.DiasDaSemana d5 = DiasDaSemana.Quinta;
                break;
            case 6:
                 Banco.DiasDaSemana d6 = DiasDaSemana.Sexta;
                break;
            case 7:
                 Banco.DiasDaSemana d7 = DiasDaSemana.Sabado;
                break;
            default:
                String DiaSemanal = "Dia inválido";
        int opcao = 0;
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    depositar();
                    break;
                case 3:
                    sacar();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao >= 1 && opcao <= 3);
    }

    public static void criarConta() {
        System.out.println("Digite o número da conta:");
        int numeroConta = sc.nextInt();
        if (contas.containsKey(numeroConta)) {
            System.out.println("Conta já existe!");
        } else {
            Conta novaConta = new Conta(numeroConta);
            contas.put(numeroConta, novaConta);
            System.out.println("Conta criada com sucesso!");
        }
    }

    public static void depositar() {
        System.out.println("Digite o número da conta:");
        int numeroConta = sc.nextInt();
        if (contas.containsKey(numeroConta)) {
            System.out.println("Digite o valor a ser depositado:");
            double valor = sc.nextDouble();
            contas.get(numeroConta).depositar(valor);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public static void sacar() {
        System.out.println("Digite o número da conta:");
        int numeroConta = sc.nextInt();
        if (contas.containsKey(numeroConta)) {
            System.out.println("Digite o valor a ser sacado:");
            double valor = sc.nextDouble();
            if (contas.get(numeroConta).getSaldo() < valor) {
                System.out.println("Saldo insuficiente!");
            } else {
                contas.get(numeroConta).sacar(valor);
                System.out.println("Saque realizado com sucesso!");
            }
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public static class Conta {

        private int numero;
        private double saldo;

        public Conta(int numero) {
            this.numero = numero;
            this.saldo = 0;
        }

        public void depositar(double valor) {
            this.saldo += valor;
        }

        public void sacar(double valor) {
            this.saldo -= valor;
        }

        public int getNumero() {
            return this.numero;
        }

        public double getSaldo() {
            return this.saldo;
        }
    }
}


