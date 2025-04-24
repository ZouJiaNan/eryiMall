package com.eryi.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.eryi.bean.bo.pay.order.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AlipayServiceImpl {
    /**
     * APP_ID 应用id
     */
    public final static String APP_ID ="9021000143679857";
    /**
     * 应用私钥
     */
    public  final static String APP_PRIVATE_KEY="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCCBvPNo4J0I7cbhHqcDF/V/zaAA7c02jdAdiP35ys+h+BA2RXfV4mMUGXM5/dM/BusibF63CG3XZA7Re0ikZApEydi3lwFfznzJffnfZ4dJ45VzmeIfjRUxTabdZJaWGG/Rgw5hPIYcNazc60Z+3Acm8jzSpubVeCUzjVwneKuVuyTHr6BScm8wbpS9EJcFzqO1s2+cVJFCnAuslUPuZKZThzJaaJyJUkE+m8E+8k1qozluD9B+nx09+vPckulDcoqG8kefKSOM2VjnWIgSVKwXhib4gIO1hwCh6R5iaAl8wYlPXl7t8Jv+leu5U9jpNoC313xeyEas2YE7BHFSWfvAgMBAAECggEAXHOhCkgGS5nRaglqPGY4Bipuj9sUesnlmznlHTEK+G0YMEOqX6EYNeI8X9NXbS+cZbOJs/etKXmnQd3YXEnvnKT3zj6YY3gwtgf7Gmeg8s3bUHtv9gb2IogO6b5RD1fkOGIP8x3qHSKuJe5L2DuFXXIPEZ2swmfvRR7RtH8uXBKA+5A1nd8v8uHuXWEqgpFNZAmIHmrIb1Hu3/IypQjFIGywDH8LjqiuKs4d1vB39bFPiD/fNCz/4eutUJCcv5fmpMcdLwEp0khMFhwrsnVN9UDCzlQggsJO+cHCW229FAn4fk6Ny97mSgYaZa4OZxXPI30v7u///76i5nKt0SoK8QKBgQDMtihmidBaI1Q9LkU+JqeiTr8FltHwPi/ZZ1rAistzvBRS+sWfq2OWqRK2WvnKfvKOqtzwr0+3C5AQM4Xk/ajlI01NLENFUIbYQiUAaAOs8OjDZnJzyP6WOMk00ro5HXCLGO19aGo1z9ETtlXwy4sj2OoaGTnvwhPBMhHgVmudUwKBgQCimqrldBosqZoitUtCushMPea7fIH/VesoPn8ne4n6jfklS12oL28kci+7AnecvIkA3o2bC9vwuEQekO+t12U2Q+CBCGUp/4FsRo1Nm+smvTwhj6C4e3fEZSBeMl/EBcHMm4TeDhGqgb7Qu/YBEouH5iQNqgqL2jgEKwTjslpbdQKBgQCdQGSCd+T0COWB5dRM7NaiyIjWW0fDm5GYGFvPQg8NRXH7WCWNBNQIfLIiIHp3gdMDot77iD/c5WXx/BIjmHMwKVENMi4uxa//2begu0XviFPVHhJXPRPMA60UBbgFfcbhIvHz/sxvr8b0tIEJ6uFkVRFnoO8vbM9N/g9bXCdofwKBgQCYS5Dg0/tn9XoeI/tXhqXvctLWq2j+g7R6vv5NNpInEC5YVdxkl/jbA+/ckhUBwjv3inrKyzK2pX93uXwjMGjliHGPqRNHYL4RcYsLM4vtfrQBIwr/fvTQB39nenrjmBjJ0KeDa130ew0DZ+ijXIE/Sbhe6/JwxnRMwxYTRYsHuQKBgHrwRZKD+fqwVJqVXKc3MXsmobYaNUBGhJVYTvf1aGm4WUoOALU5rLyQvMNQfoWvLEMvkgvS5KPMZFkW7bIrMKBClp6Q8SCtBvcCcsmgWi8n2z0viSKv1IzDXD/L15sNwbbJeMrlMD+9tV4BkE12O2vwtvQZfqk8UPK0SpnqSXxM";
    /**
     * 编码
     */
    public final static String CHARSET ="UTF-8";
    /**
     * 支付宝公钥
     */
    public final static String ALIPAY_PUBLIC_KEY ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvcaoqwHiCKUH3OssGqB6xNlTMz3GVRPWX+u/h+J8eBuK58qTFTjszZu1oQX6TcNDbYEXhBEUEWXLfozjtVkWG44oem0fdOeSz9vWkZGy+AF/nWRe6BtoXxrdNFVUbd9tIvkclM+b5bOrRlsIkUovmYIuH4P8qQbN9osc1IkwK9Q2hBrhixbYA3VeAecR2lozYIjW6L1nwRh3m8ubMt7W9M9k0nxS7wgEGcOZNpg41VOPEeWXVic+l/dUbRIc0Q6rvDZkgX2hhFE9PyiLLJrNSlo9wXeOdlBnrx6f+iAI+fqjYkCg25roksouhNIEmQiJV8dqFmbme2vjgDeBYZu9NQIDAQAB";
    /**
     * (沙箱)网关
     */
    public final static String GETEWAY_URL ="https://openapi-sandbox.dl.alipaydev.com/gateway.do";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "内网穿透地址/pay/alipay_notify";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // public static String return_url = "http://mytest.free.svipss.top/list";
    public static String return_url = "http://www.baidu.com";  // 支付成功 最后一步 跳转 返回的 页面
    /**
     * 格式化
     */
    public final static String FORMAT ="json";

    /**
     * 根据订单生成支付页面
     * @param order
     * @return
     */
    public String genernatePCAlipayHtml(Order order)  {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(GETEWAY_URL,APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET,ALIPAY_PUBLIC_KEY);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = order.getId();
        //付款金额，必填
        String total_amount = order.getTotalPrice().toString();
        //订单名称，必填
        String subject = order.getId();
        //商品描述，可空
        String body = order.getRemark() ;
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = null;
        try {
            AlipayTradePagePayResponse res = alipayClient.pageExecute(alipayRequest);
            result = res.getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return result;
    }
}
