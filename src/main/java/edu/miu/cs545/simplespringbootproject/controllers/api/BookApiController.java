package edu.miu.cs545.simplespringbootproject.controllers.api;

import edu.miu.cs545.simplespringbootproject.domain.Book;
import edu.miu.cs545.simplespringbootproject.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookApiController {
    final private BookService _bookService;
    public BookApiController(BookService bookService) {
        this._bookService = bookService;
    }
    @GetMapping(value = "list")
    public List<Book> getAll() {
        return _bookService.getAllBooks();
    }
}
