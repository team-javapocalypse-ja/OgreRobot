package parser.kobobooks;

import java.util.List;

public class KoboBooksParser {

    public static final String freeBooksUrl = "/p/free-ebooks";

    public static void main(String[] args) {
        KoboPageDownloader koboPageDownloader = new KoboPageDownloader();
        KoboBooksPageParser pageParser = new KoboBooksPageParser(koboPageDownloader);
        KoboBooksCategoryPageParser categoryPageParser = new KoboBooksCategoryPageParser(koboPageDownloader);
        KoboBooksCategoryParser booksParser = new KoboBooksCategoryParser(koboPageDownloader, new KoboBookDataCollector());

        List<String> categoriesUrls = pageParser.getFreeBooksCategoriesUrls(freeBooksUrl);
        List<String> booksUrls = categoryPageParser.collectBooksUrls(categoriesUrls.get(0));

        booksParser.collectBookData(booksUrls).stream().forEach(System.out::println);
    }

    private void parse() {

    }
}
