package com.zhangyingwei.miner.mainserver.common.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zhangyw
 * @date: 2017/8/23
 * @time: 下午8:55
 * @desc:
 */
public class FileUtils {
    public static String read(InputStream inputStream){
        InputStreamReader sReader = new InputStreamReader(inputStream);
        BufferedReader bReader = new BufferedReader(sReader);
        List<String> lines = bReader.lines().collect(Collectors.toList());
        return String.join("\n", lines);
    }
}
