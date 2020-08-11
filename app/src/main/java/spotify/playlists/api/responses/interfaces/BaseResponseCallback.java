package spotify.playlists.api.responses.interfaces;

import spotify.playlists.api.responses.events.BaseResponseEvent;

public interface BaseResponseCallback<ResponseEvent extends BaseResponseEvent> {
    void onResponse(ResponseEvent responseEvent);
}
