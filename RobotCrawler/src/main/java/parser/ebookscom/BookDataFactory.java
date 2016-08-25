package parser.ebookscom;



import model.BookData;
import parser.BookDataGetter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ehsan on 25.08.16.
 */
public class BookDataFactory {
    private static BookData.BookDataBuilder builder = BookData.builder();

    /**
     *
     * @param element
     * @param bookDataGetter
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
    private static <T> BookData prepareBookData(T element, BookDataGetter<T> bookDataGetter, String tag) {
        return builder
                .title(bookDataGetter.getTitle(element))
                .author(bookDataGetter.getAuthor(element))
                .description(bookDataGetter.getDescription(element))
                .price(bookDataGetter.getPrice(element))
                .url(bookDataGetter.getUrl(element))
                .library(bookDataGetter.getLibrary(element))
                .tag(tag)
                .build();
    }

    /**
     * The same as prepareBookData, in some situation we dont need the tag name
     * @param element
     * @param bookDataGetter
     * @param <T>
     * @return
     */
    private static <T> BookData prepareBookData(T element, BookDataGetter<T> bookDataGetter) {
        return prepareBookData(element, bookDataGetter, bookDataGetter.getTag(element));
    }

    /**
     *
     * @param elements
     * @param bookDataGetter
     * @param tag
     * @param <T>
     * @return {@link List}
     */
    public static <T>
    List<BookData> newListBookData(List<T> elements, BookDataGetter<T> bookDataGetter, String tag){
        if(elements==null || bookDataGetter==null){
            throw new IllegalArgumentException();
        }
        return elements.stream().map(e->
                prepareBookData(e, bookDataGetter, tag))
                .filter(e->!e.equals(null))
                .collect(Collectors.toList());
    }
}
