package com.zhangyingwei.miner.mainserver.repertory.service;

import com.zhangyingwei.miner.mainserver.common.exception.MinerMailServerException;
import com.zhangyingwei.miner.mainserver.repertory.model.Content;

import java.util.List;

/**
 * Created by zhangyw on 2017/8/23.
 */
public interface IContentService {
    List<Content> listContentsValidByTopics(String topics,String day) throws MinerMailServerException;
}
