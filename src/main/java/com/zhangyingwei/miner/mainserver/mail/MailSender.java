package com.zhangyingwei.miner.mainserver.mail;

import com.zhangyingwei.miner.mainserver.common.exception.MinerMailServerException;
import com.zhangyingwei.miner.mainserver.common.utils.MinerMailUtils;
import com.zhangyingwei.miner.mainserver.mail.model.MailInfo;
import com.zhangyingwei.miner.mainserver.repertory.controller.MailController;
import com.zhangyingwei.smail.Smail;
import com.zhangyingwei.smail.config.SmailConfig;
import com.zhangyingwei.smail.exception.SmailException;
import org.apache.log4j.Logger;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangyw on 2017/8/24.
 */
public class MailSender {

    private Logger logger = Logger.getLogger(MailSender.class);
    private MailController mailController;
    private String username = MinerMailUtils.getConfig("miner.mail.username");
    private String password = MinerMailUtils.getConfig("miner.mail.password");

    public MailSender() {
        this.mailController = new MailController();
    }

    /**
     * 每次发送之前随机等待 1-10 秒
     * 主要是为了应对各种不可预见的封号情况
     * @throws MinerMailServerException
     */
    public void send() throws MinerMailServerException {
        List<MailInfo> mails = this.mailController.getMainInfos();
        logger.info("mail size:" + mails.size());
        Random random = new Random();
        mails.forEach(mail -> {
            try {
                new Smail(new SmailConfig().setStarttls(true).setNikename("Miner"))
                        .auth(username, password)
                        .to(mail.getTo())
                        .send(mail.getTitle(), mail.getContent());
                TimeUnit.SECONDS.sleep(random.nextInt(10));
                logger.info("send: "+ mail);
            } catch (UnsupportedEncodingException | MessagingException | SmailException e) {
//                e.printStackTrace();
                logger.error(e.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
