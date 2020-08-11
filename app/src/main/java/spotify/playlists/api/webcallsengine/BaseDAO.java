package spotify.playlists.api.webcallsengine;

import com.google.gson.annotations.SerializedName;

public class BaseDAO {
    @SerializedName("ErrorData")
    private String ErrorData;
    @SerializedName("IsError")
    private boolean IsError;

    public String getErrorData() {
        return ErrorData;
    }

    public boolean isIsError() {
        return IsError;
    }

    public void setIsError(boolean IsError) {
        this.IsError = IsError;
    }
}