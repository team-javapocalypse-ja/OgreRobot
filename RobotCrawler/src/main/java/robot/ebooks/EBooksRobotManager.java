package robot.ebooks;

import lombok.extern.log4j.Log4j2;
import model.BookData;
import model.EBookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import model.BookTag;
import robot.BookTagUtil;
import robot.Robot;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Log4j2
@Component("ebooks-robot-manager")
public class EBooksRobotManager implements Robot {

    @Autowired
    BookTagUtil bookTagUtil;

    private EnumMap<BookTag, List<BookData>> tasks =
            new EnumMap<>(BookTag.class);



    public void addTask(BookTag category) {
        if(!tasks.containsKey(category)){
            log.debug("adding ".concat(category.toString()).concat(" to the task"));
            tasks.put(category, new LinkedList<>());
        }
    }

    public boolean hasToFind(BookTag category) {
        return tasks.containsKey(category);
    }

    public void startLookingForOffers() {
        ExecutorService service = Executors.newWorkStealingPool();
        List<EBooksRobot> callableList = new ArrayList<>();

        // adding the callable
        log.debug(tasks.size() + " Callables will be invoked");
        tasks.forEach((category, bookData) ->
                callableList.add(new EBooksRobot(category, bookTagUtil)));

        // execute all callables
        try {
            service.invokeAll(callableList);
            log.debug("callables finished work");
            service.shutdownNow();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

        callableList.forEach(eBooksRobot ->
                tasks.put(eBooksRobot.category, eBooksRobot.theList));


        // TODO zapis do bazy
    }

    public EnumMap<BookTag, List<BookData>> getOffers(){
        return tasks.clone();
    }

    public EnumMap<BookTag, List<BookData>> getOffers(List<BookTag> categoriesINeedNow){

        EnumMap<BookTag, List<BookData>> retOffers = new EnumMap<>(BookTag.class);
        categoriesINeedNow.forEach(key->retOffers.put(key, tasks.get(key)));
        return retOffers;
    }

    public EnumMap<BookTag, List<BookData>> getAllOffers(){

        bookTagUtil.allTags().forEach(this::addTask);
        startLookingForOffers();

        return tasks;
    }

}
