package qdo.kata;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public enum OperationType {
	DEPOSIT((balance, amount) -> balance.add(amount)),WITHDRAWAL((balance, amount) -> balance.subtract(amount));

	BiFunction<BigDecimal,BigDecimal,BigDecimal> operation;

	OperationType(BiFunction<BigDecimal,BigDecimal,BigDecimal> operation){
		this.operation = operation;
	}

	public BigDecimal computeBalance(BigDecimal balance,BigDecimal amount){
		return operation.apply(balance,amount);
	}
}
