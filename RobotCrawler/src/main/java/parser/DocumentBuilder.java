package parser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Log4j2
@Builder
@AllArgsConstructor
public class DocumentBuilder {

    private static final String USER_AGENT = "Mozilla";
    private static final int TIMEOUT = 60000;
    private static Connection.Response login;
    private File file;
    private String urlPath;

    public Document buildFromFile() throws IOException {
        log.debug("Parsing file ".concat(file.getAbsolutePath()));
        return Jsoup.parse(file, null);
    }

    public Optional<Document> buildFromUrl() {
        Document document = null;
        try {
            login();
            log.error("Retrieving document from site ".concat(urlPath));
            Jsoup.connect(urlPath)
                    .cookies(login.cookies())
                    .get();
        } catch (IOException e) {
            log.error("");
        }

        return Optional.ofNullable(document);
    }

    private void login() throws IOException {
        log.debug("Creating connection to site ".concat(urlPath));
        login = Jsoup.connect(urlPath)
                .userAgent(USER_AGENT)
                .method(Connection.Method.POST).timeout(TIMEOUT)
                .execute();
    }
}



