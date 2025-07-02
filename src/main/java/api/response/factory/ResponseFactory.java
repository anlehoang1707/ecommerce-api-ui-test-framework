package api.response.factory;

import api.response.impl.CouponListResponseImpl;
import api.response.impl.CouponResponseImpl;
import api.response.responseInterfaces.CouponListResponse;
import api.response.responseInterfaces.CouponResponse;

public class ResponseFactory implements ResponseAbstractFactory{
    @Override
    public CouponResponse getCouponResponse() {
        return new CouponResponseImpl();
    }

    @Override
    public CouponListResponse getCouponListResponse() {
        return new CouponListResponseImpl();
    }
}
