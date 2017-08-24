package com.zhangyingwei.miner.mainserver.repertory.service;

import com.zhangyingwei.miner.mainserver.common.exception.MinerMailServerException;
import com.zhangyingwei.miner.mainserver.common.utils.MybatisUtils;
import com.zhangyingwei.miner.mainserver.repertory.mapper.SubscribeMapper;
import com.zhangyingwei.miner.mainserver.repertory.model.Subscribe;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by zhangyw on 2017/8/23.
 */
public class SubscribeService implements ISubscribeService {

    private SubscribeMapper subscribeMapper = MybatisUtils.getMapper(SubscribeMapper.class);
    private Logger logger = Logger.getLogger(SubscribeService.class);

    public List<Subscribe> listSubscribeValid() throws MinerMailServerException {
        try {
            logger.info("ListSubsctibe sate:" + Subscribe.FLAG_VALID);
            return this.subscribeMapper.listSubscribesByFlag(Subscribe.FLAG_VALID);
        } catch (Exception e) {
            throw new MinerMailServerException(e);
        }
    }
}
