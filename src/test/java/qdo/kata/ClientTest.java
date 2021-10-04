package qdo.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	}
}
