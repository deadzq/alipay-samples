package com.dxs.paysamplepage.controller;

import com.alipay.api.AlipayApiException;
import com.dxs.paysamplepage.pay.AliPay;
import com.dxs.paysamplepage.pay.params.PagePayParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Dennis on 2018/11/20.
 */
@RestController
@RequestMapping("/alipay")
public class OrderController {


    @Autowired
    private AliPay aliPay;


    /**
     * 下单结算
     * @return
     */
    @RequestMapping(value = "/pay.action", method = RequestMethod.POST)
    public String index(){

        PagePayParam param = new PagePayParam();
        param.setOut_trade_no(UUID.randomUUID().toString().replaceFirst("-",""));
        param.setTotal_amount("2222.22");
        param.setSubject("nelson-test-title");
        param.setProduct_code("FAST_INSTANT_TRADE_PAY"); //这个是固定的

        return aliPay.pay(param);
    }



    /**
     * 支付异步回调
     * @return
     */
    @RequestMapping(value = "notify", method = RequestMethod.POST)
    public String alipayNotify(HttpServletRequest request, String out_trade_no, String trade_no, String trade_status){


        boolean signVerified = false;
        try {
            signVerified = aliPay.checkSign(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return ("fail");// 验签发生异常,则直接返回失败
        }
        if (signVerified) {

            System.out.println("*******************************异步回调***************************");

            //处理你的业务逻辑，更细订单状态等
            return ("success");
        } else {
            System.out.println("验证失败,不去更新状态");
            return ("fail");
        }
    }




    /**
     * 支付宝 RETURN_URL
     * @param params
     * @param request
     * @param out_trade_no
     * @param trade_no
     * @param total_amount
     * @return
     */
    @RequestMapping(value = "return", method = RequestMethod.GET)
    public String alipayReturn(Map<String, String> params, HttpServletRequest request, String out_trade_no,String trade_no,String total_amount){

        boolean signVerified = false;
        try {
            signVerified = aliPay.checkSign(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return ("fail");// 验签发生异常,则直接返回失败
        }
        if (signVerified) {
            System.out.println("*******************************同步返回***************************");

            return ("success");
        } else {
            System.out.println("验证失败,不去更新状态");
            return ("fail");
        }
    }




}
