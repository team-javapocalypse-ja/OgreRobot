package robot.ebooks;

import model.BookData;
import parser.ebookscom.EBookCategory;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by egolesor on 28.08.16.
 */
public class EBooksRobotManager {

    private EnumMap<EBookCategory, List<BookData>> tasks =
            new EnumMap<EBookCategory, List<BookData>>(EBookCategory.class);

    public void INeed(EBookCategory category) {
        if(!tasks.containsKey(category)){
            tasks.put(category, new LinkedList<>());
        }
    }

    public boolean hasToFind(EBookCategory category) {
        return tasks.containsKey(category);
    }

    public void startLookingForOffers() {
        ExecutorService service = Executors.newWorkStealingPool();
        List<EBooksRobot> callableList = new ArrayList<>();

        // adding the callable
        tasks.forEach((category, bookData) ->
                callableList.add(new EBooksRobot(category)));

        // execute all callables
        try {
            // List<Future<List<model.BookData>>>
            service.invokeAll(callableList);//.stream().map(r->r.);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        callableList.forEach(eBooksRobot ->
                tasks.put(eBooksRobot.category, eBooksRobot.theList));

    }

    public EnumMap<EBookCategory, List<BookData>> getOffers(){
        return tasks.clone();
    }
}
