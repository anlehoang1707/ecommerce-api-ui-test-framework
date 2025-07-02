package api.response.responseInterfaces;

import exceptions.InvalidResponseException;
import io.restassured.response.Response;
import model.Coupon;

public abstract class CouponResponse {
    private Response response;
    public abstract Coupon getCoupon() throws InvalidResponseException;

    public Response getResponse() {
        return response;
    }

    public CouponResponse setResponse(Response response) {
        this.response = response;
        return this;
    }
}
