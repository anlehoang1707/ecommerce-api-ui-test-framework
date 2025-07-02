package api.response.responseInterfaces;

import exceptions.InvalidResponseException;
import io.restassured.response.Response;
import model.Coupon;

import java.util.List;

public abstract class CouponListResponse {
    private Response response;
    public abstract List<Coupon> getCoupons() throws InvalidResponseException;


    public Response getResponse() {
        return response;
    }

    public CouponListResponse setResponse(Response response) {
        this.response = response;
        return this;
    }
}
