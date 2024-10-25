package com.eryi.controller;

import com.eryi.dto.ResultBean;
import com.eryi.enums.ResponseCode;

public class BaseController {
    protected ResultBean success(Object object)
    {
        ResultBean resultBean = new ResultBean();
        resultBean.setData(object);
        resultBean.setCode(ResponseCode.OK.getCode());
        return resultBean;
    }
}
