package edu.miu.cs545.simplespringbootproject.services;

import edu.miu.cs545.simplespringbootproject.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();
    Book getBook(int id);
    List<Book> searchByTitle(String keyword);
}
