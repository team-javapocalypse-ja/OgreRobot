package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class ParserUtils {

    public static Optional<Document> readHtmlFile(String baseUrl, String fileRelativePath) {
        try {
            String content = new String(Files.readAllBytes(createFileFromRelativePath(fileRelativePath)));
            Document document = Jsoup.parse(content);
            document.setBaseUri(baseUrl);

            return Optional.of(document);
        } catch (IOException|URISyntaxException ex) {
            return Optional.empty();
        }
    }

    private static Path createFileFromRelativePath(String relativePath) throws URISyntaxException {
        return Paths.get(ParserUtils.class.getClassLoader().getResource(relativePath).toURI());
    }

}
