package api.request.factory;

import api.request.HttpRequest;

public class HttpMethodFactory {
    public HttpRequest build(HttpMethodType type) {return type.createHttpRequest();}
}
