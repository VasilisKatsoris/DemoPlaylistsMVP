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
                getViewInterface().onGetPlaylistContentFailure(error!=null ? error : "Unknown Error");
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
            Song song = new Song();
            String artist = "";
            for(PlaylistContentDao.Items.Track.ArtistsX artistX:track.getArtists()){
                if((artistX.getName()!=null && !artistX.getName().isEmpty())){
                    artist +=  (artist.equals("") ? "":",") + artistX.getName();
                }
            }
            Track.Album.Images selectedImage = null;
            for(Track.Album.Images image:track.getAlbum().getImages()){
                if(image.getHeight()>60 && image.getHeight()<640){
                    selectedImage = image;
                }
            }
            if(selectedImage == null){
                selectedImage = track.getAlbum().getImages().get(0);
            }
            song.setImageUrl(selectedImage.getUrl());
            song.setArtistName(artist);
            song.setTrackName(track.getName());
            songs.add(song);
        }
        return songs;
    }
}
