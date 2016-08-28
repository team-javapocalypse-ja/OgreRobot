package service.home;

import model.BookData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import parser.ebookscom.EBookCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehsan on 26.08.16.
 */
@RestController
public class HelloWorld {

    @RequestMapping(method = RequestMethod.GET, path = "/home")
    public List<BookData> getData(@RequestParam(name = "category")EBookCategory category){
        List<BookData> list = new ArrayList<>();
        BookData book = BookData.builder().tag("test").
                title("test").
                url("test").
                library("test").
                author("test").
                description("test").
                price("0").build();

        list.add(book);
        list.add(book);
        list.add(book);
        list.add(book);
        list.add(book);
        list.add(book);
        list.add(book);
        list.add(book);
        return list;
    }

}
