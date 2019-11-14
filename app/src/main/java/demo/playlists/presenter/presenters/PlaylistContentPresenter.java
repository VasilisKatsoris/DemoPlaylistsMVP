package demo.playlists.presenter.presenters;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import demo.playlists.R;
import demo.playlists.api.responses.events.PlaylistContentResponseEvent;
import demo.playlists.model.daos.PlaylistContentDao;
import demo.playlists.model.localdaos.Song;
import demo.playlists.model.models.PlaylistContentModel;
import demo.playlists.presenter.interfaces.PlaylistContentPresenterInterface;
import demo.playlists.view.interfaces.PlaylistContentViewInterface;

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
            List<PlaylistContentDao.Result.Items> items = responseEvent.getResponseDao().getResult().getItems();
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

    private ArrayList<Song> prepareItems(List<PlaylistContentDao.Result.Items> items){
        ArrayList<Song> songs = new ArrayList<>();
        for(PlaylistContentDao.Result.Items item:items){
            Song song = new Song();
            song.setArtistName(item.getArtistName());
            song.setImageUrl(item.getImageUrl());
            song.setTrackName(item.getTrackName());
            songs.add(song);
        }
        return songs;
    }
}
