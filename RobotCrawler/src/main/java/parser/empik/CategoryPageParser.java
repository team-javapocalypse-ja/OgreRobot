package parser.empik;

import org.jsoup.nodes.Element;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CategoryPageParser {

    private final PageDownloader pageDownloader;

    public CategoryPageParser(PageDownloader pageDownloader) {
        this.pageDownloader = pageDownloader;
    }

    List<String> extractBookPageUrls(List<String> categoryPageUrls) {
        List<String> bookPageUrls = categoryPageUrls.parallelStream()
                .map(pageDownloader::downloadPage)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .flatMap(this::extractBookBoxes)
                .map(this::extractBookPageUrl)
                .map(EmpikUrlResolver::resolveUrl)
                .collect(Collectors.toList());

        return bookPageUrls;
    }

    private Stream<Element> extractBookBoxes(Element element) {
        return element.select("div.productBox-450Pic").stream();
    }

    private String extractBookPageUrl(Element element) {
        return element.getElementsByTag("a").first().attr("href");
    }

}
