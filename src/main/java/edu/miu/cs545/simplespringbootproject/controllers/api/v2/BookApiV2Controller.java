package edu.miu.cs545.simplespringbootproject.controllers.api.v2;

import edu.miu.cs545.simplespringbootproject.domain.Book;
import edu.miu.cs545.simplespringbootproject.services.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v2/books")
public class BookApiV2Controller {
    @Qualifier("bookServiceImplementation")
    final private BookService service;

    public BookApiV2Controller(BookService bookService) {
        this.service = bookService;
    }
    @GetMapping(value = "/")
    public List<Book> getAll() {
        return service.getAllBooks();
    }

    @GetMapping(value = "/{id}")
    public Book getItem(@PathVariable(name = "id") int bookId) {
        Book result = service.getBook(bookId);

        if(result == null) return new Book();
        return result;
    }

    @PostMapping(value = "/add")
    public Book addBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @PutMapping(value = "{id}/update")
    public Book updateBook(@PathVariable(name = "id") int bookId, @RequestBody Book book) {
        book.setId(bookId);
        return service.updateBook(book);
    }

    @DeleteMapping(value = "{id}/delete")
    public Book deleteBook(@PathVariable(name = "id") int bookId) {
        Book deletedBook = service.deleteBook(bookId);
        if(deletedBook == null) return new Book();
        return deletedBook;
    }
}
