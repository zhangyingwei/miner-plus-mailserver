package com.zhangyingwei.miner.mainserver;

import com.zhangyingwei.miner.mainserver.common.config.MinerConfig;
import com.zhangyingwei.miner.mainserver.common.exception.MinerMailServerException;
import com.zhangyingwei.miner.mainserver.mail.MailSender;

/**
 * Created by zhangyw on 2017/8/23.
 */
public class MinerMailServerApplication {
    public static void main(String[] args) throws MinerMailServerException {
        MinerConfig.load(args);
        new MailSender().send();
    }
}
