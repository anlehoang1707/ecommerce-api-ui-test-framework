package api.response.impl;

import api.response.responseInterfaces.CouponResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.InvalidResponseException;
import model.Coupon;

public class CouponResponseImpl extends CouponResponse {

    @Override
    public Coupon getCoupon() throws InvalidResponseException {
        ObjectMapper objectMapper = new ObjectMapper();
        Coupon coupon;
        try {
            coupon = objectMapper.readValue(getResponse().asString(),Coupon.class);
        } catch (JsonProcessingException e) {
            throw new InvalidResponseException("something wrong with the response.",e);
        }
        return coupon;
    }
}
