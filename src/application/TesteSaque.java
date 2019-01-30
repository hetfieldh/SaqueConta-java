package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.DomainException;

public class TesteSaque {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Informe os dados da conta");
			System.out.print("Numero: ");
			int numero = sc.nextInt();
			System.out.print("Titular: ");
			sc.nextLine();
			String titular = sc.nextLine();
			System.out.print("Saldo inicial R$: ");
			double saldo = sc.nextDouble();
			System.out.print("Limite de saque R$: ");
			double limiteSaque = sc.nextDouble();

			Conta acc = new Conta(numero, titular, saldo, limiteSaque);

			System.out.println();
			System.out.print("Informe o valor do saque R$: ");
			double montante = sc.nextDouble();

			try {
				acc.saque(montante);
				System.out.println("Saldo atualizado R$: " + String.format("%.2f", acc.getSaldo()));
			} catch (DomainException e) {
				System.out.println("ERRO NO SAQUE: " + e.getMessage());
			}
		
		} catch (InputMismatchException e) {
			System.out.println("O valor digitado é inválido!!!");
		}
		
		sc.close();

	}

}