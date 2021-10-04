package qdo.kata;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Operation {
	private final OperationType type;
	private final BigDecimal balanceBeforeOperation;
	private final BigDecimal amount;
	private final LocalDateTime when;

	public Operation(OperationType type, BigDecimal balanceBeforeOperation, BigDecimal amount){
		this.type = type;
		this.balanceBeforeOperation = balanceBeforeOperation;
		this.amount = amount;
		when = LocalDateTime.now();
	}

	public BigDecimal balanceAfterOperation(){
		return type.computeBalance(balanceBeforeOperation, amount);
	}

}
