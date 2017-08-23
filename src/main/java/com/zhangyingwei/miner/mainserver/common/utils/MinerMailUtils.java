package com.zhangyingwei.miner.mainserver.common.utils;

import com.zhangyingwei.miner.mainserver.repertory.model.Content;
import com.zhangyingwei.miner.mainserver.repertory.model.Subscribe;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

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

    public static String content(Subscribe sub, Content content) {

        return null;
    }
}
