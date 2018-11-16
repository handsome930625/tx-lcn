package com.codingapi.tm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * create by lorne on 2017/11/11
 *
 * @author wangyijie
 */
@Component
public class ConfigReader {
    /**
     * netty 端口
     */
    @Value("${tm.socket.port}")
    private int socketPort;
    /**
     * netty最大连接数
     */
    @Value("${tm.socket.maxconnection}")
    private int socketMaxConnection;
    /**
     * 业务模块与TxManager之间通讯的心跳时间（单位：秒）
     */
    @Value("${tm.transaction.netty.hearttime}")
    private int transactionNettyHeartTime;
    /**
     * 该字段代表的是Tx-Client模块与TxManager模块之间的最大通讯时间，超过该时间未响应本次请求失败。
     */
    @Value("${tm.transaction.netty.delaytime}")
    private int transactionNettyDelayTime;
    /**
     * 存储到redis下的数据最大保存时间（单位：秒）
     * 该字段仅代表的事务模块数据的最大保存时间，补偿数据会永久保存。
     */
    @Value("${tm.redis.savemaxtime}")
    private int redisSaveMaxTime;
    /**
     * 事务补偿记录回调地址(rest api 地址，post json格式)
     */
    @Value("${tm.compensate.notifyUrl}")
    private String compensateNotifyUrl;
    /**
     * 事务自动补偿 (true:开启，false:关闭)
     */
    @Value("${tm.compensate.auto}")
    private boolean isCompensateAuto;
    /**
     * 补偿失败，再次尝试间隔（秒），最大尝试次数3次，当超过3次即为补偿失败,失败的数据依旧还会存在TxManager下
     */
    @Value("${tm.compensate.tryTime}")
    private int compensateTryTime;
    /**
     * 各事务模块自动补偿的时间上限(毫秒)
     */
    @Value("${tm.compensate.maxWaitTime}")
    private int compensateMaxWaitTime;
    /**
     * 事务默认数据的位置，有最大时间
     */
    private final String key_prefix = "tx:manager:default:";
    /**
     * 负载均衡模块存储信息
     */
    private final String key_prefix_loadbalance = "tx:manager:loadbalance:";
    /**
     * 补偿事务永久存储数据
     */
    private final String key_prefix_compensate = "tx:manager:compensate:";

    public String getKeyPrefixLoadbalance() {
        return key_prefix_loadbalance;
    }

    public String getCompensateNotifyUrl() {
        return compensateNotifyUrl;
    }

    public String getKeyPrefix() {
        return key_prefix;
    }

    public String getKeyPrefixCompensate() {
        return key_prefix_compensate;
    }

    public int getSocketPort() {
        return socketPort;
    }

    public int getSocketMaxConnection() {
        return socketMaxConnection;
    }

    public int getTransactionNettyHeartTime() {
        return transactionNettyHeartTime;
    }

    public int getRedisSaveMaxTime() {
        return redisSaveMaxTime;
    }

    public int getTransactionNettyDelayTime() {
        return transactionNettyDelayTime;
    }

    public boolean isCompensateAuto() {
        return isCompensateAuto;
    }

    public int getCompensateTryTime() {
        return compensateTryTime;
    }

    public int getCompensateMaxWaitTime() {
        return compensateMaxWaitTime;
    }
}
