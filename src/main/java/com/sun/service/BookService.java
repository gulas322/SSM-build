package com.sun.service;

import com.sun.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookService {

//    service接口 这里要写一下接口文档，并且对各个接口做一些业务改进，比如删除或者是增加成功要有返回值

    /**
     * 根据书籍ID获取单本图书信息
     *
     * @param id 图书的唯一标识符
     * @return 返回找到的Book对象，如果不存在则返回null
     */
    Book getBookById(Integer id);

    /**
     * 获取所有图书信息
     *
     * @return 包含所有图书的列表，如果列表为空则返回空列表
     */
    List<Book> getAllBook();

    /**
     * 添加一本新书到库存
     *
     * @param book 要添加的Book对象
     * @return 如果添加成功返回true，否则返回false
     */
    boolean addBook(Book book);

    /**
     * 根据书籍ID删除图书
     *
     * @param id 要删除的图书的唯一标识符
     * @return 如果删除成功返回true，否则返回false
     */
    boolean deleteBook(Integer id);

    /**
     * 更新图书信息
     *
     * @param book 包含更新信息的Book对象
     * @return 如果更新成功返回true，否则返回false
     */
    boolean updateBook(Book book);
}
