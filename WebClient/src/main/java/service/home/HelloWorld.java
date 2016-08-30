package service.home;

import javapocalypse.model.BookData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ehsan on 26.08.16.
 */
@RestController
public class HelloWorld {

    @RequestMapping(method = RequestMethod.GET, path = "/home")
    public BookData getData(){
        return BookData.builder().tag("test").
                title("test").
                url("test").
                library("test").
                author("test").
                description("test").
                price("0").build();
    }

}
