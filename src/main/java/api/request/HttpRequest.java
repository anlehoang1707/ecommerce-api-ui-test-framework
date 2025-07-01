package api.request;

import exceptions.InvalidRequestException;
import io.restassured.response.Response;
import lombok.Setter;

import java.io.File;
import java.util.Map;

public abstract class HttpRequest {
    private String url;
    private String token;
    private File payload;
    private Map<String,? extends Object> query;

    public abstract Response request() throws InvalidRequestException;

    public String getUrl() {
        return url;
    }

    public HttpRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    public HttpRequest setToken(String token) {
        this.token = token;
        return this;
    }

    public HttpRequest setQuery(Map<String, ? extends Object> query) {
        this.query = query;
        return this;
    }

    public HttpRequest setPayload(File payload) {
        this.payload = payload;
        return this;
    }


    public String getToken() {
        return token;
    }

    public File getPayload() {
        return payload;
    }

    public Map<String, ? extends Object> getQuery() {
        return query;
    }

}
