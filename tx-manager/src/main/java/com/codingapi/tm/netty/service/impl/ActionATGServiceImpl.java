package com.codingapi.tm.netty.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.codingapi.tm.manager.service.TxManagerService;
import com.codingapi.tm.netty.model.TxGroup;
import com.codingapi.tm.netty.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 添加事务组
 * create by lorne on 2017/11/11
 *
 * @author wangyijie
 */
@Service(value = "atg")
public class ActionATGServiceImpl implements IActionService {

    @Autowired
    private TxManagerService txManagerService;

    @Override
    public String execute(String channelAddress, String key, JSONObject params) {
        String res = "";
        /*事务组id */
        String groupId = params.getString("g");
        /*唤醒TaskId */
        String taskId = params.getString("t");
        /*切面方法名称 */
        String methodStr = params.getString("ms");
        /*事务是事务组 0 否 1 是 */
        int isGroup = params.getInteger("s");

        TxGroup txGroup = txManagerService.addTransactionGroup(groupId, taskId, isGroup, channelAddress, methodStr);

        if (txGroup != null) {
            txGroup.setNowTime(System.currentTimeMillis());
            res = txGroup.toJsonString(false);
        }
        return res;
    }
}
