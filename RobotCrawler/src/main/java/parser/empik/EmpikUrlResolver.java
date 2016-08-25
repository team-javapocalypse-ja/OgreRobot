package parser.empik;

import java.net.URI;
import java.net.URISyntaxException;

class EmpikUrlResolver {

    static String resolveUrl(String url) {
        URI empikUri = null;
        try {
            empikUri = new URI("http://empik.com/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return empikUri.resolve(url).toString();
    }

}
