package demo.playlists.view.interfaces;


import java.util.ArrayList;

import demo.playlists.model.localdaos.Song;

public interface PlaylistContentViewInterface extends BaseViewInterface{
    void onGetPlaylistContentFailure(String errorMessage);
    void onGetPlaylistContentSuccess(ArrayList<Song> songs);
}
