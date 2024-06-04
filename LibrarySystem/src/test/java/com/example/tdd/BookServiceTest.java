package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        //IBookRepository bookRepository = new BookRepository();
        IBookRepository bookRepository = new FakeRepositoryForTest();
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testGetBooksByAuthor() {
        List<Book> books = bookService.getBooksByAuthor("Kent Beck");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthor_MultipleBooks() {
        List<Book> books = bookService.getBooksByAuthor("Robert C. Martin");
        Assertions.assertTrue(books.size() > 1);

    }

//    Test case for getBooksByAuthor method when author is null
    @Test
    public void testGetBooksByAuthor_NullAuthor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bookService.getBooksByAuthor(null);
        });
    }


    @Test
    public void testGetBooksByAuthor_NoBooksFound() {
        List<Book> books = bookService.getBooksByAuthor("Unknown Author");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByAuthor_CaseInsensitive() {
        List<Book> books = bookService.getBooksByAuthor("kent beck");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    // 5th test case for getBooksByAuthor method when author is empty
    @Test
    public void testGetBooksByAuthor_EmptyAuthor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bookService.getBooksByAuthor("");
        });
    }

//  5  Test cases for getBooksByTitle method
    @Test
    public void testGetBooksByTitle() {
        List<Book> books = bookService.getBooksByTitle("Test Driven Development");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Kent Beck", books.get(0).getAuthor());
    }

    @Test
    public void testGetBooksByTitle_MultipleBooks() {
        List<Book> books = bookService.getBooksByTitle("Refactoring");
        Assertions.assertTrue(books.size() > 1);
    }

    @Test
    public void testGetBooksByTitle_NoBooksFound() {
        List<Book> books = bookService.getBooksByTitle("Unknown Title");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitle_EmptyTitle() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bookService.getBooksByTitle("");
        });
    }

    @Test
    public void testGetBooksByTitle_CaseInsensitive() {
        List<Book> books = bookService.getBooksByTitle("clean code");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Robert C. Martin", books.get(0).getAuthor());
    }

    // 5th test case for getBooksByTitle method when title is null
    @Test
    public void testGetBooksByTitle_NullTitle() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bookService.getBooksByTitle(null);
        });
    }

    // 5 Test cases for getBooksByTitleAndAuthor method
    @Test
    public void testGetBooksByTitleAndAuthor() {
        List<Book> books = bookService.getBooksByTitleAndAuthor("Refactoring", "Martin Fowler");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Refactoring", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByTitleAndAuthor_NoBooksFound() {
        List<Book> books = bookService.getBooksByTitleAndAuthor("Unknown Title", "Unknown Author");
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBooksByTitleAndAuthor_EmptyTitle() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bookService.getBooksByTitleAndAuthor("", "Martin Fowler");
        });
    }

    @Test
    public void testGetBooksByTitleAndAuthor_EmptyAuthor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bookService.getBooksByTitleAndAuthor("Refactoring", "");
        });
    }

    @Test
    public void testGetBooksByTitleAndAuthor_NullTitle() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bookService.getBooksByTitleAndAuthor(null, "Martin Fowler");
        });
    }

    @Test
    public void testGetBooksByTitleAndAuthor_NullAuthor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bookService.getBooksByTitleAndAuthor("Refactoring", null);
        });
    }

    @Test
    public void testGetBooksByTitleAndAuthor_CaseInsensitive() {
        List<Book> books = bookService.getBooksByTitleAndAuthor("refactoring", "martin fowler");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Refactoring", books.get(0).getTitle());
    }




}
