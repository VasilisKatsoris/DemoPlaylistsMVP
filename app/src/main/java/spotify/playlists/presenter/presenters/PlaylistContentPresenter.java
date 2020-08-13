package spotify.playlists.presenter.presenters;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import spotify.playlists.R;
import spotify.playlists.api.responses.events.PlaylistContentResponseEvent;
import spotify.playlists.model.daos.PlaylistContentDao;
import spotify.playlists.model.daos.PlaylistContentDao.Items.Track;
import spotify.playlists.model.localdaos.Song;
import spotify.playlists.model.models.PlaylistContentModel;
import spotify.playlists.model.models.interfaces.PlaylistContentPresenterInterface;
import spotify.playlists.presenter.presenters.interfaces.PlaylistContentViewInterface;

;

public class PlaylistContentPresenter extends BasePresenter<PlaylistContentViewInterface, PlaylistContentModel> implements PlaylistContentPresenterInterface {

    ArrayList<Song> cachedSongs;

    @Inject
    public PlaylistContentPresenter(PlaylistContentViewInterface viewInterface, PlaylistContentModel model) {
        super(viewInterface, model);
    }

    @Override
    public void getPlaylistContent(String playlistId) {
        getModel().getPlaylistContent(playlistId);
    }

    @Override
    public void onGetPlaylistContentResponseEvent(PlaylistContentResponseEvent responseEvent) {

        if (responseEvent == null || !responseEvent.validate() )  {
            if(responseEvent !=null){
                String error = responseEvent.getErrorMessage();
                getViewInterface().onGetPlaylistContentFailure(error);
            }
            cachedSongs = null;
        }
        else{
            List<PlaylistContentDao.Items> items = responseEvent.getResponseDao().getItems();
            if(items !=null){
                ArrayList<Song> songs = prepareItems(items);
                cachedSongs = songs;
                getViewInterface().onGetPlaylistContentSuccess(songs);
            }
            else{
                getViewInterface().onGetPlaylistContentFailure(getString(R.string.Unknown_error));
            }
        }
    }

    public ArrayList<Song> getCachedSongs(){
        return cachedSongs;
    }

    private ArrayList<Song> prepareItems(List<PlaylistContentDao.Items> items){
        ArrayList<Song> songs = new ArrayList<>();
        for(PlaylistContentDao.Items item:items){
            Track track = item.getTrack();

            final StringBuilder artist = new StringBuilder("");
            track.getArtists().forEach(artistsX -> {
                if((artistsX.getName()!=null && !artistsX.getName().isEmpty())){
                    artist.append(artist.toString().equals("") ? "":", ").append(artistsX.getName());
                }
            });

            Track.Album.Images selectedImage = null;
            if(track.getAlbum()!=null && track.getAlbum().getImages()!=null && track.getAlbum().getImages().size()>0) {
                for (Track.Album.Images image : track.getAlbum().getImages()) {
                    if (image.getHeight() > 60 && image.getHeight() < 640) {
                        selectedImage = image;
                    }
                }
                if (selectedImage == null) {
                    selectedImage = track.getAlbum().getImages().get(0);
                }
            }

            Song song = new Song();
            song.setImageUrl(selectedImage!=null ? selectedImage.getUrl():null);
            song.setArtistName(artist.toString());
            song.setTrackName(track.getName());
            songs.add(song);
        }
        return songs;
    }
}
