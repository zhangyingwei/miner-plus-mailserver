package com.zhangyingwei.miner.mainserver.repertory.service;

import com.zhangyingwei.miner.mainserver.common.exception.MinerMailServerException;
import com.zhangyingwei.miner.mainserver.repertory.model.Subscribe;

import java.util.List;

/**
 * Created by zhangyw on 2017/8/23.
 */
public interface ISubscribeService {
    List<Subscribe> listSubscribeValid() throws MinerMailServerException;
}
