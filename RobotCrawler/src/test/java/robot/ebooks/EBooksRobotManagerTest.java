package robot.ebooks;

import model.EBookCategory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
