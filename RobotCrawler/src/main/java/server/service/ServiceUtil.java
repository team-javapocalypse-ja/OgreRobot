package server.service;

import model.Author;
import model.response.BooleanResponse;
import org.springframework.web.client.RestTemplate;

final class ServiceUtil {

    private static String URL_SAVE_BOOK_DATA = "http://localhost:8080/repo/";

    private static RestTemplate restTemplate = new RestTemplate();

    private ServiceUtil() {
    }

    public static boolean saveAuthor(Author author){
        return
                restTemplate.postForObject(
                        URL_SAVE_BOOK_DATA,author, BooleanResponse.class)
                        .getResult();
    }

}
