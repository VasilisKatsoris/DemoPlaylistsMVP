package demo.playlists.presenter.interfaces;

import java.util.ArrayList;

import demo.playlists.api.responses.events.PlaylistsResponseEvent;
import demo.playlists.model.localdaos.Playlist;


public interface PlaylistsPresenterInterface extends BasePresenterInterface{
    void getPlaylists(boolean forceUpdate);
    void onGetPlaylistsResponseEvent(PlaylistsResponseEvent responseEvent);
    void onLocalPlaylistsFetched(ArrayList<Playlist> playlists);
}
