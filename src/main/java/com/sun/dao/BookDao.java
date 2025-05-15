package com.sun.dao;

import com.sun.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface BookDao {

    // 这里就只写数据库的相关操作，其他的操作都放到service层来写就可以了

    @Select("select * from tbl_book where id = #{id}")
    Book getBookById(Integer id);

    @Select("select * from tbl_book")
    List<Book> getAllBook();

    @Insert("insert into tbl_book values(null,#{type},#{name},#{description})")
    void addBook(Book book);

    @Delete("delete from tbl_book where id = #{id}")
    void deleteBook(Integer id);

    @Update("update tbl_book set type = #{type},name = #{name},description = #{description} where id = #{id}")
    void updateBook(Book book);
}
