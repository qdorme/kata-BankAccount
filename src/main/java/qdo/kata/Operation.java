package qdo.kata;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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

	public String toString(){
		return String.format("%s of %s the %s, the new balance is %s", type.name().toLowerCase(Locale.ENGLISH),
				amount.setScale(2, RoundingMode.CEILING),
				when.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),
				balanceAfterOperation().setScale(2, RoundingMode.CEILING) );
	}
}
