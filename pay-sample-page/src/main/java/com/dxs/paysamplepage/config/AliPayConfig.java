package com.dxs.paysamplepage.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.dxs.paysamplepage.constants.AliPayConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Dennis on 2018/11/20.
 * 支付宝 配置类
 */
@Configuration
public class AliPayConfig {

    /**
     * AliPayClient 实例 单例
     * alipayClient只需要初始化一次，后续调用不同的API都可以使用同一个alipayClient对象。
     * @return
     */
    @Bean(name = "aliPayClient")
    public AlipayClient getAliPayClient(){
        return new DefaultAlipayClient(AliPayConstant.ALIPAY_GATEWAY,
                AliPayConstant.ALIPAY_APP_ID,
                AliPayConstant.ALIPAY_APP_PRIVATE_KEY,
                AliPayConstant.ALIPAY_FORMAT,
                AliPayConstant.ALIPAY_CHARSET,
                AliPayConstant.ALIPAY_PUBLIC_KEY,
                AliPayConstant.ALIPAY_SIGN);
    }


}
