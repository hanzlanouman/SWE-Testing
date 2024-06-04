package com.example.tdd;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksByAuthor(String author) {
        if(author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        return bookRepository.findAllBooks().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByTitle(String title) {
        if(title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }

        String finalTitle = title.toLowerCase();
        return bookRepository.findAllBooks().stream()
                .filter(book -> book.getTitle().toLowerCase().equals(finalTitle))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksByTitleAndAuthor(String title, String author) {
        if (title == null || title.isEmpty() || author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Title and Author cannot be null or empty");
        }

        return bookRepository.findAllBooks().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }
}
