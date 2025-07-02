package api.response.factory;

import api.response.responseInterfaces.CouponListResponse;
import api.response.responseInterfaces.CouponResponse;

public interface ResponseAbstractFactory {
    CouponResponse getCouponResponse();

    CouponListResponse getCouponListResponse();
}
