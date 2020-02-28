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
	private static final String AUTHOR_ENDPOINT = "http://localhost:8080/authors";

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

//package com.testtask.rest_service;
//
//import com.testtask.rest_service.model.Author;
//import com.testtask.rest_service.model.Book;
//import com.testtask.rest_service.repositories.AuthorRepository;
//import com.testtask.rest_service.repositories.BookRepository;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Arrays;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = TesttaskApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
//
//public class TesttaskApplicationTests {
//	private static final String BOOK_ENDPOINT = "http://localhost:8080/books";
//	private static final String AUTHOR_ENDPOINT = "http://localhost:8080/authors";
//
//	@Autowired
//	private BookRepository bookRepo;
//
//	@Autowired
//	private AuthorRepository authorRepo;
//
//	@Before
//	public void setup() {
//		if (!bookRepo.findById(1L).isPresent()) {
//			Book book = new Book("Animal Farm", 1945, "");
//			book = bookRepo.save(book);
//			Author author = new Author("George Orwell", 1903);
//			author = authorRepo.save(author);
//			author.setBooks(Arrays.asList(book));
//			author = authorRepo.save(author);
//		}
//	}
//
//	@Test
//	public void whenGetBook_thenOK() {
//		final Response response = RestAssured.get(BOOK_ENDPOINT + "/1");
//
//		assertEquals(200, response.getStatusCode());
//		assertTrue(response.asString().contains("title"));
//		assertFalse(response.asString().contains("authorCount"));
//		// System.out.println(response.asString());
//	}
//
//	@Test
//	public void whenGetBookProjection_thenOK() {
//		final Response response = RestAssured.get(BOOK_ENDPOINT + "/1?projection=customBook");
//
//		assertEquals(200, response.getStatusCode());
//		assertFalse(response.asString().contains("title"));
//		assertTrue(response.asString().contains("authorCount"));
//		// System.out.println(response.asString());
//	}
//
//	@Test
//	public void whenGetAllBooks_thenOK() {
//		final Response response = RestAssured.get(BOOK_ENDPOINT);
//
//		assertEquals(200, response.getStatusCode());
//		assertFalse(response.asString().contains("title"));
//		assertTrue(response.asString().contains("authorCount"));
//		// System.out.println(response.asString());
//	}
//
//	@Test
//	public void whenGetAuthorBooks_thenOK() {
//		final Response response = RestAssured.get(AUTHOR_ENDPOINT + "/1/books");
//
//		assertEquals(200, response.getStatusCode());
//		assertFalse(response.asString().contains("title"));
//		assertTrue(response.asString().contains("authorCount"));
//		System.out.println(response.asString());
//	}
//}