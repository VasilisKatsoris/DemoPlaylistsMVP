package spotify.playlists.api.requests;

import spotify.playlists.api.webcallsengine.BaseDAO;
import spotify.playlists.api.responses.events.BaseResponseEvent;

public abstract class BaseRequest<Dao extends BaseDAO, ResponseEvent extends BaseResponseEvent<Dao>> {

}
