package com.sun.service;

import com.sun.config.SpringConfig;
import com.sun.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testGetBookById() {
        Book book = bookService.getBookById(1);
        System.out.println(book);
    }

    @Test
    public void testGetAllBook() {
        List<Book> books = bookService.getAllBook();
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }

    @Test
    public void testAddBook() {
        Book book = new Book(null, "测试", "测试", "测试");
        bookService.addBook(book);
        System.out.println("addBook:" + book.toString());
    }

    @Test
    public void testDeleteBook() {
        bookService.deleteBook(1);
        System.out.println("deleteBook执行成功");
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book(1, "测试", "测试", "测试");
        bookService.updateBook(book);
        System.out.println("updateBook:" + book.toString());
    }
}
