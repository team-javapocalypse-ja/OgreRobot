package model.response;

/**
 * Response base is used to communicate between services in different servers
 * When the client send the request the server sets the result(A private field) and then the client
 * will be able to get the result by getResult
 * @param <T> - the type of the result
 */
public interface RequestResponseBase<T> {
    void setResult(T data);
    T getResult();
}
