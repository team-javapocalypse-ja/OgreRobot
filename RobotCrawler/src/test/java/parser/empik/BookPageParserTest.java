package parser.empik;

import model.BookData;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import parser.ParserUtils;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookPageParserTest {

    @Test
    public void extractBooks() {
        // given
        PageDownloader pageDownloaderMock = mock(PageDownloader.class);
        when(pageDownloaderMock.downloadPage(isA(String.class))).thenReturn(
                ParserUtils.readHtmlFile("http://www.empik.com/uwiklanie-miloszewski-zygmunt,p1046125476,ebooki-i-mp3-p", "empik/book-page-1.html"),
                ParserUtils.readHtmlFile("http://www.empik.com/gniew-miloszewski-zygmunt,p1102035963,ebooki-i-mp3-p", "empik/book-page-2.html")
        );

        BookPageParser bookPageParser = new BookPageParser(pageDownloaderMock);

        // when
        List<BookData> booksData = bookPageParser.extractBooks(Arrays.asList("url-1", "url-2"));

        // then
        assertThat(booksData.size()).isEqualTo(2);

        SoftAssertions softly1 = new SoftAssertions();
        softly1.assertThat(booksData.get(0).title).isEqualTo("Gniew");
        softly1.assertThat(booksData.get(0).author).isEqualTo("Miłoszewski Zygmunt");
        softly1.assertThat(booksData.get(0).library).isEqualTo("Empik");
        softly1.assertThat(booksData.get(0).price).isEqualTo("Current: 21,59 zł, Old: 35,99 zł");
        softly1.assertThat(booksData.get(0).tag).isEqualTo("Kryminał");
        softly1.assertThat(booksData.get(0).url)
                .isEqualTo("http://www.empik.com/gniew-miloszewski-zygmunt,p1102035963,ebooki-i-mp3-p");
        softly1.assertAll();

        SoftAssertions softly2 = new SoftAssertions();
        softly2.assertThat(booksData.get(1).title).isEqualTo("Uwikłanie");
        softly2.assertThat(booksData.get(1).author).isEqualTo("Miłoszewski Zygmunt");
        softly2.assertThat(booksData.get(1).library).isEqualTo("Empik");
        softly2.assertThat(booksData.get(1).price).isEqualTo("Current: 19,19 zł, Old: 31,99 zł");
        softly2.assertThat(booksData.get(1).tag).isEqualTo("Kryminał");
        softly2.assertThat(booksData.get(1).url)
                .isEqualTo("http://www.empik.com/uwiklanie-miloszewski-zygmunt,p1046125476,ebooki-i-mp3-p");
        softly2.assertAll();
    }

}