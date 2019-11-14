package demo.playlists.model.daos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import demo.playlists.api.webcallsengine.BaseDAO;

public class PlaylistContentDao extends BaseDAO {

    @SerializedName("Result")
    private Result Result;


    public Result getResult() {
        return Result;
    }

    public void setResult(Result Result) {
        this.Result = Result;
    }


    public static class Result {
        @SerializedName("ServerTime")
        private String ServerTime;
        @SerializedName("ServerTimeIso")
        private String ServerTimeIso;
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
        @SerializedName("Items")
        private List<Items> Items;

        public String getServerTime() {
            return ServerTime;
        }

        public void setServerTime(String ServerTime) {
            this.ServerTime = ServerTime;
        }

        public String getServerTimeIso() {
            return ServerTimeIso;
        }

        public void setServerTimeIso(String ServerTimeIso) {
            this.ServerTimeIso = ServerTimeIso;
        }

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

        public List<Items> getItems() {
            return Items;
        }

        public void setItems(List<Items> Items) {
            this.Items = Items;
        }

        public static class Items {
            @SerializedName("ItemId")
            private int ItemId;
            @SerializedName("Position")
            private int Position;
            @SerializedName("StreamingModuleId")
            private String StreamingModuleId;
            @SerializedName("AlbumId")
            private int AlbumId;
            @SerializedName("AlbumName")
            private String AlbumName;
            @SerializedName("ImageUrl")
            private String ImageUrl;
            @SerializedName("LargeImageUrl")
            private String LargeImageUrl;
            @SerializedName("DateUserAdded")
            private String DateUserAdded;
            @SerializedName("DateUserAddedIso")
            private String DateUserAddedIso;
            @SerializedName("TrackId")
            private int TrackId;
            @SerializedName("ModuleId")
            private String ModuleId;
            @SerializedName("TrackName")
            private String TrackName;
            @SerializedName("TrackNumber")
            private int TrackNumber;
            @SerializedName("TrackDuration")
            private int TrackDuration;
            @SerializedName("IsUserFan")
            private boolean IsUserFan;
            @SerializedName("UserMark")
            private int UserMark;
            @SerializedName("IsOwner")
            private boolean IsOwner;
            @SerializedName("IsStreamable")
            private boolean IsStreamable;
            @SerializedName("IsPreview")
            private boolean IsPreview;
            @SerializedName("IsExplicit")
            private boolean IsExplicit;
            @SerializedName("ArtistId")
            private int ArtistId;
            @SerializedName("ArtistName")
            private String ArtistName;
            @SerializedName("Genres")
            private Object Genres;
            @SerializedName("ObjectType")
            private String ObjectType;

            public int getItemId() {
                return ItemId;
            }

            public void setItemId(int ItemId) {
                this.ItemId = ItemId;
            }

            public int getPosition() {
                return Position;
            }

            public void setPosition(int Position) {
                this.Position = Position;
            }

            public String getStreamingModuleId() {
                return StreamingModuleId;
            }

            public void setStreamingModuleId(String StreamingModuleId) {
                this.StreamingModuleId = StreamingModuleId;
            }

            public int getAlbumId() {
                return AlbumId;
            }

            public void setAlbumId(int AlbumId) {
                this.AlbumId = AlbumId;
            }

            public String getAlbumName() {
                return AlbumName;
            }

            public void setAlbumName(String AlbumName) {
                this.AlbumName = AlbumName;
            }

            public String getImageUrl() {
                return ImageUrl;
            }

            public void setImageUrl(String ImageUrl) {
                this.ImageUrl = ImageUrl;
            }

            public String getLargeImageUrl() {
                return LargeImageUrl;
            }

            public void setLargeImageUrl(String LargeImageUrl) {
                this.LargeImageUrl = LargeImageUrl;
            }

            public String getDateUserAdded() {
                return DateUserAdded;
            }

            public void setDateUserAdded(String DateUserAdded) {
                this.DateUserAdded = DateUserAdded;
            }

            public String getDateUserAddedIso() {
                return DateUserAddedIso;
            }

            public void setDateUserAddedIso(String DateUserAddedIso) {
                this.DateUserAddedIso = DateUserAddedIso;
            }

            public int getTrackId() {
                return TrackId;
            }

            public void setTrackId(int TrackId) {
                this.TrackId = TrackId;
            }

            public String getModuleId() {
                return ModuleId;
            }

            public void setModuleId(String ModuleId) {
                this.ModuleId = ModuleId;
            }

            public String getTrackName() {
                return TrackName;
            }

            public void setTrackName(String TrackName) {
                this.TrackName = TrackName;
            }

            public int getTrackNumber() {
                return TrackNumber;
            }

            public void setTrackNumber(int TrackNumber) {
                this.TrackNumber = TrackNumber;
            }

            public int getTrackDuration() {
                return TrackDuration;
            }

            public void setTrackDuration(int TrackDuration) {
                this.TrackDuration = TrackDuration;
            }

            public boolean isIsUserFan() {
                return IsUserFan;
            }

            public void setIsUserFan(boolean IsUserFan) {
                this.IsUserFan = IsUserFan;
            }

            public int getUserMark() {
                return UserMark;
            }

            public void setUserMark(int UserMark) {
                this.UserMark = UserMark;
            }

            public boolean isIsOwner() {
                return IsOwner;
            }

            public void setIsOwner(boolean IsOwner) {
                this.IsOwner = IsOwner;
            }

            public boolean isIsStreamable() {
                return IsStreamable;
            }

            public void setIsStreamable(boolean IsStreamable) {
                this.IsStreamable = IsStreamable;
            }

            public boolean isIsPreview() {
                return IsPreview;
            }

            public void setIsPreview(boolean IsPreview) {
                this.IsPreview = IsPreview;
            }

            public boolean isIsExplicit() {
                return IsExplicit;
            }

            public void setIsExplicit(boolean IsExplicit) {
                this.IsExplicit = IsExplicit;
            }

            public int getArtistId() {
                return ArtistId;
            }

            public void setArtistId(int ArtistId) {
                this.ArtistId = ArtistId;
            }

            public String getArtistName() {
                return ArtistName;
            }

            public void setArtistName(String ArtistName) {
                this.ArtistName = ArtistName;
            }

            public Object getGenres() {
                return Genres;
            }

            public void setGenres(Object Genres) {
                this.Genres = Genres;
            }

            public String getObjectType() {
                return ObjectType;
            }

            public void setObjectType(String ObjectType) {
                this.ObjectType = ObjectType;
            }
        }
    }

}
