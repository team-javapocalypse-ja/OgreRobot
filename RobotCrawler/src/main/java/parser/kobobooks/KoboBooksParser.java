package parser.kobobooks;

import java.util.List;

public class KoboBooksParser {

    public static final String freeBooksUrl = "/p/free-ebooks";

    private KoboPageDownloader koboPageDownloader;

    public KoboBooksParser(KoboPageDownloader koboPageDownloader) {
        this.koboPageDownloader = koboPageDownloader;
    }

    private static String parseCategoryNameFromUrl(String url) {
        String[] parts = url.split("/");
        return parts[parts.length - 2];
    }

    public static void main(String[] args) {
        KoboPageDownloader koboPageDownloader = new KoboPageDownloader();
        FreeBooksPageParser pageParser = new FreeBooksPageParser(koboPageDownloader);
        FreeBooksCategoryPageParser categoryPageParser = new FreeBooksCategoryPageParser(koboPageDownloader);
        CategoryBooksParser booksParser = new CategoryBooksParser(koboPageDownloader, new KoboBookDataCollector());

        KoboBooksParser parser = new KoboBooksParser(koboPageDownloader);


        List<String> categoriesUrls = pageParser.getFreeBooksCategoriesUrls(freeBooksUrl);
        List<String> booksUrls = categoryPageParser.collectBooksUrls(categoriesUrls.get(0));
        ;

        System.out.println(booksParser.collectBookData(booksUrls));
    }

    private void parse() {

    }
}
