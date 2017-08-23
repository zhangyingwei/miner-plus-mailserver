package com.zhangyingwei.miner.mainserver.repertory.controller;

import com.zhangyingwei.miner.mainserver.common.exception.MinerMailServerException;
import com.zhangyingwei.miner.mainserver.mail.model.MailInfo;
import com.zhangyingwei.miner.mainserver.repertory.model.Content;
import com.zhangyingwei.miner.mainserver.repertory.model.Subscribe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by zhangyw on 2017/8/23.
 */
public class MailController {

    private SubscribeController subscribeController;
    private ContentController contentController;

    public MailController() {
        this.subscribeController = new SubscribeController();
        this.contentController = new ContentController();
    }

    public List<MailInfo> getMainInfos() throws MinerMailServerException {
        List<Subscribe> subs = this.subscribeController.listSubscribeValid();
        List<String> topics = subs
                .stream()
                .map(sub -> sub.getTopics()).flatMap(item -> Arrays.stream(item.split(",")))
                .distinct().collect(Collectors.toList());
        List<Content> conts = this.contentController.listContentNew(String.join(",", topics));
        Map<String, Content> contMap = conts.stream().collect(Collectors.toMap(Content::getTopic, content -> content));

        subs.stream().map(sub -> {
            String tops = sub.getTopics();
            List<Content> cons = Arrays.stream(tops.split(",")).map(top -> contMap.get(top)).collect(Collectors.toList());
            return cons;
        });

        return null;
    }
}
