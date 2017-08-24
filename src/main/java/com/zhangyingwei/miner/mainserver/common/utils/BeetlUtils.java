package com.zhangyingwei.miner.mainserver.common.utils;

import com.zhangyingwei.miner.mainserver.repertory.model.Content;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyw on 2017/8/24.
 */
public class BeetlUtils {
    private static final String TEMPLAGE = "/template.html";
    private static ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("mail");
    private static Configuration cfg;
    static {
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);

    public static String formateTemplage(Map<String,List<Content>> contents){
        Template t = gt.getTemplate(TEMPLAGE);
        t.binding(contents);
        return t.render();
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("测试",new ArrayList(){{
            Content content = new Content();
            content.setTopic("测试");
            content.setTitle("测试title");
            add(content);
        }});
        System.out.println(BeetlUtils.formateTemplage(new HashMap(){
            {
                put("items", map);
            }
        }));
    }

}
