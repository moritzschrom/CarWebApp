package co.schrom.CarWebApp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class CarRepositoryTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper om;


	@SneakyThrows
	@Test
	public void getAll() {
		// Arrange & Act
		var requestBuilder = MockMvcRequestBuilders
			.get("/resources/cars")
			.accept(MediaType.APPLICATION_JSON);

		var response = mockMvc
			.perform(requestBuilder)
			.andReturn().getResponse();

		var jsonString = response.getContentAsString();
		var cars = om.readValue(
				jsonString,
				new TypeReference<List<Car>>() {}
		);

		// Assert
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertThat(response.getContentType()).containsIgnoringCase(MediaType.APPLICATION_JSON_VALUE);
		assertEquals(2, cars.size());
	}

}
