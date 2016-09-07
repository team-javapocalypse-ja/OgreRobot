package robot;

import model.BookData;
import model.BookTag;

import java.util.EnumMap;
import java.util.List;

public interface Robot {
    EnumMap<BookTag, List<BookData>> getAllOffers();
}
