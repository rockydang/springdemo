package com.rockydang.service.springdemo.service.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by yanxiao on 2017/8/10.
 */
public class ProcessUserMap {

    public void processFile() throws IOException {
        InputStream is = null;
        BufferedReader reader = null;

        List<Long> allUserList = Lists.newArrayList();
        List<Long> mutilUserList = Lists.newArrayList();
        Map<Long, Integer> userMutilMap = Maps.newHashMap();
        System.out.println("--------");
        try {
            is = new FileInputStream(new File("/Users/yanxiao/Desktop/待发券用户_0815"));
            String tempString;
            reader = new BufferedReader(new InputStreamReader(is));
            while ((tempString = reader.readLine()) != null) {
                Long userId = NumberUtils.toLong(tempString);
                if (allUserList.contains(userId)) {
                    mutilUserList.add(userId);
                    userMutilMap.put(userId, MapUtils.getIntValue(userMutilMap, userId, 0) + 1);
                }
                allUserList.add(userId);
            }
//            System.out.println("allUserList size=" + allUserList.size());
//            System.out.println("mutilUserList size=" + mutilUserList.size());
//            System.out.println("userMutilMap size=" + userMutilMap.size());
            System.out.println("userMutilMap" + userMutilMap);
//            userMutilMap.forEach((key, value) -> System.out.println(key));


            userMutilMap.forEach((key, value) -> {
                if(value >1){
                    System.out.println(key+"_"+value);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
            if (reader != null) {
                reader.close();
            }

        }
        System.out.println("--------");
    }

    public static void main(String[] args) throws IOException {
        ProcessUserMap processUserMap = new ProcessUserMap();
        processUserMap.processFile();
    }
}
