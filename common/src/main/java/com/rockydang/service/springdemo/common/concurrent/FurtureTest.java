package com.rockydang.service.springdemo.common.concurrent;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.rockydang.service.springdemo.common.util.CommonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年06月01日 20:56
 */
public class FurtureTest {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(16, 16, 1000,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        List<Long> vals = new ArrayList<>();
        vals.add(1l);
        vals.add(2l);
        vals.add(3l);
        vals.add(4l);
        vals.add(5l);
        vals.add(6l);
        vals.add(7l);
        vals.add(8l);
        List<List<Long>> multiIds = CommonUtil.splitList(vals, 3);

        System.out.println("multiIds==="+multiIds);

        List<Future> futures = new ArrayList<>();

        for (List<Long> list : multiIds) {
            final List<Long> tmpList = list;
            Future f = executor.submit(new Callable<Map<Long, Long>>() {
                @Override
                public Map<Long, Long> call() throws Exception {
                    Map<Long, Long> tmpMap = new HashMap<>();
                    try {
                        int i = 0;
                        for (long l : tmpList) {
                            i++;
                            tmpMap.put((long) i, l);
                        }

                    } catch (Exception e) {
//                        logger.error("queryMappingBatchWithKeys.error..." + e.getLocalizedMessage(), e);
                        System.out.println("queryMappingBatchWithKeys.error...");
                    }
                    return filter(tmpMap);
                }
            });
            futures.add(f);
        }


        for(Future f1 :futures){
            Map<Long, Long> resMap = (Map<Long, Long>) f1.get(500, TimeUnit.MILLISECONDS);
            System.out.println(f1+"--"+resMap);
        }
    }

    /**
     * 过滤掉map中值为0的情况
     *
     * @param tmpMap
     * @return
     */
    private static Map<Long, Long> filter(Map<Long, Long> tmpMap) {
        return Maps.filterValues(tmpMap, new Predicate<Long>() {
            @Override
            public boolean apply(Long value) {
                return value > 0 ? true : false;
            }
        });
    }
}
