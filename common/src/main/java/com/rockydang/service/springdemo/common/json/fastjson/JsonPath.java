package com.rockydang.service.springdemo.common.json.fastjson;

import com.alibaba.fastjson.JSONPath;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by yanxiao on 16/4/19.
 */
public class JsonPath {

    public void parseJson(){
        System.out.println("123");
    }

    public static void main(String[] args) {
        List<Entity> entities = new ArrayList<Entity>();
        entities.add(new Entity("wenshao"));
        entities.add(new Entity("ljw2083"));

        List<String> names = (List<String>) JSONPath.eval(entities, "$.name"); // 返回enties的所有名称
//        Assert
//        Assert.assertSame(entities.get(0).getName(), names.get(0));
//        Assert.assertSame(entities.get(1).getName(), names.get(1));
    }
}
