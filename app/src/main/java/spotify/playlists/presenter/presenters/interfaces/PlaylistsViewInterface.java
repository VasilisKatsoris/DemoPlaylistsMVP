package spotify.playlists.presenter.presenters.interfaces;


import java.util.ArrayList;

import spotify.playlists.model.localdaos.Playlist;


public interface PlaylistsViewInterface extends BaseViewInterface {
    void onGetPlaylistsFailure(String errorMessage);
    void onGetPlaylistsSuccess(ArrayList<Playlist> playlists);
}
