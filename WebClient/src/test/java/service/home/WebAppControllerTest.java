package service.home;

import model.BookData;
import model.EBookCategory;
import model.response.EBooksResponse;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;

public class WebAppControllerTest {

    /**
     * I wrote this test to avoid unexpected changes on the controller.
     * Because my feature depends on this logic and the developer that changes
     * the controller will be informed if the test will not pass.
     */
    @Test
    public void testTheResponse(){

        WebAppController webAppController = new WebAppController();
        webAppController.restTemplate = mock(RestTemplate.class);

        BookData bookData = mock(BookData.class);
        EBooksResponse response = new EBooksResponse();

        EnumMap<EBookCategory, List<BookData>> retMap = new EnumMap<EBookCategory, List<BookData>>(EBookCategory.class);
        List<BookData> bookDataList = new LinkedList<>();
        bookDataList.add(bookData);

        retMap.put(EBookCategory.art, bookDataList);

        response.setResult(retMap);
        when(webAppController.restTemplate.getForObject(anyString(), any()))
                .thenReturn(response);

        assertTrue(webAppController.getData("")==response);
    }

}
