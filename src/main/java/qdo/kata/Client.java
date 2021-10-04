package qdo.kata;

public class Client {

	private final Account account;

	public Client(){
		this.account = new Account();
	}

	public Client deposeMoney(double amount) {
		if (amount < 0.01)
			throw new IllegalArgumentException("The amount of a deposit has to be at least 0.01");
		account.deposeMoney(amount);
		return this;
	}

	public Account account(){
		return account;
	}

	public Client withdrawMoney(double amount) {
		if (amount < 0.01)
			throw new IllegalArgumentException("The amount of a withdrawal has to be at least 0.01");
		return this;
	}
}
