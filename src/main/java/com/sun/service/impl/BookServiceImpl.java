package com.sun.service.impl;

import com.sun.controller.Code;
import com.sun.dao.BookDao;
import com.sun.domain.Book;
import com.sun.exception.BusinessException;
import com.sun.exception.SystemException;
import com.sun.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    // 自动装配， 相当于setBookDao(BookDao bookDao)，将bookdao注入
    private BookDao bookDao;

    public Book getBookById(Integer id) {

        // 模拟异常
        if (id == 1) {
            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR, "服务器访问超时，请重试！");
        }
        try {
            int i = 1/0;
        } catch (Exception e) {
            throw new BusinessException(Code.BUSINESS_ERR, "业务出现异常！");
        }

        return bookDao.getBookById(id);
    }

    public List<Book> getAllBook() {
//        List<Book> books = bookDao.getAllBook();
//        return books;
        return bookDao.getAllBook();
    }

    public boolean addBook(Book book) {
        bookDao.addBook(book);
        return true;
    }

    public boolean deleteBook(Integer id) {
        bookDao.deleteBook(id);
        return true;
    }

    public boolean updateBook(Book book) {
        bookDao.updateBook(book);
        return true;
    }
}
