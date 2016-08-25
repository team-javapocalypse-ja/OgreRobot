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

    public Document buildFromFile() throws IOException {
        return Jsoup.parse(file, null);
    }
}
