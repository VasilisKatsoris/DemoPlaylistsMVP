package spotify.playlists.model.models.interfaces;

import java.util.ArrayList;

import spotify.playlists.api.responses.events.PlaylistsResponseEvent;
import spotify.playlists.model.localdaos.Playlist;


public interface PlaylistsPresenterInterface extends BasePresenterInterface{
    void onGetPlaylistsResponseEvent(PlaylistsResponseEvent responseEvent);
    void onLocalPlaylistsFetched(ArrayList<Playlist> playlists);
}
