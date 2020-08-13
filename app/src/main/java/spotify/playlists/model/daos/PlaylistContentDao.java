package spotify.playlists.model.daos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlaylistContentDao {


    @SerializedName("href")
    private String href;
    @SerializedName("limit")
    private int limit;
    @SerializedName("next")
    private String next;
    @SerializedName("offset")
    private int offset;
    @SerializedName("previous")
    private Object previous;
    @SerializedName("total")
    private int total;
    @SerializedName("items")
    private List<Items> items;

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

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
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

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public static class Items {
        @SerializedName("added_at")
        private String addedAt;
        @SerializedName("added_by")
        private AddedBy addedBy;
        @SerializedName("is_local")
        private boolean isLocal;
        @SerializedName("primary_color")
        private Object primaryColor;
        @SerializedName("track")
        private Track track;
        @SerializedName("video_thumbnail")
        private VideoThumbnail videoThumbnail;

        public String getAddedAt() {
            return addedAt;
        }

        public void setAddedAt(String addedAt) {
            this.addedAt = addedAt;
        }

        public AddedBy getAddedBy() {
            return addedBy;
        }

        public void setAddedBy(AddedBy addedBy) {
            this.addedBy = addedBy;
        }

        public boolean isIsLocal() {
            return isLocal;
        }

        public void setIsLocal(boolean isLocal) {
            this.isLocal = isLocal;
        }

        public Object getPrimaryColor() {
            return primaryColor;
        }

        public void setPrimaryColor(Object primaryColor) {
            this.primaryColor = primaryColor;
        }

        public Track getTrack() {
            return track;
        }

        public void setTrack(Track track) {
            this.track = track;
        }

        public VideoThumbnail getVideoThumbnail() {
            return videoThumbnail;
        }

        public void setVideoThumbnail(VideoThumbnail videoThumbnail) {
            this.videoThumbnail = videoThumbnail;
        }

        public static class AddedBy {
            @SerializedName("external_urls")
            private ExternalUrls externalUrls;
            @SerializedName("href")
            private String href;
            @SerializedName("id")
            private String id;
            @SerializedName("type")
            private String type;
            @SerializedName("uri")
            private String uri;

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
        }

        public static class Track {
            @SerializedName("album")
            private Album album;
            @SerializedName("disc_number")
            private int discNumber;
            @SerializedName("duration_ms")
            private int durationMs;
            @SerializedName("episode")
            private boolean episode;
            @SerializedName("explicit")
            private boolean explicit;
            @SerializedName("external_ids")
            private ExternalIds externalIds;
            @SerializedName("external_urls")
            private ExternalUrlsXXX externalUrls;
            @SerializedName("href")
            private String href;
            @SerializedName("id")
            private String id;
            @SerializedName("is_local")
            private boolean isLocal;
            @SerializedName("name")
            private String name;
            @SerializedName("popularity")
            private int popularity;
            @SerializedName("preview_url")
            private String previewUrl;
            @SerializedName("track")
            private boolean track;
            @SerializedName("track_number")
            private int trackNumber;
            @SerializedName("type")
            private String type;
            @SerializedName("uri")
            private String uri;
            @SerializedName("artists")
            private List<ArtistsX> artists;
            @SerializedName("available_markets")
            private List<String> availableMarkets;

            public Album getAlbum() {
                return album;
            }

            public void setAlbum(Album album) {
                this.album = album;
            }

            public int getDiscNumber() {
                return discNumber;
            }

            public void setDiscNumber(int discNumber) {
                this.discNumber = discNumber;
            }

            public int getDurationMs() {
                return durationMs;
            }

            public void setDurationMs(int durationMs) {
                this.durationMs = durationMs;
            }

            public boolean isEpisode() {
                return episode;
            }

            public void setEpisode(boolean episode) {
                this.episode = episode;
            }

            public boolean isExplicit() {
                return explicit;
            }

            public void setExplicit(boolean explicit) {
                this.explicit = explicit;
            }

            public ExternalIds getExternalIds() {
                return externalIds;
            }

            public void setExternalIds(ExternalIds externalIds) {
                this.externalIds = externalIds;
            }

            public ExternalUrlsXXX getExternalUrls() {
                return externalUrls;
            }

            public void setExternalUrls(ExternalUrlsXXX externalUrls) {
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

            public boolean isIsLocal() {
                return isLocal;
            }

            public void setIsLocal(boolean isLocal) {
                this.isLocal = isLocal;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPopularity() {
                return popularity;
            }

            public void setPopularity(int popularity) {
                this.popularity = popularity;
            }

            public String getPreviewUrl() {
                return previewUrl;
            }

            public void setPreviewUrl(String previewUrl) {
                this.previewUrl = previewUrl;
            }

            public boolean isTrack() {
                return track;
            }

            public void setTrack(boolean track) {
                this.track = track;
            }

            public int getTrackNumber() {
                return trackNumber;
            }

            public void setTrackNumber(int trackNumber) {
                this.trackNumber = trackNumber;
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

            public List<ArtistsX> getArtists() {
                return artists;
            }

            public void setArtists(List<ArtistsX> artists) {
                this.artists = artists;
            }

            public List<String> getAvailableMarkets() {
                return availableMarkets;
            }

            public void setAvailableMarkets(List<String> availableMarkets) {
                this.availableMarkets = availableMarkets;
            }

            public static class Album {
                @SerializedName("album_type")
                private String albumType;
                @SerializedName("external_urls")
                private ExternalUrlsX externalUrls;
                @SerializedName("href")
                private String href;
                @SerializedName("id")
                private String id;
                @SerializedName("name")
                private String name;
                @SerializedName("release_date")
                private String releaseDate;
                @SerializedName("release_date_precision")
                private String releaseDatePrecision;
                @SerializedName("total_tracks")
                private int totalTracks;
                @SerializedName("type")
                private String type;
                @SerializedName("uri")
                private String uri;
                @SerializedName("artists")
                private List<Artists> artists;
                @SerializedName("available_markets")
                private List<String> availableMarkets;
                @SerializedName("images")
                private List<Images> images;

                public String getAlbumType() {
                    return albumType;
                }

                public void setAlbumType(String albumType) {
                    this.albumType = albumType;
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

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getReleaseDate() {
                    return releaseDate;
                }

                public void setReleaseDate(String releaseDate) {
                    this.releaseDate = releaseDate;
                }

                public String getReleaseDatePrecision() {
                    return releaseDatePrecision;
                }

                public void setReleaseDatePrecision(String releaseDatePrecision) {
                    this.releaseDatePrecision = releaseDatePrecision;
                }

                public int getTotalTracks() {
                    return totalTracks;
                }

                public void setTotalTracks(int totalTracks) {
                    this.totalTracks = totalTracks;
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

                public List<Artists> getArtists() {
                    return artists;
                }

                public void setArtists(List<Artists> artists) {
                    this.artists = artists;
                }

                public List<String> getAvailableMarkets() {
                    return availableMarkets;
                }

                public void setAvailableMarkets(List<String> availableMarkets) {
                    this.availableMarkets = availableMarkets;
                }

                public List<Images> getImages() {
                    return images;
                }

                public void setImages(List<Images> images) {
                    this.images = images;
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

                public static class Artists {
                    @SerializedName("external_urls")
                    private ExternalUrlsXX externalUrls;
                    @SerializedName("href")
                    private String href;
                    @SerializedName("id")
                    private String id;
                    @SerializedName("name")
                    private String name;
                    @SerializedName("type")
                    private String type;
                    @SerializedName("uri")
                    private String uri;

                    public ExternalUrlsXX getExternalUrls() {
                        return externalUrls;
                    }

                    public void setExternalUrls(ExternalUrlsXX externalUrls) {
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

                    public static class ExternalUrlsXX {
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

            public static class ExternalIds {
                @SerializedName("isrc")
                private String isrc;

                public String getIsrc() {
                    return isrc;
                }

                public void setIsrc(String isrc) {
                    this.isrc = isrc;
                }
            }

            public static class ExternalUrlsXXX {
                @SerializedName("spotify")
                private String spotify;

                public String getSpotify() {
                    return spotify;
                }

                public void setSpotify(String spotify) {
                    this.spotify = spotify;
                }
            }

            public static class ArtistsX {
                @SerializedName("external_urls")
                private ExternalUrlsXXXX externalUrls;
                @SerializedName("href")
                private String href;
                @SerializedName("id")
                private String id;
                @SerializedName("name")
                private String name;
                @SerializedName("type")
                private String type;
                @SerializedName("uri")
                private String uri;

                public ExternalUrlsXXXX getExternalUrls() {
                    return externalUrls;
                }

                public void setExternalUrls(ExternalUrlsXXXX externalUrls) {
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

                public static class ExternalUrlsXXXX {
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
        }

        public static class VideoThumbnail {
            @SerializedName("url")
            private Object url;

            public Object getUrl() {
                return url;
            }

            public void setUrl(Object url) {
                this.url = url;
            }
        }
    }
}
