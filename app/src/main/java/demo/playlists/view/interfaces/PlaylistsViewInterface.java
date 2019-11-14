package demo.playlists.view.interfaces;


import java.util.ArrayList;

import demo.playlists.model.localdaos.Playlist;


public interface PlaylistsViewInterface extends BaseViewInterface {
    void onGetPlaylistsFailure(String errorMessage);
    void onGetPlaylistsSuccess(ArrayList<Playlist> playlists);
}
