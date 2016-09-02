package parser.empik;

import org.testng.annotations.Test;
import parser.ParserUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoryPageParserTest {

    @Test
    public void extractBookPageUrls() throws Exception {
        // given
        PageDownloader pageDownloaderMock = mock(PageDownloader.class);
        when(pageDownloaderMock.downloadPage(isA(String.class)))
                .thenReturn(ParserUtils.readHtmlFile("http://empik.com", "empik/category-page.html"));

        CategoryPageParser categoryPageParser = new CategoryPageParser(pageDownloaderMock);

        // when
        List<String> bookPageUrls = categoryPageParser.extractBookPageUrls(Arrays.asList(""));

        // then
        assertThat(bookPageUrls.size()).isEqualTo(40);
        assertThat(bookPageUrls.get(0)).isEqualTo("http://empik.com/uwiklanie-miloszewski-zygmunt,p1046125476,ebooki-i-mp3-p");
    }

}