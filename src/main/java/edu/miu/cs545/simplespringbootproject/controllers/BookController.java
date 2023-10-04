package edu.miu.cs545.simplespringbootproject.controllers;

import edu.miu.cs545.simplespringbootproject.domain.Book;
import edu.miu.cs545.simplespringbootproject.services.BookService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "books")
public class BookController {
    @Qualifier("edu.miu.cs545.simplespringbootproject.services.implementation.BookServiceImplementation")
    final private BookService _bookService;

    public BookController(BookService bookService) {
        this._bookService = bookService;
    }

    @GetMapping(value = "/")
    public String getAll(Model model) {
        model.addAttribute(
                "books", _bookService.getAllBooks()
        );
        return "book/list";
    }

    @GetMapping(value = "/{id}/details")
    public String getItem(Model model, @PathVariable(name = "id") int bookId) {
        Book book = _bookService.getBook(bookId);
        if(book == null) return "book/not-found";

        model.addAttribute("book", book);
        return "book/item";
    }

    @GetMapping(value = "/search")
    public String getResult(Model model, @RequestParam(name = "q") String keyword) {
        model.addAttribute("books", _bookService.searchByTitle(keyword));
        model.addAttribute("keyword", keyword);
        return "book/search";
    }
}
