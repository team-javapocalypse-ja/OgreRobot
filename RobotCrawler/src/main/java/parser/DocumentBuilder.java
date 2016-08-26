package parser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

@Builder
@AllArgsConstructor
public class DocumentBuilder {

    private File file;

    private String urlPath;

    public Document buildFromFile() throws IOException {
        return Jsoup.parse(file, null);
    }

    public Document buildFromUrl() throws IOException {
        // TODO Some connections need cookie
        return Jsoup.connect(urlPath).get();
    }
}
