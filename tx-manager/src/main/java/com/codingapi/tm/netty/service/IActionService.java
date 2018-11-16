package com.codingapi.tm.netty.service;

import com.alibaba.fastjson.JSONObject;

/**
 * create by lorne on 2017/11/11
 *
 * @author wangyijie
 */
public interface IActionService {

    /**
     * description: 处理tm的各种请求
     *
     * @param channelAddress 部件地址
     * @param key            动作
     * @param params         请求参数
     * @return 处理结果
     * @author 王亦杰（yijie.wang01@ucarinc.com）
     * @date 2018/11/13 9:34
     */
    String execute(String channelAddress, String key, JSONObject params);

}
