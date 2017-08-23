package com.zhangyingwei.miner.mainserver.mail.model;

/**
 * Created by zhangyw on 2017/8/23.
 */
public class MailInfo {
    private String to;
    private String title;
    private String content;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MailInfo{" +
                "to='" + to + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
