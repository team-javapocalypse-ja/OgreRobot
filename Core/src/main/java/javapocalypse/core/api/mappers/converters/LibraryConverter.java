package javapocalypse.core.api.mappers.converters;

import javapocalypse.core.model.entities.Library;
import org.modelmapper.AbstractConverter;

public class LibraryConverter extends AbstractConverter<String, Library> {

    @Override
    protected Library convert(String libraryName) {
        return libraryName == null ? null : Library.from(libraryName);
    }

}
