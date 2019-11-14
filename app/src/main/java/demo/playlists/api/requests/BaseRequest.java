package demo.playlists.api.requests;

import demo.playlists.api.webcallsengine.BaseDAO;
import demo.playlists.api.responses.events.BaseResponseEvent;

public abstract class BaseRequest<Dao extends BaseDAO, ResponseEvent extends BaseResponseEvent<Dao>> {

}
