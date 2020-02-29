package com.testtask.rest_service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TesttaskApplicationTests {

	private static final String BOOK_ENDPOINT = "http://localhost:8080/books";

//	@Test
//	public void contextLoads() {
//	}

	@Test
	public void whenGetBook_thenOK() {
		final Response response = RestAssured.get(BOOK_ENDPOINT + "/1");

		assertEquals(200, response.getStatusCode());
		assertTrue(response.asString().contains("title"));
		assertFalse(response.asString().contains("authorCount"));
//		System.out.println(response.asString());
	}

	@Test
	public void whenGetAllBooks_thenOK() {
		final Response response = RestAssured.get(BOOK_ENDPOINT);

		assertEquals(200, response.getStatusCode());
		assertFalse(response.asString().contains("title"));
		assertTrue(response.asString().contains("authorCount"));
		// System.out.println(response.asString());
	}

}
