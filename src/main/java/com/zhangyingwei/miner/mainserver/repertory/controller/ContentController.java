package com.zhangyingwei.miner.mainserver.repertory.controller;

import com.zhangyingwei.miner.mainserver.common.config.Config;
import com.zhangyingwei.miner.mainserver.common.config.MinerConfig;
import com.zhangyingwei.miner.mainserver.common.exception.MinerMailServerException;
import com.zhangyingwei.miner.mainserver.repertory.model.Content;
import com.zhangyingwei.miner.mainserver.repertory.service.ContentService;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Optional;

/**
 * Created by zhangyw on 2017/8/23.
 */
public class ContentController {
    private ContentService contentService;

    public ContentController() {
        this.contentService = new ContentService();
    }

    public List<Content> listContentNew(String topics) throws MinerMailServerException {
        Integer step = Integer.parseInt(
                Optional.ofNullable(MinerConfig.get(Config.DATE_STEP.getValue())).orElse("0")
        );
        String date = DateTime.now().plusDays(step).toString("yyyy-MM-dd");
        return this.contentService.listContentsValidByTopics(topics, date);
    }
}
