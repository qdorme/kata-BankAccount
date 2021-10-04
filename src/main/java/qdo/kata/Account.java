package qdo.kata;

import java.math.BigDecimal;

public class Account {
	private BigDecimal balance;

	public double balance(){
		return balance.setScale(2).doubleValue();
	}

	public Account setBalance(double balance) {
		this.balance = BigDecimal.valueOf(balance);
		return this;
	}

	public Account deposeMoney(double money) {
		balance = balance.add(BigDecimal.valueOf(money));
		return this;
	}

	public Account withdrawMoney(double money) {
		this.balance = balance.subtract(BigDecimal.valueOf(money));
		return this;
	}
}
