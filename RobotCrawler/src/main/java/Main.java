import parser.empik.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        PageDownloader pageDownloader = new PageDownloader();

        EmpikParser empikParser = new EmpikParser(
                new PromotionsPageParser(pageDownloader),
                new CategoryPageParser(pageDownloader),
                new BookPageParser(pageDownloader));

        empikParser.parse().keySet().stream().forEach(System.out::println);
    }

}
