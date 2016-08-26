package parser;

/**
 * This interface is used to get the exact data from the type T (generic).
 * Because in some cases the T is a {@link org.jsoup.nodes.Document} or some text that contains the data
 * that we need.
 */
public interface BookDataCollector<T> {
    // TODO this pars needs to be documented + class diagram
    String titleFrom(T element);

    String authorFrom(T element);

    String descriptionFrom(T element);

    String priceFrom(T element);

    String urlFrom(T element);

    String libraryFrom(T element);

    String tagFrom(T element);
}
