package edu.miu.cs545.simplespringbootproject.services.implementations;

import edu.miu.cs545.simplespringbootproject.domain.Book;
import edu.miu.cs545.simplespringbootproject.repositories.BookRepository;
import edu.miu.cs545.simplespringbootproject.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {
    @Override
    public List<Book> getAllBooks() {
        return BookRepository.getAll();
    }

    @Override
    public Book getBook(int id) {
        var list = BookRepository.getAll();
        for(Book item: list) {
            if(item.getId() == id) return item;
        }
        return null;
    }

    @Override
    public List<Book> searchByTitle(String keyword) {
        final String query = keyword.toLowerCase();
        return BookRepository.getAll()
                .stream().filter(
                        b -> b.getTitle()
                                .toLowerCase()
                                .contains(query))
                .toList();
    }

    @Override
    public Book saveBook(Book book) {
        return BookRepository.addOne(book);
    }

    @Override
    public Book deleteBook(int bookId) {
        return BookRepository.deleteBook(bookId);
    }

    @Override
    public Book updateBook(Book book) {
        return BookRepository.updateBook(book);
    }
}
