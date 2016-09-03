package model.response;

public class BooleanResponse implements ResponseBase<Boolean> {
    private boolean result;

    public BooleanResponse(boolean result) {
        this.result = result;
    }

    @Override
    public void setResult(Boolean data) {
        this.result = data;
    }

    @Override
    public Boolean getResult() {
        return result;
    }
}
