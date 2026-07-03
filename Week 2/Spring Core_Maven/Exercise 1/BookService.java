package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for Spring to inject the dependency
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayAllBooks() {
        System.out.println("Fetching books from the library...");
        List<String> books = bookRepository.getAllBooks();
        for (String book : books) {
            System.out.println("- " + book);
        }
    }
}