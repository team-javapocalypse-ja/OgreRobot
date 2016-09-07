package server.service;

import model.BookData;
import model.response.EBooksResponse;
import model.response.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import model.BookTag;
import robot.ebooks.BookTagUtil;
import robot.ebooks.EBooksRobotManager;

import java.util.EnumMap;
import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookFinderController {

    @Autowired
    protected EBooksRobotManager robot;

    @Autowired
    BookTagUtil util;

    @RequestMapping(value = "/offers/{categories}")
    public ResponseBase serve(@PathVariable("categories")List<BookTag> categories){

       categories.forEach(robot::addTask);

        robot.startLookingForOffers();
        ResponseBase<EnumMap<BookTag, List<BookData>>> response = new EBooksResponse();
        response.setResult(robot.getOffers(categories));
        return null;
    }
}
