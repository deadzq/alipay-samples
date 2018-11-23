package com.dxs.paysamplepage.constants;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Dennis on 2018/11/20.
 */
@Configuration
public class AliPayConstant {

    // TODO: 支付宝网关（固定）  此处沙箱环境配置
    public static final String ALIPAY_GATEWAY = "https://openapi.alipaydev.com/gateway.do";

    // APPID 即创建应用后生成
    public static final String ALIPAY_APP_ID = "应用ID";

    // 开发者私钥，由开发者自己生成
    public static final String ALIPAY_APP_PRIVATE_KEY = "";

    // 支付宝公钥，由支付宝生成
    public static final String ALIPAY_PUBLIC_KEY = "";

    //回调地址  (内网穿透 natapp)
    public static final String ALIPAY_NOTIFY_URL = "http://rap9sr.natappfree.cc/alipay/notify";

    // 同步返回地址，HTTP/HTTPS开头字符串
    public static final String ALIPAY_RETURNA_URL = "http://rap9sr.natappfree.cc/alipay/return";

    // 签名方式
    public static final String ALIPAY_SIGN = "RSA2";

    // 编码格式
    public static final String ALIPAY_CHARSET = "UTF-8";

    public static final String ALIPAY_FORMAT = "json";

}
