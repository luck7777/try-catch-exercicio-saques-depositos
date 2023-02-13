package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Digite os dados da conta:");
			System.out.print("Numero: ");
			int number = sc.nextInt();
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Valor inicial da Conta: $ ");
			double depositInitial = sc.nextDouble();
			System.out.print("Digite o limite de saque: $ ");
			double withDrawLimit = sc.nextDouble();
			
			Account account = new Account(number, name, depositInitial, withDrawLimit);
			
			System.out.println();
			System.out.print("Digite o valor para saque: $ ");
			double withDrawvalue = sc.nextDouble();
			account.withDraw(withDrawvalue);
			System.out.println(account);
		}
		catch(DomainException msg) {
			System.out.println(msg.getMessage());
		}
		catch (NullPointerException msg) {
		System.out.println("Valor digitado é um valor invalido!");
		}
		sc.close();
	}
}
