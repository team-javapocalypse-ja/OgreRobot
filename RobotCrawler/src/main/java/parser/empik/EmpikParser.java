package parser.empik;

import model.BookData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class EmpikParser {

    private final PromotionsPageParser promotionsPageParser;
    private final CategoryPageParser categoryPageParser;
    private final BookPageParser bookPageParser;

    public EmpikParser(
            PromotionsPageParser promotionsPageParser,
            CategoryPageParser categoryPageParser,
            BookPageParser bookPageParser) {
        this.promotionsPageParser = promotionsPageParser;
        this.categoryPageParser = categoryPageParser;
        this.bookPageParser = bookPageParser;
    }

    public Map<String, List<BookData>> parse() {
        List<String> categoryPageUrls = promotionsPageParser.extractCategoryPageUrls();
        List<String> bookPageUrls = categoryPageParser.extractBookPageUrls(categoryPageUrls);
        List<BookData> booksData = bookPageParser.extractBooks(bookPageUrls);

        return booksData.parallelStream().collect(Collector.of(HashMap::new, (map, e) -> {
            if (!map.containsKey(e.tag)) {
                map.put(e.tag, new ArrayList<>());
            }

            map.get(e.tag).add(e);
        }, (m1, m2) -> {
            m2.entrySet().stream().forEach(entry -> {
                if (!m1.containsKey(entry.getKey())) {
                    m1.put(entry.getKey(), new ArrayList<>());
                }
                m1.get(entry.getKey()).addAll(entry.getValue());
            });
            return m1;
        }));
    }

}
