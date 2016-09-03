package model.response;

public class BooleanRequestResponse implements RequestResponseBase<Boolean> {
    private boolean result;

    public BooleanRequestResponse(boolean result) {
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
