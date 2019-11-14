package demo.playlists;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import demo.playlists.api.webcallsengine.BaseDAO;
import demo.playlists.api.responses.events.BaseResponseEvent;

import static org.mockito.Mockito.doAnswer;

class ResponseEventMockFactory {

    <T extends BaseResponseEvent, V extends BaseDAO> void mock(T event,
                                                               final V dao,
                                                               final boolean error) {
        /* mock dao */
        doAnswer(new Answer<V>() {
            @Override
            public V answer(InvocationOnMock invocation) throws Throwable {
                return dao;
            }
        }).when(event).getResponseDao();

        /* mock error message */
        doAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                return error ? "Error Message" : null;
            }
        }).when(event).getErrorMessage();

        /* mock validate - Note : looper error */
        doAnswer(new Answer<Boolean>() {
            @Override
            public Boolean answer(InvocationOnMock invocation) throws Throwable {
                return !error;
            }
        }).when(event).validate();
    }
}