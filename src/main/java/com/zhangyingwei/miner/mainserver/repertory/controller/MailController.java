package com.zhangyingwei.miner.mainserver.repertory.controller;

import com.zhangyingwei.miner.mainserver.common.exception.MinerMailServerException;
import com.zhangyingwei.miner.mainserver.common.utils.MinerMailUtils;
import com.zhangyingwei.miner.mainserver.mail.model.MailInfo;
import com.zhangyingwei.miner.mainserver.repertory.model.Content;
import com.zhangyingwei.miner.mainserver.repertory.model.Subscribe;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zhangyw on 2017/8/23.
 */
public class MailController {

    private Logger logger = Logger.getLogger(MailController.class);
    private SubscribeController subscribeController;
    private ContentController contentController;

    public MailController() {
        this.subscribeController = new SubscribeController();
        this.contentController = new ContentController();
    }

    public List<MailInfo> getMainInfos() throws MinerMailServerException {
        List<Subscribe> subs = this.subscribeController.listSubscribeValid();
        logger.info("subs:" + subs);
        List<String> topics = subs
                .stream()
                .map(sub -> sub.getTopics()).flatMap(item -> Arrays.stream(item.split(",")))
                .distinct().collect(Collectors.toList());
        logger.info("topics:" + topics);
        List<Content> conts = this.contentController.listContentNew(String.join(",", topics));
        logger.info("content size: " + conts.size());

        List<MailInfo> mailinfos = subs.stream().map(sub -> {
            String tops = sub.getTopics();
            List<String> topList = Arrays.asList(tops.split(","));
            List<Content> constList = conts.stream().filter(content -> topList.contains(content.getTopic())).collect(Collectors.toList());
            MailInfo mailInfo = new MailInfo();
            mailInfo.setTo(sub.getEmail());
            mailInfo.setTitle(MinerMailUtils.title());
            mailInfo.setContent(MinerMailUtils.content(constList));
            logger.info("mailinfo: " + mailInfo);
            return mailInfo;
        }).collect(Collectors.toList());

        return mailinfos;
    }
}
