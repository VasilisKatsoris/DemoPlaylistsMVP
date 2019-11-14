package demo.playlists.model.daos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import demo.playlists.api.webcallsengine.BaseDAO;

public class PlaylistsDao extends BaseDAO {

    @SerializedName("Result")
    private List<PlaylistDao> playlistDaos;

    public List<PlaylistDao> getPlaylists() {
        return playlistDaos;
    }

    public void setPlaylists(List<PlaylistDao> playlistDaos) {
        this.playlistDaos = playlistDaos;
    }

    public static class PlaylistDao {
        @SerializedName("PlaylistId")
        private String PlaylistId;
        @SerializedName("Name")
        private String Name;
        @SerializedName("Duration")
        private int Duration;
        @SerializedName("ItemCount")
        private int ItemCount;
        @SerializedName("IsOwner")
        private boolean IsOwner;
        @SerializedName("DateUpdated")
        private String DateUpdated;
        @SerializedName("DateUpdatedIso")
        private String DateUpdatedIso;
        @SerializedName("OwnerId")
        private String OwnerId;
        @SerializedName("OwnerNickName")
        private String OwnerNickName;
        @SerializedName("OwnerPhotoUrl")
        private String OwnerPhotoUrl;
        @SerializedName("ViewerIsFan")
        private boolean ViewerIsFan;
        @SerializedName("FanCount")
        private int FanCount;
        @SerializedName("PhotoUrl")
        private String PhotoUrl;
        @SerializedName("LargePhotoUrl")
        private String LargePhotoUrl;
        @SerializedName("ObjectType")
        private String ObjectType;

        public String getPlaylistId() {
            return PlaylistId;
        }

        public void setPlaylistId(String PlaylistId) {
            this.PlaylistId = PlaylistId;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getDuration() {
            return Duration;
        }

        public void setDuration(int Duration) {
            this.Duration = Duration;
        }

        public int getItemCount() {
            return ItemCount;
        }

        public void setItemCount(int ItemCount) {
            this.ItemCount = ItemCount;
        }

        public boolean isIsOwner() {
            return IsOwner;
        }

        public void setIsOwner(boolean IsOwner) {
            this.IsOwner = IsOwner;
        }

        public String getDateUpdated() {
            return DateUpdated;
        }

        public void setDateUpdated(String DateUpdated) {
            this.DateUpdated = DateUpdated;
        }

        public String getDateUpdatedIso() {
            return DateUpdatedIso;
        }

        public void setDateUpdatedIso(String DateUpdatedIso) {
            this.DateUpdatedIso = DateUpdatedIso;
        }

        public String getOwnerId() {
            return OwnerId;
        }

        public void setOwnerId(String OwnerId) {
            this.OwnerId = OwnerId;
        }

        public String getOwnerNickName() {
            return OwnerNickName;
        }

        public void setOwnerNickName(String OwnerNickName) {
            this.OwnerNickName = OwnerNickName;
        }

        public String getOwnerPhotoUrl() {
            return OwnerPhotoUrl;
        }

        public void setOwnerPhotoUrl(String OwnerPhotoUrl) {
            this.OwnerPhotoUrl = OwnerPhotoUrl;
        }

        public boolean isViewerIsFan() {
            return ViewerIsFan;
        }

        public void setViewerIsFan(boolean ViewerIsFan) {
            this.ViewerIsFan = ViewerIsFan;
        }

        public int getFanCount() {
            return FanCount;
        }

        public void setFanCount(int FanCount) {
            this.FanCount = FanCount;
        }

        public String getPhotoUrl() {
            return PhotoUrl;
        }

        public void setPhotoUrl(String PhotoUrl) {
            this.PhotoUrl = PhotoUrl;
        }

        public String getLargePhotoUrl() {
            return LargePhotoUrl;
        }

        public void setLargePhotoUrl(String LargePhotoUrl) {
            this.LargePhotoUrl = LargePhotoUrl;
        }

        public String getObjectType() {
            return ObjectType;
        }

        public void setObjectType(String ObjectType) {
            this.ObjectType = ObjectType;
        }
    }
}
