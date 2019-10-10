package com.qf.config;

import org.springframework.context.annotation.Configuration;

import java.io.FileWriter;
import java.io.IOException;

@Configuration
public class AlipayConfig {
    //商户
    public static String app_id = "2016101200671961";
    //私钥
    public static String merchant_private_key ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC8d1NaBDB4L7GRZzsrr+viXc/AeFAUkhOzHDg5+aUkWNiFowR5uqaKn9f2+0Ue8+RNRnwsZjgwzMMrBYoRHx4WBlxaVBs/3rvInSY/YfYRI5ZRZ3j0AxH071FB3zw2plUPGXrooYa2wFgWGtFhK/pZEPvAfOAvKygVnZ0YpLwV+zR+lN0o652d0PbaULrBbxvTAP8wkqAfNn9a4bgROCrN3mKf5vaQKgKxMYV135LWNlvttcv5jTteuYAnF/BleOtaT9xzZORbjoHaI/6qdI9QoN6g3Z0tx/Z4hHH/oJJn0hJRPbaM3AhFshRptBfTsQ906il3wvIp0GiADYKYajUFAgMBAAECggEAALUZ9P6LCAh1zCvtBu70HbdobjqFYm5h8IwskdskCYzj0yyXebV/pomPD/hFfCZCNyAKm0gO8e/y05iDuii5vi9r7VLff0/guJIOcLJ3b/0INWoEBDZ2vMqhLXQfD710GEhqM7FXhhwWuI6FNq4plGgB6ekOFl89GUesLUmBAzwagAZRdw09uevLMoq7DStARn4xB2Ko0EKuLMZKiSO7FPyAlMxp+G6Vf2ECWzmKnEcBEKnzBKRXWi9XAP4NyAEbo/HS0o2QB47xn7F3W0g8ylGjXMqt7/w2M7zoNLXPQrm840BB6lAEg4jne8Z87Q7+r1JB5D0rXK4tiqlB83wsyQKBgQDzFdnRHA/HxSst6GLagd2aeRAipAFspXBSFioYqjbTvDFHNgTVlVKq8SfDrv0rOkBF6jRO29Kiz8ijfa2q+Slg/szfsZ9AgIDg2z/uRmyTOgsJ1PhigatXsYIYO/Dbgrxvhqc2PkUzz7UzqSy01Svb4cWOwwC6HgJjqNUCHKkrJwKBgQDGepxby5qBYoNR9iqoKFv4QHq5m3Xv6rDpJxgUjDD6vttYf73yT5j6IVT1kOB+sSziU571N18GUdzkpCbdTCpyXiacoBIKwRCPrqrGxDGJCabQL8EWmTmQQrulFuwaPYqXWxZUAaae0BbgC3xAFX85fVl0ueYEK4DHnBzOzMsp8wKBgQCX2R9+s+Pbq/wkKlWOH6+5rkR5DzBgmRwH+xaC39lt/NJfpIvyi9vfMtPfNnGpzjKWOg5A8Kqsz9WK45hYBFtn3uNGHWPY3C0lyXAvPUjX01tP4fzjNBM/rYAR+WelCA8EL/5GMTHzgp2zzstBjyRdr7REUOYkXViqvq2JKzQ14wKBgCOZnHAOngD1FY7e85nD23M0xY6DJu1IkEDRpU0SNDrVfuxpxT0wL8U1s1J0kP/Icb+KtilPrDiq+E7+boYlAjwPTSeswm+xX3IWJ0WNrUDiPUx8NEsEYsHQZm3fJawzO6eYS/H3ddZohqHbDYdFE9PQ+vmn2m0HDItBIh2puAsnAoGAGAu1ODiFpqCstKQYXHpUG/LBUIyr6pRpFowdculjC7hNrKJ8RJ06mEFZcBoZOmIJ3e981ugSPimypqvaeqeKZQor+XjNDjYNNG0b332UP2fOZrNYj7OaAYXHWRAp5AGOoCdXSV8AI1P3q0SoE+vsEA9saYNb1l+xQNB3rIX7Onw=";
    //公钥
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkXM1uRlZ1oajlm2SWoAzXAug+k6NdMjHtx3oUVLuqaGyze79cgsUKVqxGmuY/u+tBmfAmuwxoWm+YhDkAuLfPU1Lq7q3gc6jUiqG894bmptS51AOViW8iOusi1pN5wBPapjSS2lol9UlGsxdgDPL9ZZFi3khEzHPtstG5WsA4XTWi4GnOPiHowtwvUTS5o6z+gxb3HsXYV5kwPtDOrqho45Z/90Z7tVMRu9IGqlhMZ9n3Wjv04NCo4l8MO8QafOKKmycaepDQJqIhBj7tKE4+DgQMynhDPJTRk7TtTsbl6vfrwdO0WFvgoen/rCY+WS6Az2xD2xgoBfwur4xwEL8OwIDAQAB";
   //支付宝公钥
    public  static String ALIPAY_PUBLIC_KEY="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";
    //服务器异步通知页面
    public static String notify_url="http://localhost:8080/#/ApplyReturn";
    //服务器同步返回页面
    public static String return_url ="http://localhost:8080/#/dingdan";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    //日志路径
    public static String log_path = "C:\\";
    //返回格式
    public static String FORMAT="json";
    //编码
    public static String CHARSET="UTF-8";
    //RSA2
    public  static  String SIGNTYPE="RSA";
    // RSA2
    public static String signtype = "RSA2";
    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
