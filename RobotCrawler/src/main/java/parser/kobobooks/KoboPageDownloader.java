package parser.kobobooks;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class KoboPageDownloader {

    private static final String baseUrl = "https://store.kobobooks.com";
    private static Connection.Response login;

    public Optional<Document> getDocument(String additionalUrl) {
        Document document = null;
        try {
            if(Objects.isNull(login)) {login();}
            document = Jsoup.connect(baseUrl.concat(additionalUrl))
                    .cookies(login.cookies())
                    .get();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(document);
    }

    private void login() throws IOException {
        login = Jsoup.connect(baseUrl)
                .userAgent("Mozilla")
                .method(Connection.Method.POST)
                .execute();
    }

}
