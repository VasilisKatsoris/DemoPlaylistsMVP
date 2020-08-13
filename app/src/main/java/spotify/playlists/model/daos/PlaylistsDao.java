package spotify.playlists.model.daos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlaylistsDao {

    @SerializedName("href")
    private String href;
    @SerializedName("limit")
    private int limit;
    @SerializedName("next")
    private Object next;
    @SerializedName("offset")
    private int offset;
    @SerializedName("previous")
    private Object previous;
    @SerializedName("total")
    private int total;
    @SerializedName("items")
    private List<PlaylistDao> items;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<PlaylistDao> getItems() {
        return items;
    }

    public void setItems(List<PlaylistDao> items) {
        this.items = items;
    }

    public static class PlaylistDao {
        @SerializedName("collaborative")
        private boolean collaborative;
        @SerializedName("description")
        private String description;
        @SerializedName("external_urls")
        private ExternalUrls externalUrls;
        @SerializedName("href")
        private String href;
        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;
        @SerializedName("owner")
        private Owner owner;
        @SerializedName("primary_color")
        private Object primaryColor;
        @SerializedName("public")
        private boolean publicX;
        @SerializedName("snapshot_id")
        private String snapshotId;
        @SerializedName("tracks")
        private Tracks tracks;
        @SerializedName("type")
        private String type;
        @SerializedName("uri")
        private String uri;
        @SerializedName("images")
        private List<Images> images;

        public boolean isCollaborative() {
            return collaborative;
        }

        public void setCollaborative(boolean collaborative) {
            this.collaborative = collaborative;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public ExternalUrls getExternalUrls() {
            return externalUrls;
        }

        public void setExternalUrls(ExternalUrls externalUrls) {
            this.externalUrls = externalUrls;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Owner getOwner() {
            return owner;
        }

        public void setOwner(Owner owner) {
            this.owner = owner;
        }

        public Object getPrimaryColor() {
            return primaryColor;
        }

        public void setPrimaryColor(Object primaryColor) {
            this.primaryColor = primaryColor;
        }

        public boolean isPublicX() {
            return publicX;
        }

        public void setPublicX(boolean publicX) {
            this.publicX = publicX;
        }

        public String getSnapshotId() {
            return snapshotId;
        }

        public void setSnapshotId(String snapshotId) {
            this.snapshotId = snapshotId;
        }

        public Tracks getTracks() {
            return tracks;
        }

        public void setTracks(Tracks tracks) {
            this.tracks = tracks;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public List<Images> getImages() {
            return images;
        }

        public void setImages(List<Images> images) {
            this.images = images;
        }

        public static class ExternalUrls {
            @SerializedName("spotify")
            private String spotify;

            public String getSpotify() {
                return spotify;
            }

            public void setSpotify(String spotify) {
                this.spotify = spotify;
            }
        }

        public static class Owner {
            @SerializedName("display_name")
            private String displayName;
            @SerializedName("external_urls")
            private ExternalUrlsX externalUrls;
            @SerializedName("href")
            private String href;
            @SerializedName("id")
            private String id;
            @SerializedName("type")
            private String type;
            @SerializedName("uri")
            private String uri;

            public String getDisplayName() {
                return displayName;
            }

            public void setDisplayName(String displayName) {
                this.displayName = displayName;
            }

            public ExternalUrlsX getExternalUrls() {
                return externalUrls;
            }

            public void setExternalUrls(ExternalUrlsX externalUrls) {
                this.externalUrls = externalUrls;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public static class ExternalUrlsX {
                @SerializedName("spotify")
                private String spotify;

                public String getSpotify() {
                    return spotify;
                }

                public void setSpotify(String spotify) {
                    this.spotify = spotify;
                }
            }
        }

        public static class Tracks {
            @SerializedName("href")
            private String href;
            @SerializedName("total")
            private int total;

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class Images {
            @SerializedName("height")
            private int height;
            @SerializedName("url")
            private String url;
            @SerializedName("width")
            private int width;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }
        }
    }
}
