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
    public static final String ALIPAY_APP_ID = "2016092200570067";

    // 开发者私钥，由开发者自己生成
    public static final String ALIPAY_APP_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDqs2TamRyaoKHbEaqv+rQbxnEa+QuohqHDmjzg8C2+yYLOxqea0K4nybsIgxWK+SlkjrhhvwNieRN36Udxva5hTXGEGxkzZDDPviCFj1ARcHz0cL9pzeZ6YG4d0GFMe4sXgDE/Ntgm9d0IjTFbH8+32q93QLwtbE7BvZSQLQaFUQcA+/LijSd0QXENZb/eNBBkE2dKaVzZJm29IiZP1rx5wrruli90sRgTYMCckePFJm8r1tnuCHhBjwmtrBI1BCYDc8iIfg+Zudffjmf9RnmtLTarOUrE6P/zLU4PZOrcNPUyHcLWABHsy1Tsazceji/GtfgWUyLOzxoQxoR0DavVAgMBAAECggEBAKPqNHbDVonbxA7m8MnFE0MOvfGzm+PQW2vr7ba/p4NG43ecoHPsaKVbK6gPPN15lOIpFzcVG70LiIBHyWDzs7U7TBuSfXA5+iksxTPiWm5DnNFvaQ/xAJXZgS6LWVj8M7FvE3XtzNqw/fU5/w2AUyc5sTBdYs9qhDqlN/vVpmc2UIPw9L75iIaC3toyLhmiI9XbK6y00eDSMMq2g/jg8z5arSsvCgSrZVkqEt6VfG1cP7i3XOBHvFvP/IFSf0mF9Cr6bRosy4gc6c6W9Axnh2CTXc0FEpKkFxWCUjzWO49mYso8fjA+/3N3cHg0elCnQnTJigt+kipanxlzynQ24gECgYEA9rSjnYriAz7hen6fr0pBTWJnPIhZ9l1TVAzmKblv/QT75tbZ4WrnVeZZUCz7V/HERrttZdAe4k8Kfre3uWjxu9yp62i8zZZXjjXjs1gk147EVbHJq3k8//HfvRXbxyWe9XNLlk1PsOAsWVAkQWe6QCbLA4Z/W4aomTas8XDTE4ECgYEA84r5ODKI3UbsdXJ2IIfGxQrcpQug5onw7LnxMULAgS/ZJf+Pql1Rc5+yFVOrzivlOxvjnSklPkuf3PbpL2+07xfm7jJAchpV2tVcdITC1+Jhe5B9EI0UOm6042pjzbjSzkKWGiPLchPb62uoMTk+YIDqXQdhjxD/mG/+muSpMlUCgYEA8yIbjYvuKlyyQtK/9TUtHmK4c4O9hXt8P/1maACFScq7p0he+jUtQA8APm/WVVnDoiHdMtXlWgujwDa3LlcqxYY3P/W8/LAKIfEiMwHPbVEaVYodwox9fZCWe/cq3h1Jh4TVHY+b1ilYC71bvcnIWKjistq+cSlIx5aG4nvaygECgYEAqMksJ9J+ID1DK7KEQ89V5sG8YXZJsPzwyF+l1SoaGG585GTVwJCkHqoS1c0DSQQK/og5m3YkpaPry0wkGAgnMX0zQun42BuAXQV56hcIom32eZiN1Kax2j1XiDT3rl/lWaW0ObGNEibJR8N48YRmwqMVyhuPdYOmYJNdtSO8T3ECgYBCdZ3NtTEvUQjAHp6t5cOPq8vEeWDK4ga/JsXZWAEOLQU8ccRs2U7zu3zThyHyEB87SRTsr5NoM2x/F+e3lPgqq27rtwHja2FXL+lNnM3Gc5+Otj2+UUFerWJ0RPePOgAXFaqF//QId1NaQQ2qYYUesHSBJJ5ESi/5msStC6EnHg==";

    // 支付宝公钥，由支付宝生成
    public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAt8oI5hS6jWbkjyD9pAxH2NK5ekgP4043YRZul3NEHNX+3TtimhM1RCti5ERQiVCnSGKbIv4YhCq1iCOsNGKK3LDuUl9qPZUE3SFLhVja+Ljobda9KRMa7u1k9YUXUwhleDxS00374hxdZgfxv5ZQl8tB0S2cwFXSyataB8ru8HqNF4NFQuA1rtrpQJGgAi/JRnvq0z4/ZzuKT1zd2WH86wmvb0CGBXuJ6r4ubwgIrMs2qrKVblbMt60gjUImj604L/xSUfkHArq8dqzeVrjv+pzAzHFPML9SvIiZ8aNte+LlJdenqtARr89qEV0e/JXxJHugRdSJwPzmn0GS/O1w/wIDAQAB";

    //回调地址
    public static final String ALIPAY_NOTIFY_URL = "http://rap9sr.natappfree.cc/alipay/notify";

    // 同步返回地址，HTTP/HTTPS开头字符串
    public static final String ALIPAY_RETURNA_URL = "http://rap9sr.natappfree.cc/alipay/return";

    // 签名方式
    public static final String ALIPAY_SIGN = "RSA2";

    // 编码格式
    public static final String ALIPAY_CHARSET = "UTF-8";

    public static final String ALIPAY_FORMAT = "json";

}
