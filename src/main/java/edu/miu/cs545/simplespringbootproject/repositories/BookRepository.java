package edu.miu.cs545.simplespringbootproject.repositories;

import edu.miu.cs545.simplespringbootproject.domain.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    static private List<Book> data;

    static {
        data = new ArrayList<>();
        int id = 0;
        data.add(
            Book.builder()
            .id(++id).title("Ce genre de petites choses")
            .isbn("89613401").author("Claire Keegan")
            .publishedDate(LocalDate.of(2020, 11, 4))
            .build()
        );
        data.add(
            Book.builder()
            .id(++id).title("Treacle Walker")
            .isbn("678930441").author("Alan Garner")
            .publishedDate(LocalDate.of(2021, 8, 21))
            .build()
        );
        data.add(
            Book.builder()
            .id(++id).title("The short list")
            .isbn("89613401").author("Linda McKethan")
            .publishedDate(LocalDate.of(2020, 9, 14))
            .build()
        );
        data.add(
            Book.builder()
            .id(++id).title("The Trees")
            .isbn("432678003").author("Percival Everett")
            .publishedDate(LocalDate.of(2021, 2, 15))
            .build()
        );
    }

    static public List<Book> getAll() {
        return data;
    }
}
