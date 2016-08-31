package robot.ebooks;

import model.EBookCategory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EBooksRobotManagerTest {

    @Test
    public void fillingTheCategoryListToFind(){
        EBooksRobotManager robot = new EBooksRobotManager();

        robot.INeed(EBookCategory.ART);
        robot.INeed(EBookCategory.GAMES);
        robot.INeed(EBookCategory.PETS);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(robot.hasToFind(EBookCategory.ART));
        softAssert.assertTrue(robot.hasToFind(EBookCategory.GAMES));
        softAssert.assertTrue(robot.hasToFind(EBookCategory.PETS));
    }

    @Test
    public void testIfFindOffersAndNotThrowException(){
        EBooksRobotManager robot = new EBooksRobotManager();
        robot.INeed(EBookCategory.ART);
        robot.INeed(EBookCategory.EDUCATION);
        robot.startLookingForOffers();
        robot.getOffers();
    }

}
