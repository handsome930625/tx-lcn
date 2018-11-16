package com.codingapi.tm.netty.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.codingapi.tm.config.ConfigReader;
import com.codingapi.tm.netty.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 心跳包 处理类
 * create by lorne on 2017/11/11
 *
 * @author wangyijie
 */
@Service(value = "h")
public class ActionHServiceImpl implements IActionService {

    @Autowired
    private ConfigReader configReader;

    private String transactionNettyDelayTime = null;

    @Override
    public String execute(String channelAddress, String key, JSONObject params) {
        if (transactionNettyDelayTime == null) {
            transactionNettyDelayTime = String.valueOf(configReader.getTransactionNettyDelayTime());
        }
        return transactionNettyDelayTime;
    }
}
