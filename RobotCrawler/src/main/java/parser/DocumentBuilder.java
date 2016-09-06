package parser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

@Builder
@AllArgsConstructor
@Log4j2
public class DocumentBuilder {

    private File file;

    private String urlPath;

    public Document buildFromFile() throws IOException {
        return Jsoup.parse(file, null);
    }

    public Document buildFromUrl() throws IOException {
        // TODO Some connections need cookie
        log.debug("Building the document by URL-> [ ".concat(urlPath).concat(" ]"));
        return Jsoup.connect(urlPath).get();
    }
}
