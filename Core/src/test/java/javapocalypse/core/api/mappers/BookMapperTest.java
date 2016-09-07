package javapocalypse.core.api.mappers;

import javapocalypse.common.dto.BookDTO;
import javapocalypse.core.api.config.ModelMapperConfiguration;
import javapocalypse.core.model.entities.Book;
import javapocalypse.core.model.entities.Library;
import org.assertj.core.api.SoftAssertions;
import org.modelmapper.ModelMapper;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class BookMapperTest {

    @Test
    public void mapDTOToEntity() {
        // given
        BookMapper bookMapper = new BookMapper(createModelMapper());

        BookDTO bookDTO = BookDTO.builder()
                .library("empik_com")
                .title("title")
                .authors("authors")
                .description("description")
                .oldPrice("321")
                .newPrice("123")
                .tag("tag")
                .build();

        // when
        Book book = bookMapper.mapToEntity(bookDTO);

        // then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(book.getLibrary()).isEqualTo(Library.EMPIK_COM);
        softAssertions.assertThat(book.getTitle()).isEqualTo("title");
        softAssertions.assertThat(book.getAuthors()).isEqualTo("authors");
        softAssertions.assertThat(book.getDescription()).isEqualTo("description");
        softAssertions.assertThat(book.getOldPrice()).isEqualTo("321");
        softAssertions.assertThat(book.getNewPrice()).isEqualTo("123");
        softAssertions.assertAll();
    }

    @Test
    public void convertEntityToDTO() {
        // given
        BookMapper bookMapper = new BookMapper(createModelMapper());

        Book book = new Book(Library.EBOOKS_COM, "title", "authors", "description", "321", "123", "tag");

        // when
        BookDTO bookDTO = bookMapper.mapToDTO(book);

        // then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(bookDTO.getLibrary()).isEqualTo("ebooks_com");
        softAssertions.assertThat(bookDTO.getTitle()).isEqualTo("title");
        softAssertions.assertThat(bookDTO.getAuthors()).isEqualTo("authors");
        softAssertions.assertThat(bookDTO.getDescription()).isEqualTo("description");
        softAssertions.assertThat(bookDTO.getOldPrice()).isEqualTo("321");
        softAssertions.assertThat(bookDTO.getNewPrice()).isEqualTo("123");
        softAssertions.assertThat(bookDTO.getTag()).isEqualTo("tag");
        softAssertions.assertAll();
    }

    @Test
    public void convertManyEntitiesToDTOs() {
        // given
        BookMapper bookMapper = new BookMapper(createModelMapper());

        // when
        Book book1 = new Book(Library.EBOOKS_COM, "title 1", "authors 1", "description 1", "3211", "1231", "tag 1");
        Book book2 = new Book(Library.EMPIK_COM, "title 2", "authors 2", "description 2", "3212", "1232", "tag 2");

        List<BookDTO> bookDTOs = bookMapper.mapToDTOs(Arrays.asList(book1, book2));

        // then
        SoftAssertions softAssertions1 = new SoftAssertions();
        softAssertions1.assertThat(bookDTOs.get(0).getLibrary()).isEqualTo("ebooks_com");
        softAssertions1.assertThat(bookDTOs.get(0).getTitle()).isEqualTo("title 1");
        softAssertions1.assertThat(bookDTOs.get(0).getAuthors()).isEqualTo("authors 1");
        softAssertions1.assertThat(bookDTOs.get(0).getDescription()).isEqualTo("description 1");
        softAssertions1.assertThat(bookDTOs.get(0).getOldPrice()).isEqualTo("3211");
        softAssertions1.assertThat(bookDTOs.get(0).getNewPrice()).isEqualTo("1231");
        softAssertions1.assertThat(bookDTOs.get(0).getTag()).isEqualTo("tag 1");
        softAssertions1.assertAll();

        SoftAssertions softAssertions2 = new SoftAssertions();
        softAssertions2.assertThat(bookDTOs.get(1).getLibrary()).isEqualTo("empik_com");
        softAssertions2.assertThat(bookDTOs.get(1).getAuthors()).isEqualTo("authors 2");
        softAssertions2.assertThat(bookDTOs.get(1).getDescription()).isEqualTo("description 2");
        softAssertions2.assertThat(bookDTOs.get(1).getOldPrice()).isEqualTo("3212");
        softAssertions2.assertThat(bookDTOs.get(1).getNewPrice()).isEqualTo("1232");
        softAssertions2.assertThat(bookDTOs.get(1).getTag()).isEqualTo("tag 2");
        softAssertions2.assertAll();
    }

    @Test
    public void convertManyDTOsToEntities() {
        // given
        BookMapper bookMapper = new BookMapper(createModelMapper());

        // when
        BookDTO bookDTO1 = BookDTO.builder()
                .library("empik_com")
                .title("title 1")
                .authors("authors 1")
                .description("description 1")
                .oldPrice("3211")
                .newPrice("1231")
                .tag("tag 1")
                .build();

        BookDTO bookDTO2 = BookDTO.builder()
                .library("ebooks_com")
                .title("title 2")
                .authors("authors 2")
                .description("description 2")
                .oldPrice("3212")
                .newPrice("1232")
                .tag("tag 2")
                .build();

        List<Book> books = bookMapper.mapToEntities(Arrays.asList(bookDTO1, bookDTO2));

        // then
        SoftAssertions softAssertions1 = new SoftAssertions();
        softAssertions1.assertThat(books.get(0).getLibrary()).isEqualTo(Library.EMPIK_COM);
        softAssertions1.assertThat(books.get(0).getTitle()).isEqualTo("title 1");
        softAssertions1.assertThat(books.get(0).getAuthors()).isEqualTo("authors 1");
        softAssertions1.assertThat(books.get(0).getDescription()).isEqualTo("description 1");
        softAssertions1.assertThat(books.get(0).getOldPrice()).isEqualTo("3211");
        softAssertions1.assertThat(books.get(0).getNewPrice()).isEqualTo("1231");
        softAssertions1.assertAll();

        SoftAssertions softAssertions2 = new SoftAssertions();
        softAssertions2.assertThat(books.get(1).getLibrary()).isEqualTo(Library.EBOOKS_COM);
        softAssertions2.assertThat(books.get(1).getTitle()).isEqualTo("title 2");
        softAssertions2.assertThat(books.get(1).getAuthors()).isEqualTo("authors 2");
        softAssertions2.assertThat(books.get(1).getDescription()).isEqualTo("description 2");
        softAssertions2.assertThat(books.get(1).getOldPrice()).isEqualTo("3212");
        softAssertions2.assertThat(books.get(1).getNewPrice()).isEqualTo("1232");
        softAssertions2.assertAll();
    }

    private ModelMapper createModelMapper() {
        ModelMapperConfiguration modelMapperConfiguration = new ModelMapperConfiguration();
        return modelMapperConfiguration.getModelMapper();
    }

}