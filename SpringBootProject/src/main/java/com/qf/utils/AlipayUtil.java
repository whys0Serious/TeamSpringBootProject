package com.qf.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.qf.config.AlipayConfig;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AlipayUtil {
    public String pay(Float price,String name) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,
                AlipayConfig.app_id,AlipayConfig.merchant_private_key,

                "json","utf-8",AlipayConfig.alipay_public_key,"RSA2");
        //创建API对应的request
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
               String trade_no=tradeno();//随机获得订单编号；
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+trade_no+"\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":"+price+"," +
                "    \"subject\":\""+name+"\"," +
                "    \"body\":\""+name+"\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207847\"" +
                "    }"+
                "  }");
        String form="";
        //调用SDK生成表单        System.out.println(response.getBody());
        form = alipayClient.pageExecute(alipayRequest).getBody();
        return form;
    }

    public String tradeno(){
        StringBuffer stringBuffer=new StringBuffer();
        Random random=new Random();
        for (int i = 0; i <16 ; i++) {
            int s=random.nextInt(9);
           stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }
}
