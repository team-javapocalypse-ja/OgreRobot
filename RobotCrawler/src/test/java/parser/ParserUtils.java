package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ParserUtils {

    public static Document readHtmlFile(String baseUrl, String fileRelativePath) throws Exception {
        String content = new String(Files.readAllBytes(createFileFromRelativePath(fileRelativePath)));
        Document document = Jsoup.parse(content);
        document.setBaseUri(baseUrl);

        return document;
    }

    private static Path createFileFromRelativePath(String relativePath) throws URISyntaxException {
        return Paths.get(ParserUtils.class.getClassLoader().getResource(relativePath).toURI());
    }

}
