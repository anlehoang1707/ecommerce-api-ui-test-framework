package api.request;

import api.request.factory.HttpMethodFactory;
import api.request.factory.HttpMethodType;
import io.restassured.response.Response;
import lombok.Setter;

import java.io.File;
import java.util.Map;

public class HttpRequestProcessor {
    @Setter
    private String jwtToken;

    private Response response;

    public String getJwtToken() {
        return jwtToken;
    }

    public Response getResponse() {
        return this.response;
    }

    public void get(String endpoint) {
        HttpRequest httpGet = new HttpMethodFactory().build(HttpMethodType.GET);
        this.response = httpGet.setToken(jwtToken).setUrl(endpoint).request();
    }

    public void get(String endpoint, Map<String, ?extends Object> query) {
        HttpRequest httpGetQuery = new HttpMethodFactory().build(HttpMethodType.GET_WITH_QUERY);
        this.response = httpGetQuery.setToken(jwtToken).setUrl(endpoint).setQuery(query).request();
    }

    public void post(String endpoint, File requestPayload) {
        HttpRequest httpPost = new HttpMethodFactory().build(HttpMethodType.POST);
        this.response = httpPost.setToken(jwtToken).setUrl(endpoint).setPayload(requestPayload).request();
    }

    public void put(String endpoint, File requestPayload, Map<String, ?extends Object> query) {
        HttpRequest httpPut = new HttpMethodFactory().build(HttpMethodType.PUT);
        this.response = httpPut.setToken(jwtToken).setUrl(endpoint).setQuery(query).setPayload(requestPayload).request();

    }

    public void delete(String endpoint, Map<String, ? extends Object>query) {
        HttpRequest httpDelete = new HttpMethodFactory().build(HttpMethodType.DELETE);
        this.response = httpDelete.setUrl(endpoint).setToken(jwtToken).setQuery(query).request();
    }
}
