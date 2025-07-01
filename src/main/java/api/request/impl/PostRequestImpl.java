package api.request.impl;

import api.request.HttpRequest;
import exceptions.InvalidRequestException;
import io.restassured.response.Response;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class PostRequestImpl extends HttpRequest {
    @Override
    public Response request() {
        Response response;
        try {
            response = given().header("Authorization","Bearer " + getToken()).contentType("application/json").when().post(getUrl());
        } catch (JSONException | IllegalArgumentException e) {
            throw new InvalidRequestException("there is some problem with the request.",e);
        }
        return response;
    }
}
