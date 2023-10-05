package edu.miu.cs545.simplespringbootproject.repositories;

import edu.miu.cs545.simplespringbootproject.domain.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {
    static private Map<Integer, Book> data;
    static private int pointer;

    static {
        data = new HashMap<>();
        pointer = 0;
        data.put(
                ++pointer,
            Book.builder()
            .id(pointer).title("Ce genre de petites choses")
            .isbn("89613401").author("Claire Keegan")
            .publishedDate(LocalDate.of(2020, 11, 4))
            .build()
        );
        data.put(
            ++pointer,
            Book.builder()
            .id(pointer).title("Treacle Walker")
            .isbn("678930441").author("Alan Garner")
            .publishedDate(LocalDate.of(2021, 8, 21))
            .build()
        );
        data.put(
            ++pointer,
            Book.builder()
            .id(pointer).title("The short list")
            .isbn("89613401").author("Linda McKethan")
            .publishedDate(LocalDate.of(2020, 9, 14))
            .build()
        );
        data.put(
            ++pointer,
            Book.builder()
            .id(pointer).title("The Trees")
            .isbn("432678003").author("Percival Everett")
            .publishedDate(LocalDate.of(2021, 2, 15))
            .build()
        );
    }

    static public List<Book> getAll() {
        return data.values().stream().toList();
    }

    static public Book addOne(Book b) {
        b.setId(++pointer);
        data.put(pointer, b);
        return b;
    }

    static public Book updateBook(Book b) {
        if(!data.containsKey(b.getId())) {
            b.setId(++pointer);
            data.put(pointer, b);
        } else data.put(b.getId(), b);
        return b;
    }

    static public Book deleteBook(int bookId) {
        return data.remove(bookId);
    }
}
