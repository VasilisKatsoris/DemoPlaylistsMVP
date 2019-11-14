package demo.playlists.api.responses.interfaces;

import demo.playlists.api.responses.events.BaseResponseEvent;

public interface BaseResponseCallback<ResponseEvent extends BaseResponseEvent> {
    void onResponse(ResponseEvent responseEvent);
}
