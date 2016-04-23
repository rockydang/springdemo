package com.mogujie.service.springdemo.common.json.fastjson;

import com.alibaba.fastjson.JSONPath;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yanxiao on 16/4/19.
 */
public class JsonPathTest {

    @Test
    public void testParseJson() throws Exception {

        Entity entity = new Entity(123, new Object());

        Assert.assertSame(entity.getValue(), JSONPath.eval(entity, "$.value"));
        Assert.assertTrue(JSONPath.contains(entity, "$.value"));
        Assert.assertTrue(JSONPath.containsValue(entity, "$.id", 123));
        Assert.assertTrue(JSONPath.containsValue(entity, "$.value", entity.getValue()));
        Assert.assertEquals(2, JSONPath.size(entity, "$"));
//        Assert.assertEquals(0, JSONPath.size(new Object[],"$"));
    }
}