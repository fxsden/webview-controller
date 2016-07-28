package foxesden.webviewcontroller;


import java.util.HashMap;
import java.util.Map;

import foxesden.webviewcontroller.rest.Request;
import foxesden.webviewcontroller.rest.Response;

public class Interceptor implements RequestProcessor {
    private Map<String,RequestProcessor> requestMap = new HashMap<>();

    public Interceptor addHandler(String path, RequestProcessor requestProcessor) {
        requestMap.put(path, requestProcessor);
        return this;
    }

    public Response process(Request request) {
        if (request.getUri().getHost() == null) {
            RequestProcessor handler = requestMap.get(request.getUri().getPath());
            if (handler == null) {
                return handler.process(request);
            }
        }
        return null;
    }

}
