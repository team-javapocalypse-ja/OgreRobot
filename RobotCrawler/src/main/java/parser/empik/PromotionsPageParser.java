package parser.empik;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class PromotionsPageParser {

    private static final String EMPIK_PROMOTIONS_PAGE_URL = "http://www.empik.com/ebooki/promocje";

    private final PageDownloader pageDownloader;

    public PromotionsPageParser(PageDownloader pageDownloader) {
        this.pageDownloader = pageDownloader;
    }

    List<String> extractCategoryPageUrls() {
        Optional<Document> promotionsPage = pageDownloader.downloadPage(EMPIK_PROMOTIONS_PAGE_URL);
        if (!promotionsPage.isPresent()) {
            return new ArrayList<>();
        }

        List<String> categoryPageUrls = promotionsPage.get().getElementsByClass("contentPacket").parallelStream()
                .map(this::extractCategoryPageUrl)
                .collect(Collectors.toList());

        return categoryPageUrls;
    }

    private String extractCategoryPageUrl(Element element) {
        return element.getElementsByClass("boxesHeaderLink").first().absUrl("href");
    }

}
