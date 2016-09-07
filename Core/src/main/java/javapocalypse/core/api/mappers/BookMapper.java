package javapocalypse.core.api.mappers;

import javapocalypse.common.dto.BookDTO;
import javapocalypse.core.model.entities.Book;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.List;

@Component
public class BookMapper {

    private final ModelMapper modelMapper;

    @Inject
    public BookMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Book mapToEntity(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }

    public BookDTO mapToDTO(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    public List<Book> mapToEntities(List<BookDTO> bookDTOs) {
        Type listType = new TypeToken<List<Book>>() {
        }.getType();
        return modelMapper.map(bookDTOs, listType);
    }

    public List<BookDTO> mapToDTOs(List<Book> books) {
        Type listType = new TypeToken<List<BookDTO>>() {
        }.getType();
        return modelMapper.map(books, listType);
    }

}
