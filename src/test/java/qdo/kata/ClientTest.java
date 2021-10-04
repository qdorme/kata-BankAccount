package qdo.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ClientTest {

	private Client client;

	@BeforeEach
	public void setUp(){
		this.client = new Client();
	}
	@Test
	public void shouldThrowIllegalArgumentException(){
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> client.deposeMoney(-100));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> client.deposeMoney(0));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> client.withdrawMoney(-100));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> client.withdrawMoney(0));
	}
	@Test
	public void shouldAdjustTheAccountBalanceFromADeposit(){
		client.account().setBalance(314.16);
		assertThat(client.deposeMoney(100).account().balance()).isEqualTo(414.16);
	}
	@Test
	public void shouldAdjustTheAccountBalanceFromAWithdraw(){
		client.account().setBalance(314.16);
		assertThat(client.withdrawMoney(100).account().balance()).isEqualTo(214.16);
	}
}
