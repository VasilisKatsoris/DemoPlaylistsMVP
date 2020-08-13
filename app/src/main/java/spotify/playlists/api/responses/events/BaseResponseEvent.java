package spotify.playlists.api.responses.events;

public class BaseResponseEvent<T> {

    private T responseDao;
    private String networkError;
    String errorMessageForUser;
    private int responseHTTPStatusCode;
    private Throwable networkErrorThrowable;

    public BaseResponseEvent() {
    }

    public void setResponseDao(T responseDao) {
        this.responseDao = responseDao;
    }

    public T getResponseDao() {
        return responseDao;
    }

    public String getNetworkError() {
        return networkError;
    }

    public String getErrorMessage(){
        String message=null;
        if(networkError!=null){
            message = networkError;
        }
        else if(errorMessageForUser!=null){
            message = errorMessageForUser;
        }

        return message;
    }

    public void setNetworkError(String networkError) {
        this.networkError = networkError;
    }

    public void setResponseHTTPStatusCode(int responseHTTPStatusCode) {
        this.responseHTTPStatusCode = responseHTTPStatusCode;
    }

    public int getResponseHTTPStatusCode() {
        return responseHTTPStatusCode;
    }

    public void setNetworkErrorThrowable(Throwable networkErrorThrowable) {
        this.networkErrorThrowable = networkErrorThrowable;
    }

    public Throwable getNetworkErrorThrowable() {
        return networkErrorThrowable;
    }

    public boolean validate(){

        if(getResponseDao() == null) {
            switch (getResponseHTTPStatusCode()) {
                case 400:
                    setErrorToShowOnFlow("Bad Request");
                    return false;
                case 500:
                    setErrorToShowOnFlow("Internal Server Error");
                    return false;
                default:
                    setErrorToShowOnFlow(getResponseHTTPStatusCode() + "");
                    return false;
            }
        }
        return true;

    }

    private void setErrorToShowOnFlow(String errorMessageForUser) {
        this.errorMessageForUser = errorMessageForUser;
    }

}
