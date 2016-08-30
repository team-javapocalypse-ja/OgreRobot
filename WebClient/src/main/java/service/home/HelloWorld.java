package service.home;

import model.BookData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import parser.ebookscom.EBookCategory;
import robot.ebooks.EBooksRobotManager;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/service")
public class HelloWorld {
    protected EBooksRobotManager robot = new EBooksRobotManager();

    @ResponseBody@RequestMapping(method = RequestMethod.GET, path = "/home")
    public Map<EBookCategory, List<BookData>> getData(@RequestParam(name = "category") List<EBookCategory> categories) {
        categories.forEach(category -> robot.INeed(category));

        robot.startLookingForOffers();

        return robot.getOffers(categories);
    }
}

