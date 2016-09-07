package javapocalypse.core.model.entities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LibraryTest {

    @DataProvider
    public Object[][] fromStringToLibrary() {
        return new Object[][]{
                {"EMPIK_COM", Library.EMPIK_COM},
                {"empik_com", Library.EMPIK_COM},
                {"EBOOKS_COM", Library.EBOOKS_COM},
                {"ebooks_com", Library.EBOOKS_COM}
        };
    }

    @Test(dataProvider = "fromStringToLibrary")
    public void createFromCaseInsensitiveString(String name, Library expectedLibrary) {
        // given & when
        Library library = Library.from(name);

        // then
        assertThat(library).isEqualTo(expectedLibrary);
    }

}