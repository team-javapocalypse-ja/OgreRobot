package server.service;

import model.BookData;
import model.EBookCategory;
import model.response.EBooksResponse;
import model.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import robot.ebooks.EBooksRobotManager;

import java.util.EnumMap;
import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookFinderController {

    @Autowired
    protected EBooksRobotManager robot;

    @RequestMapping(value = "/offers/{categories}")
    public ResponseBase serve(@PathVariable("categories")List<EBookCategory> categories){

        categories.forEach(robot::addTask);

        robot.startLookingForOffers();
        ResponseBase<EnumMap<EBookCategory, List<BookData>>> response = new EBooksResponse();
        response.setResult(robot.getOffers(categories));
        return response;
    }


}
