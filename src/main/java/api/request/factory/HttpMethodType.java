package api.request.factory;

import api.request.HttpRequest;
import api.request.impl.*;

public enum HttpMethodType {
    GET {
        @Override
        public HttpRequest createHttpRequest() {
            return new GetRequestImpl();
        }
    },GET_WITH_QUERY {
        @Override
        public HttpRequest createHttpRequest() {
            return new GetRequestQueryImpl();
        }
    },POST {
        @Override
        public HttpRequest createHttpRequest() {
            return new PostRequestImpl();
        }
    },PUT {
        @Override
        public HttpRequest createHttpRequest() {
            return new PutRequestImpl();
        }
    },DELETE {
        @Override
        public HttpRequest createHttpRequest() {
            return new DeleteRequestImpl();
        }
    };

    public abstract HttpRequest createHttpRequest();
}
