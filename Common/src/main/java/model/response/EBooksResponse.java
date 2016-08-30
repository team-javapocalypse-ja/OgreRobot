package model.response;

import model.BookData;
import model.EBookCategory;

import java.util.EnumMap;
import java.util.List;

public class EBooksResponse implements ResponseBase<EnumMap<EBookCategory, List<BookData>>>{

    private EnumMap<EBookCategory, List<BookData>> result;

    @Override
    public void setResult(EnumMap<EBookCategory, List<BookData>> responseData) {
        this.result = responseData;
    }

    @Override
    public EnumMap<EBookCategory, List<BookData>> getResult() {
        return result;
    }
}
