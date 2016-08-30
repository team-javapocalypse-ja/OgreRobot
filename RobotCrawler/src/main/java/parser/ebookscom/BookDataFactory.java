package parser.ebookscom;



import javapocalypse.model.BookData;
import parser.BookDataCollector;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ehsan on 25.08.16.
 */
public class BookDataFactory {
    private static BookData.BookDataBuilder builder = BookData.builder();

    /**
     *
     * @param element - Element Type T
     * @param bookDataCollector - Specific {@link BookDataCollector} implemented for type T.
     * @return
     *          <ul>
     *              <li>
     *                  {@link BookData} - in valid situation
     *              </li>
     *              <li>
     *                  null - Otherwise
     *              </li>
     *          </ul>
     *
     */
    private static <T> BookData prepareBookData(T element, BookDataCollector<T> bookDataCollector, String tag) {
        return builder
                .title(bookDataCollector.titleFrom(element))
                .author(bookDataCollector.authorFrom(element))
                .description(bookDataCollector.descriptionFrom(element))
                .price(bookDataCollector.priceFrom(element))
                .url(bookDataCollector.urlFrom(element))
                .library(bookDataCollector.libraryFrom(element))
                .tag(tag)
                .build();
    }

    /**
     *  This method works per tag, if you already have your that is the list of type T you may implement another method.
     * @param elements - the list of elements that returned parsed by {@link parser.Parser}
     * @param bookDataCollector - the implemented collector for specific {@link parser.Parser}
     * @param tag - the list has a tag for example art, IT, music
     * @return {@link List} - List of {@link BookData}, the bookData is collected by specific {@link BookDataCollector}
     */
    public static <T>
    List<BookData> newListBookData(List<T> elements, BookDataCollector<T> bookDataCollector, String tag){
        if(elements==null || bookDataCollector ==null){
            throw new IllegalArgumentException();
        }
        return elements.stream().map(e->
                prepareBookData(e, bookDataCollector, tag))
                .filter(e->!e.equals(null))
                .collect(Collectors.toList());
    }
}
