package service.home;

import model.BookData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import parser.ebookscom.EBookCategory;
import robot.ebooks.EBooksRobotManager;

import java.util.List;
import java.util.Map;

/**
 * Created by ehsan on 26.08.16.
 */
@RestController
public class HelloWorld {
    protected EBooksRobotManager robot = new EBooksRobotManager();
    @RequestMapping(method = RequestMethod.GET, path = "/home")
    public Map<EBookCategory, List<BookData>> getData(@RequestParam(name = "category")List<EBookCategory> categories){
        categories.forEach(category -> robot.INeed(category));

        robot.startLookingForOffers();

        return robot.getOffers();
    }

}
