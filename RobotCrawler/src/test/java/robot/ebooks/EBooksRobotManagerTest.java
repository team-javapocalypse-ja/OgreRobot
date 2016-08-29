package robot.ebooks;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import parser.ebookscom.EBookCategory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by egolesor on 28.08.16.
 */
public class EBooksRobotManagerTest {

    @Test
    public void fillingTheCategoryListToFind(){
        EBooksRobotManager robot = new EBooksRobotManager();

        robot.INeed(EBookCategory.art);
        robot.INeed(EBookCategory.games);
        robot.INeed(EBookCategory.pets);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(robot.hasToFind(EBookCategory.art));
        softAssert.assertTrue(robot.hasToFind(EBookCategory.games));
        softAssert.assertTrue(robot.hasToFind(EBookCategory.pets));
    }

    @Test
    public void testIfFindOffersAndNotThrowException(){
        EBooksRobotManager robot = new EBooksRobotManager();
        robot.INeed(EBookCategory.art);
        robot.INeed(EBookCategory.education);
        robot.startLookingForOffers();
        robot.getOffers();
    }

}
