package com.zhangyingwei.miner.mainserver.common.utils;

import com.zhangyingwei.miner.mainserver.repertory.model.Content;
import com.zhangyingwei.miner.mainserver.repertory.model.Subscribe;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author: zhangyw
 * @date: 2017/8/23
 * @time: 下午8:41
 * @desc:
 */
public class MinerMailUtils {
    private static final String CONFNAME = "miner-mail.properties";
    private static final String MAIL_TEMPLATE = "mail/template.html";
    private static Properties config;
    static {
        try {
            config = new Properties();
            config.load(new InputStreamReader(MinerMailUtils.class.getClassLoader().getResourceAsStream(CONFNAME)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String title() {
        return config.getProperty("miner.mail.title");
    }

    public static String content(Subscribe sub, List<Content> contents) {
        Map<String, List<Content>> map = new HashMap<String,List<Content>>();
        contents.stream().map(content -> Tuple.mk(content.getTopic(),content)).forEach(tuple -> {
            if(map.containsKey(tuple._(0))){
                map.get(tuple._(0)).add((Content) tuple._(1));
            }else{
                List<Content> list = new ArrayList<Content>();
                map.put((String) tuple._(0), list);
            }
        });
        return null;
    }

    static class Tuple<A> {

        public static <A> Tuple mk(A ... args){
            return new Tuple(args);
        }

        private A[] items;

        private Tuple(A[] items) {
            this.items = items;
        }

        public A _(int index){
            if(index < 0 || items == null || index > items.length-1){
                return null;
            }
            return items[index];
        }
    }
}
