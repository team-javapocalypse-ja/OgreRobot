package parser.empik;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.jsoup.nodes.Document;
import org.testng.annotations.Test;
import parser.ParserUtils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PromotionsPageParserTest {

    @Test
    public void extractCategoryPageUrls() throws Exception {
        // given
        PageDownloader pageDownloaderMock = mock(PageDownloader.class);
        when(pageDownloaderMock.downloadPage(isA(String.class)))
                .thenReturn(ParserUtils.readHtmlFile("http://www.empik.com/", "empik/promotions-page.html"));

        PromotionsPageParser promotionsPageParser = new PromotionsPageParser(pageDownloaderMock);

        // when
        List<String> categoryPageUrls = promotionsPageParser.extractCategoryPageUrls();

        // then
        assertThat(categoryPageUrls.size()).isEqualTo(1);
        assertThat(categoryPageUrls.get(0)).isEqualTo("http://www.empik.com/ebooki/kryminaly-i-sensacje");
    }

    @Test
    public void extractCategoryPageUrlsWhenPageIsEmpty() {
        // given
        PageDownloader pageDownloaderMock = mock(PageDownloader.class);
        when(pageDownloaderMock.downloadPage(isA(String.class))).thenReturn(Optional.empty());

        PromotionsPageParser promotionsPageParser = new PromotionsPageParser(pageDownloaderMock);

        // when
        List<String> categoryPageUrls = promotionsPageParser.extractCategoryPageUrls();

        // then
        assertThat(categoryPageUrls).isEmpty();
    }


}