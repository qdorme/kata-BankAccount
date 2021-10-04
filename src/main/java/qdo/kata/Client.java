package qdo.kata;

public class Client {

	public Client deposeMoney(double amount) {
		if (amount < 0.01)
			throw new IllegalArgumentException("The amount of a deposit has to be at least 0.01");
		return this;
	}
}
