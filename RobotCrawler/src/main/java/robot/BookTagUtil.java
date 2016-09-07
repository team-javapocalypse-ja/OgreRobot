package robot;

import lombok.extern.log4j.Log4j2;
import model.Library;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import model.BookTag;
import model.Library;

import java.util.*;
import java.util.stream.Stream;

@Log4j2
@Component
@PropertySource("classpath:/ebooks.properties")
public class BookTagUtil implements InitializingBean{

    @Autowired
    Environment environment;

    private EnumMap<BookTag, List<String>> eBooksTagMapper = new EnumMap<>(BookTag.class);

    /**
     * Initializing the bean to read the file only once
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        for(BookTag bookTag : BookTag.values()){
            eBooksTagMapper.put(bookTag,
                    Arrays.asList(environment.getProperty(bookTag.name()).split(",")));
        }
    }

    /**
     * To get the specific tag name of {@link BookTag} from the {@link Library}
     * @param bookTag - the tag that you want map on your specific library tag
     * @return the mapped tags or an empty list if the library is not found
     */
    public List<String> tagNamesOf(BookTag bookTag, Library library){
        log.debug("searching for the tag "
                .concat(bookTag.name())
                .concat(" in the library ")
                .concat(library.name()));

        switch (library){
            case E_BOOKS:
                return eBooksTagMapper.get(bookTag);

        }

        return new ArrayList<>();
    }

    /**
     * To get all original tags
     * @return {@link Stream} - stream of tags pipeline of type {@link BookTag}
     */
    public Stream<BookTag> allTags(){
        return eBooksTagMapper.keySet().stream();
    }
}
