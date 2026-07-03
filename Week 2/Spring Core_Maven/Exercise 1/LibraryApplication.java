package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryApplication {
    
    public static void main(String[] args) {
        System.out.println("Starting Library Application...\n");

        // 1. Load the Spring Application Context from the XML file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. Retrieve the fully configured BookService bean
        BookService bookService = context.getBean("bookService", BookService.class);

        // 3. Test the configuration
        bookService.displayAllBooks();
    }
}