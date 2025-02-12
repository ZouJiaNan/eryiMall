import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.junit.jupiter.api.Test;

public class AliPayTest {
    @Test
    public void test() throws AlipayApiException {

        String APP_ID = "2021005116697569";
        String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCCBvPNo4J0I7cbhHqcDF/V/zaAA7c02jdAdiP35ys+h+BA2RXfV4mMUGXM5/dM/BusibF63CG3XZA7Re0ikZApEydi3lwFfznzJffnfZ4dJ45VzmeIfjRUxTabdZJaWGG/Rgw5hPIYcNazc60Z+3Acm8jzSpubVeCUzjVwneKuVuyTHr6BScm8wbpS9EJcFzqO1s2+cVJFCnAuslUPuZKZThzJaaJyJUkE+m8E+8k1qozluD9B+nx09+vPckulDcoqG8kefKSOM2VjnWIgSVKwXhib4gIO1hwCh6R5iaAl8wYlPXl7t8Jv+leu5U9jpNoC313xeyEas2YE7BHFSWfvAgMBAAECggEAXHOhCkgGS5nRaglqPGY4Bipuj9sUesnlmznlHTEK+G0YMEOqX6EYNeI8X9NXbS+cZbOJs/etKXmnQd3YXEnvnKT3zj6YY3gwtgf7Gmeg8s3bUHtv9gb2IogO6b5RD1fkOGIP8x3qHSKuJe5L2DuFXXIPEZ2swmfvRR7RtH8uXBKA+5A1nd8v8uHuXWEqgpFNZAmIHmrIb1Hu3/IypQjFIGywDH8LjqiuKs4d1vB39bFPiD/fNCz/4eutUJCcv5fmpMcdLwEp0khMFhwrsnVN9UDCzlQggsJO+cHCW229FAn4fk6Ny97mSgYaZa4OZxXPI30v7u///76i5nKt0SoK8QKBgQDMtihmidBaI1Q9LkU+JqeiTr8FltHwPi/ZZ1rAistzvBRS+sWfq2OWqRK2WvnKfvKOqtzwr0+3C5AQM4Xk/ajlI01NLENFUIbYQiUAaAOs8OjDZnJzyP6WOMk00ro5HXCLGO19aGo1z9ETtlXwy4sj2OoaGTnvwhPBMhHgVmudUwKBgQCimqrldBosqZoitUtCushMPea7fIH/VesoPn8ne4n6jfklS12oL28kci+7AnecvIkA3o2bC9vwuEQekO+t12U2Q+CBCGUp/4FsRo1Nm+smvTwhj6C4e3fEZSBeMl/EBcHMm4TeDhGqgb7Qu/YBEouH5iQNqgqL2jgEKwTjslpbdQKBgQCdQGSCd+T0COWB5dRM7NaiyIjWW0fDm5GYGFvPQg8NRXH7WCWNBNQIfLIiIHp3gdMDot77iD/c5WXx/BIjmHMwKVENMi4uxa//2begu0XviFPVHhJXPRPMA60UBbgFfcbhIvHz/sxvr8b0tIEJ6uFkVRFnoO8vbM9N/g9bXCdofwKBgQCYS5Dg0/tn9XoeI/tXhqXvctLWq2j+g7R6vv5NNpInEC5YVdxkl/jbA+/ckhUBwjv3inrKyzK2pX93uXwjMGjliHGPqRNHYL4RcYsLM4vtfrQBIwr/fvTQB39nenrjmBjJ0KeDa130ew0DZ+ijXIE/Sbhe6/JwxnRMwxYTRYsHuQKBgHrwRZKD+fqwVJqVXKc3MXsmobYaNUBGhJVYTvf1aGm4WUoOALU5rLyQvMNQfoWvLEMvkgvS5KPMZFkW7bIrMKBClp6Q8SCtBvcCcsmgWi8n2z0viSKv1IzDXD/L15sNwbbJeMrlMD+9tV4BkE12O2vwtvQZfqk8UPK0SpnqSXxM";
        String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvcaoqwHiCKUH3OssGqB6xNlTMz3GVRPWX+u/h+J8eBuK58qTFTjszZu1oQX6TcNDbYEXhBEUEWXLfozjtVkWG44oem0fdOeSz9vWkZGy+AF/nWRe6BtoXxrdNFVUbd9tIvkclM+b5bOrRlsIkUovmYIuH4P8qQbN9osc1IkwK9Q2hBrhixbYA3VeAecR2lozYIjW6L1nwRh3m8ubMt7W9M9k0nxS7wgEGcOZNpg41VOPEeWXVic+l/dUbRIc0Q6rvDZkgX2hhFE9PyiLLJrNSlo9wXeOdlBnrx6f+iAI+fqjYkCg25roksouhNIEmQiJV8dqFmbme2vjgDeBYZu9NQIDAQAB";
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi-sandbox.dl.alipaydev.com/gateway.do",APP_ID,APP_PRIVATE_KEY,"json","GBK",ALIPAY_PUBLIC_KEY,"RSA2");
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setNotifyUrl("");
        JSONObject bizContent = new JSONObject();
        //订单编号
        bizContent.put("out_trade_no", "20210817010101003X02");
        //总金额
        bizContent.put("total_amount", 0.01);
        //支付名称
        bizContent.put("subject", "测试商品");
        //固定配置
        bizContent.put("product_code", "FAST_INSTAMCE_TRADE_PAY");
        request.setBizContent(bizContent.toString());
        //设置支付完成后的转跳地址
        request.setReturnUrl("http://localhost:8080/orders");
        String from = alipayClient.pageExecute(request).getBody();
        //返回给前端支付宝官方给出的支付页面
//        httpResponse.setContentType("text/html;charset=UTF-8");
//        httpResponse.getWriter().write(from);
//        httpResponse.getWriter().flush();
//        httpResponse.getWriter().close();
    }
}
