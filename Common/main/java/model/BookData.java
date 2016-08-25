package model;

/**
 * Class responsible to build the data of books that we need
 */
public class BookData {

    public final String title;
    public final String author;
    public final String description;
    public final String price;
    public final String library;
    public final String tag;
    public final String url;

    private BookData(String title, String author, String description, String price, String library, String tag, String url) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.library = library;
        this.tag = tag;
        this.url = url;
    }

    public static class BookDataBuilder {
        private String title;
        private String author;
        private String description;
        private String price;
        private String library;
        private String profile;
        private String url;

        public BookDataBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookDataBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookDataBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public BookDataBuilder setPrice(String price) {
            this.price = price;
            return this;
        }

        public BookDataBuilder setLibrary(String library) {
            this.library = library;
            return this;
        }

        public BookDataBuilder setProfile(String profile) {
            this.profile = profile;
            return this;
        }

        public BookDataBuilder setUrl(String url) {
            this.url = url;
            return this;
        }

        public BookData build() {
            return new BookData(title, author, description, price, library, profile, url);
        }
    }

    @Override
    public String toString() {
        return "BookData{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", library='" + library + '\'' +
                ", tag='" + tag + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
