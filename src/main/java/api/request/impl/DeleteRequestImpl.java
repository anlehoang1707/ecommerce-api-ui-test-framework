package api.request.impl;

import api.request.HttpRequest;
import exceptions.InvalidRequestException;
import io.restassured.response.Response;
import org.json.JSONException;

import static io.restassured.RestAssured.given;

public class DeleteRequestImpl extends HttpRequest {
    @Override
    public Response request() {
        Response response;
        try {
            response = given().header("Authorization","Bearer " + getToken()).contentType("application/json").when().delete(getUrl(),getQuery());
        } catch (JSONException | IllegalArgumentException e) {
            throw new InvalidRequestException("there is some problem with the request.",e);
        }
        return response;
    }
}
