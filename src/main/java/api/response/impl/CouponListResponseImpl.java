package api.response.impl;

import api.response.responseInterfaces.CouponListResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.InvalidResponseException;
import model.Coupon;

import java.util.List;

public class CouponListResponseImpl extends CouponListResponse {

    @Override
    public List<Coupon> getCoupons() throws InvalidResponseException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Coupon> coupons;
        try {
            coupons = objectMapper.readValue(getResponse().asString(), new TypeReference<List<Coupon>>() {
            });
        } catch (JsonProcessingException e) {
            throw new InvalidResponseException("something wrong with the response.",e);
        }
        return coupons;
    }
}
