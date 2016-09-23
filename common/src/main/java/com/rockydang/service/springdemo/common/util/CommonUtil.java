package com.rockydang.service.springdemo.common.util;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年06月01日 21:06
 */
public class CommonUtil {

    private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);

    public static <T> List<List<T>> splitList(List<T> list, int pageSize) {
        List<List<T>> multiIds = new ArrayList<>();
        try {
            if (CollectionUtils.isEmpty(list)) {
                return multiIds;
            }

            List<T> onceIds = new ArrayList<>(pageSize);
            int idx = 0;

            while (true) {
                onceIds.add(list.get(idx));
                if (onceIds.size() >= pageSize) {
                    multiIds.add(onceIds);
                    onceIds = new ArrayList<>(pageSize);
                }
                idx++;
                if (idx == list.size()) {
                    multiIds.add(onceIds);
                    break;
                }
            }
        } catch (Exception e) {
            logger.error("splitList error..." + e.getLocalizedMessage(), e);
        }
        return multiIds;
    }
}
