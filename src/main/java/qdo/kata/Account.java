package qdo.kata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
	private BigDecimal balance;
	private final List<Operation> operations;

	public Account(){
		this.operations = new ArrayList();
	}

	public double balance(){
		return balance.setScale(2).doubleValue();
	}

	public Account setBalance(double balance) {
		this.balance = BigDecimal.valueOf(balance);
		return this;
	}

	public Account deposeMoney(double amount) {
		Operation operation = new Operation(OperationType.DEPOSIT,balance,BigDecimal.valueOf(amount));
		operations.add(operation);
		balance = operation.balanceAfterOperation();
		return this;
	}

	public Account withdrawMoney(double amount) {
		Operation operation = new Operation(OperationType.WITHDRAWAL,balance,BigDecimal.valueOf(amount));
		operations.add(operation);
		balance = operation.balanceAfterOperation();
		return this;
	}

	public List<Operation> operations() {
		return operations;
	}
}
