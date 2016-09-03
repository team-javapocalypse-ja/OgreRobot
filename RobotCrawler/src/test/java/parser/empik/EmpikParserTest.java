package parser.empik;

import model.BookData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmpikParserTest {

    @Test
    public void groupExtractedBooksByCategory() {
        // given
        PromotionsPageParser promotionsPageParserMock = mock(PromotionsPageParser.class);
        CategoryPageParser categoryPageParserMock = mock(CategoryPageParser.class);

        BookPageParser bookPageParserMock = mock(BookPageParser.class);

        List<BookData> booksData = Arrays.asList(
                BookData.builder().title("Title 1").tag("tag 1").build(),
                BookData.builder().title("Title 2").tag("tag 1").build(),
                BookData.builder().title("Title 3").tag("tag 2").build(),
                BookData.builder().title("Title 4").tag("tag 3").build()
        );
        when(bookPageParserMock.extractBooks(isA(List.class))).thenReturn(booksData);

        EmpikParser empikParser = new EmpikParser(promotionsPageParserMock, categoryPageParserMock, bookPageParserMock);

        // when
        Map<String, List<BookData>> booksByCategory = empikParser.parse();

        // then
        assertThat(booksByCategory.keySet().size()).isEqualTo(3);
        assertThat(booksByCategory.containsKey("tag 1")).isTrue();
        assertThat(booksByCategory.containsKey("tag 2")).isTrue();
        assertThat(booksByCategory.containsKey("tag 3")).isTrue();
        assertThat(booksByCategory.get("tag 1").get(0).title).isEqualTo("Title 1");
        assertThat(booksByCategory.get("tag 1").get(1).title).isEqualTo("Title 2");
        assertThat(booksByCategory.get("tag 2").get(0).title).isEqualTo("Title 3");
        assertThat(booksByCategory.get("tag 3").get(0).title).isEqualTo("Title 4");
    }

    @Test
    public void emptyMapWhenNoBooksWereFound() {
        // given
        PromotionsPageParser promotionsPageParserMock = mock(PromotionsPageParser.class);
        CategoryPageParser categoryPageParserMock = mock(CategoryPageParser.class);

        BookPageParser bookPageParserMock = mock(BookPageParser.class);

        List<BookData> booksData = Arrays.asList();
        when(bookPageParserMock.extractBooks(isA(List.class))).thenReturn(booksData);

        EmpikParser empikParser = new EmpikParser(promotionsPageParserMock, categoryPageParserMock, bookPageParserMock);

        // when
        Map<String, List<BookData>> booksByCategory = empikParser.parse();

        // then
        assertThat(booksByCategory).isEmpty();
    }

}