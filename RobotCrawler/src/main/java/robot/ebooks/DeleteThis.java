package robot.ebooks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by ehsan on 29.08.16.
 */
public class DeleteThis {

    static int counter;

    public static int increment(){
        counter++;
        System.out.println("IIIIII");
        return 0;
    }

    public static void main(String[] args) {
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        System.out.println(myList);
    }

}
