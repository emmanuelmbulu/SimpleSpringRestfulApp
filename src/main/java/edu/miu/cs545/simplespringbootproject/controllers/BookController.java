package edu.miu.cs545.simplespringbootproject.controllers;

import edu.miu.cs545.simplespringbootproject.domain.Book;
import edu.miu.cs545.simplespringbootproject.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    final private BookService _bookService;
    public BookController(BookService bookService) {
        this._bookService = bookService;
    }
    @GetMapping(value = "list")
    public List<Book> getAll() {
        return _bookService.getAllBooks();
    }
}
