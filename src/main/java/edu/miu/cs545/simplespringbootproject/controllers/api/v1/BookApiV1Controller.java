package edu.miu.cs545.simplespringbootproject.controllers.api.v1;

import edu.miu.cs545.simplespringbootproject.domain.Book;
import edu.miu.cs545.simplespringbootproject.repositories.BookRepository;
import edu.miu.cs545.simplespringbootproject.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/books")
public class BookApiV1Controller {
    @Qualifier("bookServiceImplementation")
    final private BookService service;

    public BookApiV1Controller(BookService bookService) {
        this.service = bookService;
    }
    @GetMapping(value = "/")
    public Object getAll() {
        return new Object(){
            public final String version = "Version 1.0";
            final public String date = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
            final public List<Book> books = service.getAllBooks();
        };
    }

    @GetMapping(value = "/{id}")
    public Object getItem(@PathVariable(name = "id") int bookId) {
        Book result = service.getBook(bookId);

        if(result == null) {
            return new Object() {
                final public String version = "Version 1.0";
                final public String date = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
                final public int code = 1;
                final public String message = "Book not found!";
            };
        }

        return new Object(){
            final public String version = "Version 1.0";
            final public String date = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
            final public int code = 0;
            final public String message = "Book found!";
            final public Book book = result;
        };
    }

    @PostMapping(value = "/add")
    public Object addBook(@RequestBody Book book) {
        Book result = service.saveBook(book);
        return new Object(){
            final public String version = "Version 1.0";
            final public String date = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
            final public int code = 0;
            final public String message = "Added successfully!";
            final public Book book = result;
        };
    }

    @PutMapping(value = "{id}/update")
    public Object updateBook(@PathVariable(name = "id") int bookId, @RequestBody Book book) {
        book.setId(bookId);
        Book result = service.updateBook(book);
        return new Object(){
            final public String version = "Version 1.0";
            final public String date = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
            final public int code = 0;
            final public String message = "Updated successfully!";
            final public Book book = result;
        };
    }

    @DeleteMapping(value = "{id}/delete")
    public Object deleteBook(@PathVariable(name = "id") int bookId) {
        Book deletedBook = service.deleteBook(bookId);
        if(deletedBook == null) {
            return new Object() {
                final public String version = "Version 1.0";
                final public String date = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
                final public int code = 1;
                final public String message = "Book not found!";
            };
        }

        return new Object(){
            final public String version = "Version 1.0";
            final public String date = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
            final public int code = 0;
            final public String message = "Deleted successfully!";
            final public Book book = deletedBook;
        };
    }
}
