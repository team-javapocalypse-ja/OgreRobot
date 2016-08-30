package model.response;

public interface ResponseBase<T> {
    void setResult(T data);
    T getResult();
}
