package javapocalypse.core.api;

import javapocalypse.common.dto.BookDTO;
import javapocalypse.core.api.mappers.BookMapper;
import javapocalypse.core.model.entities.Book;
import javapocalypse.core.model.repositories.BookRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/books")
public class BooksController {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Inject
    public BooksController(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @RequestMapping(path = "", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<BookDTO> listBooks() {
        return bookMapper.mapToDTOs(bookRepository.findAll());
    }

    @RequestMapping(path = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<BookDTO> createBooks(@RequestBody List<BookDTO> bookDTOs) {
        List<Book> books = bookMapper.mapToEntities(bookDTOs);
        bookRepository.save(books);

        return bookMapper.mapToDTOs(books);
    }

}
