package com.sun.controller;

import com.sun.domain.Book;
import com.sun.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/books")
// @RestController = @Controller + @ResponseBody
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getBookById(@PathVariable("id") Integer id) {
        Book book = bookService.getBookById(id);
//        int temp = 1/0;
//        System.out.println(temp);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String msg = book != null ? "查询成功" : "数据查询失败，请联系后端！";
        return new Result(code, book, msg);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Result getAllBook() {
        List<Book> books = bookService.getAllBook();
        Integer code = books != null ? Code.GET_OK : Code.GET_ERR;
        String msg = books != null ? "查询成功" : "数据查询失败，请联系后端！";
        return new Result(code, books, msg);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteBook(@PathVariable("id") Integer id) {
        boolean flag = bookService.deleteBook(id);
        Integer code = flag ? Code.DELETE_OK : Code.DELETE_ERR;
        String msg = flag ? "删除成功" : "删除失败，请联系后端！";
        return new Result(code, msg);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Result updateBook(@RequestBody Book book) {
        boolean flag = bookService.updateBook(book);
        Integer code = flag ? Code.UPDATE_OK : Code.UPDATE_ERR;
        String msg = flag ? "修改成功" : "修改失败，请联系后端！";
        return new Result(code, book, msg);
    }


//    @RequestMapping(method = RequestMethod.POST)
//    public boolean addBook(@RequestParam("type") String type, @RequestParam("name") String name, @RequestParam("description") String description) {
//        Book book = new Book(null, type, name, description);
//        boolean flag = bookService.addBook(book);
//        System.out.println("addBook:" + book.toString());
//        return flag;
//    }

    @RequestMapping(method = RequestMethod.POST)
    public Result addBook(@RequestBody Book book) {
        boolean flag = bookService.addBook(book);
        Integer code = flag ? Code.ADD_OK : Code.ADD_ERR;
        String msg = flag ? "添加成功" : "添加失败";
        return new Result(code, book, msg);
    }

}
