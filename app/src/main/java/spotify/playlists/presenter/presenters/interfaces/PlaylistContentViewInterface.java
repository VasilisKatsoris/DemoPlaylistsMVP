package spotify.playlists.presenter.presenters.interfaces;


import java.util.ArrayList;

import spotify.playlists.model.localdaos.Song;

public interface PlaylistContentViewInterface extends BaseViewInterface{
    void onGetPlaylistContentFailure(String errorMessage);
    void onGetPlaylistContentSuccess(ArrayList<Song> songs);
}
