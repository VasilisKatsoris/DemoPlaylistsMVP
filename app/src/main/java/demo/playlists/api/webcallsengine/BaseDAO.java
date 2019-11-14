package demo.playlists.api.webcallsengine;

import com.google.gson.annotations.SerializedName;

public class BaseDAO {
    @SerializedName("ErrorData")
    private String ErrorData;
    @SerializedName("ErrorId")
    private int ErrorId;
    @SerializedName("IsError")
    private boolean IsError;
    public String getErrorData() {
        return ErrorData;
    }

    public void setErrorData(String ErrorData) {
        this.ErrorData = ErrorData;
    }

    public int getErrorId() {
        return ErrorId;
    }

    public void setErrorId(int ErrorId) {
        this.ErrorId = ErrorId;
    }

    public boolean isIsError() {
        return IsError;
    }

    public void setIsError(boolean IsError) {
        this.IsError = IsError;
    }
}