package com.dxs.paysamplepage.pay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeCloseModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.dxs.paysamplepage.constants.AliPayConstant;
import com.dxs.paysamplepage.pay.params.PagePayParam;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Dennis on 2018/11/20.
 */
@Component
public class AliPay {


    @Autowired
    private AlipayClient aliPayClient;

    /**
     * 统一收单下单并支付页面接口 (PC场景下单并支付)
     * alipay.trade.page.pay
     * @param param
     * @return
     */
    public String pay(PagePayParam param){

        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();

        alipayRequest.setReturnUrl(AliPayConstant.ALIPAY_RETURNA_URL);
        alipayRequest.setNotifyUrl(AliPayConstant.ALIPAY_NOTIFY_URL);

        // 格式化请求参数
        String json = new Gson().toJson(param);
        // 请求参数
        alipayRequest.setBizContent(json);

        AlipayTradePagePayResponse response = null;
        try {
            response = aliPayClient.pageExecute(alipayRequest);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        if (response.isSuccess()){
            String body = response.getBody();
            return body;
        }
        return null;
    }


    /**
     * 统一收单线下交易查询
     * alipay.trade.query
     * @param orderNo
     * @return
     * @throws AlipayApiException
     */
    public String query(String orderNo) throws AlipayApiException {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        AlipayTradeQueryModel model = new AlipayTradeQueryModel();
        model.setOutTradeNo(orderNo);
        request.setBizModel(model);
        AlipayTradeQueryResponse response = aliPayClient.execute(request);
        if (response.isSuccess())
            return response.getTradeStatus();
        return null;
    }


    /**
     * 统一收单交易退款接口
     * alipay.trade.refund
     * @param out_trade_no
     * @param trade_no
     * @param refund_amount
     * @return
     * @throws AlipayApiException
     */
    public String refund(String out_trade_no, String trade_no, String refund_amount) throws AlipayApiException {

        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        AlipayTradeRefundModel model = new AlipayTradeRefundModel();
        model.setOutTradeNo(out_trade_no);
        model.setTradeNo(trade_no);
        model.setRefundAmount(refund_amount);
        request.setBizModel(model);

        AlipayTradeRefundResponse response = aliPayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }

        return null;
    }



    /**
     * 统一收单交易关闭接口
     * alipay.trade.close
     * @param tradeNo
     * @param outTradeNo
     * @param operatorId
     * @return
     * @throws AlipayApiException
     */
    public String close(String tradeNo, String outTradeNo, String operatorId) throws AlipayApiException {

        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();

        AlipayTradeCloseModel model = new AlipayTradeCloseModel();
        model.setTradeNo(tradeNo);
        model.setOutTradeNo(outTradeNo);
        model.setOperatorId(operatorId);
        request.setBizModel(model);

        AlipayTradeCloseResponse response = aliPayClient.execute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return null;
    }



    /**
     * 验证签名
     * @return
     */
    public boolean checkSign(HttpServletRequest request) throws AlipayApiException {

        Map<String, String> map = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                System.out.println(valueStr);
            }
            map.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(map, AliPayConstant.ALIPAY_PUBLIC_KEY,AliPayConstant.ALIPAY_CHARSET,AliPayConstant.ALIPAY_SIGN);

        return signVerified;
    }



}
