package com.example.tdd;

import java.util.List;

public class FakeRepositoryForTest implements IBookRepository{
    public static List<Book> booksList = List.of(
            new Book("1", "Test Driven Development", "Kent Beck", 20.0f),
            new Book("2", "Clean Code", "Robert C. Martin", 30.0f),
            new Book("5", "Clean Code 2.0", "Robert C. Martin", 30.0f),
            new Book("3", "Effective Java", "Joshua Bloch", 40.0f),
            new Book("7", "Effective Java", "Joshua Bloch", 40.0f),
            new Book("4", "Refactoring", "Martin Fowler", 50.0f),
            new Book("6", "Refactoring", "Malcolm X", 50.0f)


    );

    @Override
    public List<Book> findAllBooks() {
        return booksList;
    }
}
