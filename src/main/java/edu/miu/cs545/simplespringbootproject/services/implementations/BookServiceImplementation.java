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
}
