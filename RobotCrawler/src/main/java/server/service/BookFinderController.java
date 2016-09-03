package server.service;


import model.BookData;
import model.EBookCategory;
import model.response.OffersRequestResponse;
import model.response.RequestResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import robot.ebooks.EBooksRobotManager;


import java.util.EnumMap;
import java.util.List;

@RestController
@RequestMapping("/robot")
public class BookFinderController {

    @Autowired
    @Qualifier("ebooks-robot-manager")
    protected EBooksRobotManager robot;

    @RequestMapping(value = "/find/{categories}")
    public RequestResponseBase serve(@PathVariable("categories")List<EBookCategory> categories){

        categories.forEach(category -> robot.addTask(category));

        robot.startLookingForOffers();
        RequestResponseBase<EnumMap<EBookCategory, List<BookData>>> response = new OffersRequestResponse();
        response.setResult(robot.getOffers(categories));
        return response;
    }

}
