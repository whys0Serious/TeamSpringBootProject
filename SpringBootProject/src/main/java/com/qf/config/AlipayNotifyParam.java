package com.qf.config;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class AlipayNotifyParam implements Serializable {

    private String app_id;//商户appid
    private Float total_amount; // 支付金额
    private String out_trade_no; // 原支付请求的商户订单号
}
