package com.zhangyingwei.miner.mainserver.repertory.service;

import com.zhangyingwei.miner.mainserver.common.exception.MinerMailServerException;
import com.zhangyingwei.miner.mainserver.common.utils.MybatisUtils;
import com.zhangyingwei.miner.mainserver.repertory.mapper.ContentMapper;
import com.zhangyingwei.miner.mainserver.repertory.model.Content;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by zhangyw on 2017/8/23.
 */
public class ContentService implements IContentService {
    private ContentMapper contentMapper = MybatisUtils.getMapper(ContentMapper.class);

    @Override
    public List<Content> listContentsValidByTopics(String topics,String day) throws MinerMailServerException {
        topics = "('"+topics.replaceAll(",", "','")+"')";
        try {
            return this.contentMapper.listContentsByStateAndTopic(Content.STATE_NOMAL,topics,day+"%");
        } catch (Exception e) {
            throw new MinerMailServerException(e);
        }
    }
}
