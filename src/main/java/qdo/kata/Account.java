package qdo.kata;

public class Account {
	private double balance;

	public double balance() {
		return balance;
	}

	public Account setBalance(double balance) {
		this.balance = balance;
		return this;
	}
}
