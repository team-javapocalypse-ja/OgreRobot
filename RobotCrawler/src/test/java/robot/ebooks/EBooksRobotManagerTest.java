package robot.ebooks;

import model.BookTag;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EBooksRobotManagerTest {

    @Test
    public void fillingTheCategoryListToFind(){
        EBooksRobotManager robot = new EBooksRobotManager();

        robot.addTask(BookTag.BIOGRAPHY);
        robot.addTask(BookTag.EDUCATION);
        robot.addTask(BookTag.CRIMINAL);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(robot.hasToFind(BookTag.BIOGRAPHY));
        softAssert.assertTrue(robot.hasToFind(BookTag.EDUCATION));
        softAssert.assertTrue(robot.hasToFind(BookTag.CRIMINAL));
    }

    @Test
    public void testIfFindOffersAndNotThrowException(){
        EBooksRobotManager robot = new EBooksRobotManager();
        robot.addTask(BookTag.BIOGRAPHY);
        robot.addTask(BookTag.EDUCATION);
        robot.startLookingForOffers();
        robot.getOffers();
    }

}
