package com.zhangyingwei.miner.mainserver.common.config;

import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyw on 2017/8/23.
 */
public class MinerConfig {
    private static Map<String, String> configMap = new HashMap<String,String>();

    public static void load(String[] args) {
        Arrays.stream(args).map(arg -> ConfigItem.of(arg)).filter(item -> item != null).forEach(item -> {
            configMap.put(item.key, item.value);
        });
    }

    public static String get(String key){
        return configMap.get(key);
    }

    static class ConfigItem{
        String key;
        String value;
        static ConfigItem of(String arg){
            ConfigItem item = new ConfigItem();
            if (StringUtils.isNotBlank(arg)) {
                String[] kv = arg.split("=");
                item.key = kv[0];
                item.value = kv[1];
            } else {
                return null;
            }
            return item;
        }
    }
}
