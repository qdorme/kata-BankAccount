package qdo.kata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static qdo.kata.OperationType.DEPOSIT;
import static qdo.kata.OperationType.WITHDRAWAL;

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
		return addOperation(amount, DEPOSIT);
	}

	public Account withdrawMoney(double amount) {
		return addOperation(amount, WITHDRAWAL);
	}

	private Account addOperation(double amount, OperationType type){
		Operation operation = new Operation(type,balance,BigDecimal.valueOf(amount));
		operations.add(operation);
		balance = operation.balanceAfterOperation();
		return this;
	}

	public List<Operation> operations() {
		return operations;
	}
}
