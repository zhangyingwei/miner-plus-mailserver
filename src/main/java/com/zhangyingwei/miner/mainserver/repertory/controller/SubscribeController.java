package com.zhangyingwei.miner.mainserver.repertory.controller;

import com.zhangyingwei.miner.mainserver.common.exception.MinerMailServerException;
import com.zhangyingwei.miner.mainserver.repertory.model.Subscribe;
import com.zhangyingwei.miner.mainserver.repertory.service.ISubscribeService;
import com.zhangyingwei.miner.mainserver.repertory.service.SubscribeService;

import java.util.List;

/**
 * Created by zhangyw on 2017/8/23.
 */
public class SubscribeController {
    private ISubscribeService subscribeService;

    public SubscribeController() {
        this.subscribeService = new SubscribeService();
    }

    public List<Subscribe> listSubscribeValid() throws MinerMailServerException {
        return this.subscribeService.listSubscribeValid();
    }
}
