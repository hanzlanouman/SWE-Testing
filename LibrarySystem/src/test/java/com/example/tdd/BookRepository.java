package com.example.tdd;

import java.util.Arrays;
import java.util.List;

public class BookRepository implements IBookRepository {

    @Override
    public List<Book> findAllBooks() {
        return Arrays.asList(
                new Book("1", "Test Driven Development", "Kent Beck", 20.0f),
                new Book("2", "Clean Code", "Robert C. Martin", 30.0f),
                new Book("3", "Effective Java", "Joshua Bloch", 40.0f),
                new Book("4", "Refactoring", "Martin Fowler", 50.0f),
                new Book("5", "Refactoring 2.0", "Martin Fowler", 50.0f)
        );
    }
}
