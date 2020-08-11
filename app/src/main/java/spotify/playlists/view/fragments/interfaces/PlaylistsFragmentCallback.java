package spotify.playlists.view.fragments.interfaces;

import spotify.playlists.model.localdaos.Playlist;

public interface PlaylistsFragmentCallback {
    void onPlaylistRowClicked(Playlist playlist);
}
