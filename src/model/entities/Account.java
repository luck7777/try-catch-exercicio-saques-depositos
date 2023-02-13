package model.entities;

import model.exceptions.DomainException;

public class Account {
	
	private Integer number;
	private String name;
	private Double balance;
	private Double withDrawLimit;
	
	public Account() {		
	}

	public Account(Integer number, String name, Double depositInitial, Double withDrawLimit) {		
		this.number = number;
		this.name = name;
		this.balance = (depositInitial);
		this.withDrawLimit = withDrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWithDrawLimit() {
		return withDrawLimit;
	}

	public void setWithDrawLimit(Double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withDraw(double amount) throws DomainException{
		if(amount > balance) {
			throw new DomainException("Erro no saque: Saldo insuficiente!"); 
		}
		if(amount > withDrawLimit) {
			throw new DomainException("Erro no saque: Valor do saque superior ao limite de saque!");
		}
		balance -= amount;
	}
	
	@Override
	public String toString() {
		return "Saldo atualizado: " + String.format("%.2f", balance);
	}
}
