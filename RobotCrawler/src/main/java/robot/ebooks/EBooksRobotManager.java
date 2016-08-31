package robot.ebooks;

import model.BookData;
import org.springframework.stereotype.Component;
import parser.ebookscom.EBookCategory;

import java.util.*;
import java.util.concurrent.*;

@Component("ebooks-robot-manager")
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
            service.invokeAll(callableList);//.stream().map(r->r.);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        callableList.forEach(eBooksRobot ->
                tasks.put(eBooksRobot.category, eBooksRobot.theList));

        // TODO zapis do bazy
    }

    public EnumMap<EBookCategory, List<BookData>> getOffers(){
        return tasks.clone();
    }

    public EnumMap<EBookCategory, List<BookData>> getOffers(List<EBookCategory> categoriesINeedNow){
        EnumMap<EBookCategory, List<BookData>> retOffers = new EnumMap<EBookCategory, List<BookData>>(EBookCategory.class);
        categoriesINeedNow.forEach(key->retOffers.put(key, tasks.get(key)));
        return retOffers;
    }
}
