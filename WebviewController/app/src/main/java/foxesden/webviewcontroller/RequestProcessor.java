package foxesden.webviewcontroller;


import foxesden.webviewcontroller.rest.Request;
import foxesden.webviewcontroller.rest.Response;

public interface RequestProcessor {
    public Response process(Request request);
}
