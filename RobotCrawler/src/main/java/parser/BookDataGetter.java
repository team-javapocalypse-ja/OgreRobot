package parser;

/**
 * Created by ehsan on 25.08.16.
 */
public interface BookDataGetter<T> {
    String getTitle(T element);

    String getAuthor(T element);

    String getDescription(T element);

    String getPrice(T element);

    String getUrl(T element);

    String getLibrary(T element);

    String getTag(T element);
}
