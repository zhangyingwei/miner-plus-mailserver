package com.zhangyingwei.miner.mainserver.common.config;

/**
 * Created by zhangyw on 2017/8/23.
 */
public enum Config {
    DATE_STEP("--date.step");

    private String value;

    Config(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
