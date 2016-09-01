package javapocalypse;

import javapocalypse.config.DatabaseConfiguration;
import javapocalypse.model.Library;
import javapocalypse.model.LibraryCategory;
import javapocalypse.model.Tag;
import javapocalypse.repositories.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

import static org.testng.Assert.assertEquals;

@Transactional
@ContextConfiguration(classes = {DatabaseConfiguration.class})
public class BaseCrudTest extends AbstractTestNGSpringContextTests {

    @Inject
    BookRepository bookRepository;

    @Inject
    LibraryCategoryRepository libraryCategoryRepository;

    @Inject
    LibraryRepository libraryRepository;

    @Inject
    ProfileRepository profileRepository;

    @Inject
    TagRepository tagRepository;

    private LibraryCategory libraryCategory;

    @BeforeMethod
    public void setUp() {
        Tag tag = Tag.builder().name("Kryminal").build();
        tagRepository.save(tag);

        Library library = Library.builder().name("Empik").url("htttp://empik.com").build();
        libraryRepository.save(library);

        libraryCategory = LibraryCategory.builder()
                .library(library)
                .categoryName("Kryminal")
                .tag(tag)
                .build();
        libraryCategoryRepository.save(libraryCategory);
    }

    @AfterMethod
    public void clear() {
        bookRepository.deleteAll();
        libraryCategoryRepository.deleteAll();
        profileRepository.deleteAll();
    }

    @Test
    public void testFindAllLibraryCategories() {
        // given

        // when
        List<LibraryCategory> libraryCategories = libraryCategoryRepository.findAll();
        LibraryCategory expectedLibraryCategory = libraryCategories.stream()
                .filter(libraryCategory -> Objects.nonNull(libraryCategory))
                .findFirst()
                .get();

        // then
        assertEquals(libraryCategory, expectedLibraryCategory);
    }


}
