package com.codingapi.tm.manager;

import com.codingapi.tm.model.ModelInfo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * create by lorne on 2017/11/13
 * @author wangyijie
 */
public class ModelInfoManager {

    private List<ModelInfo> modelInfos = new CopyOnWriteArrayList<>();

    private static ModelInfoManager manager = null;

    public static ModelInfoManager getInstance() {
        if (manager == null) {
            synchronized (ModelInfoManager.class) {
                if (manager == null) {
                    manager = new ModelInfoManager();
                }
            }
        }
        return manager;
    }

    public void removeModelInfo(String channelName) {
        for (ModelInfo modelInfo : modelInfos) {
            if (channelName.equalsIgnoreCase(modelInfo.getChannelName())) {
                modelInfos.remove(modelInfo);
            }
        }
    }

    public void addModelInfo(ModelInfo mInfo) {
        for (ModelInfo modelInfo : modelInfos) {
            if (mInfo.getChannelName().equalsIgnoreCase(modelInfo.getChannelName())) {
                return;
            }

            if (mInfo.getIpAddress().equalsIgnoreCase(modelInfo.getIpAddress())) {
                return;
            }
        }
        modelInfos.add(mInfo);
    }

    public List<ModelInfo> getOnlines() {
        return modelInfos;
    }

    public ModelInfo getModelByChannelName(String channelName) {
        for (ModelInfo modelInfo : modelInfos) {
            if (channelName.equalsIgnoreCase(modelInfo.getChannelName())) {
                return modelInfo;
            }
        }
        return null;
    }

    public ModelInfo getModelByModel(String model) {
        for (ModelInfo modelInfo : modelInfos) {
            if (model.equalsIgnoreCase(modelInfo.getModel())) {
                return modelInfo;
            }
        }
        return null;
    }
}
