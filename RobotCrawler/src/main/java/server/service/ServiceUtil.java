package server.service;

import model.response.BooleanRequestResponse;
import model.response.RequestResponseBase;
import org.springframework.web.client.RestTemplate;

final class ServiceUtil {

    private static String URL_SAVE_BOOK_DATA = "http://localhost:8080/repo/";

    private static RestTemplate restTemplate = new RestTemplate();

    private ServiceUtil() {
    }

    public static boolean saveAuthor(RequestResponseBase requestResponseBase){
        return
                restTemplate.postForObject(
                        URL_SAVE_BOOK_DATA, requestResponseBase, BooleanRequestResponse.class)
                        .getResult();
    }

}
