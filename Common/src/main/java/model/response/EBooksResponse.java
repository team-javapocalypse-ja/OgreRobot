package model.response;

import model.BookData;
import model.BookTag;
import model.EBookCategory;

import java.util.EnumMap;
import java.util.List;

public class EBooksResponse implements ResponseBase<EnumMap<BookTag, List<BookData>>>{

    private EnumMap<BookTag, List<BookData>> result;

    @Override
    public void setResult(EnumMap<BookTag, List<BookData>> responseData) {
        this.result = responseData;
    }

    @Override
    public EnumMap<BookTag, List<BookData>> getResult() {
        return result;
    }
}
