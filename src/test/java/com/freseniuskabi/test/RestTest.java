package com.freseniuskabi.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.freseniuskabi.models.Paciente;

public class RestTest {

	public static final String REST_SERVICE_URI = "http://localhost:8080";

	@Test
	public void testGet() {

		// String URI = REST_SERVICE_URI + "/paciente";

		System.out.println("Testing getPaciente API----------");
		RestTemplate restTemplate = new RestTemplate();
		Paciente paciente = restTemplate.getForObject(REST_SERVICE_URI + "/paciente/1", Paciente.class);
		System.out.println(paciente);

		if (paciente == null) {
			fail("ERROR: Request Not OK");
		}
	}

	@Test
	public void testPost() {

		String URI = REST_SERVICE_URI + "/paciente";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		RestTemplate restTemplate = new RestTemplate();
		Paciente pacientePre = new Paciente("Sarah", "234");
		HttpEntity<Paciente> entity = new HttpEntity<>(pacientePre, headers);
		Paciente paciente;
		try {
			ResponseEntity<Paciente> response = restTemplate.exchange(URI, HttpMethod.POST, entity, Paciente.class);
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				paciente = response.getBody();
			} else {
				fail("Post not ok");
			}
		} catch (HttpClientErrorException httpException) {

			System.err.println("Didn't post Paciente good" + httpException);
			fail("Didn't post Paciente good");
		}

	}

	@Test
	public void getAll() {
		String URI = REST_SERVICE_URI + "/paciente";
		RestTemplate restTemplate = new RestTemplate();

		// ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(URI, Object[].class);
		ResponseEntity<List<Paciente>> responseEntity = restTemplate.exchange(URI, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Paciente>>() {
				});

		List<Paciente> list = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();

		System.out.println(list);

		if (statusCode != HttpStatus.OK) {
			fail("ERROR: Request Not OK");
		}

		if (list.isEmpty()) {
			fail("ERROR: There are no Pacientes");
		}
	}

}
