package com.rockydang.service.springdemo.common.util;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

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

    public void testBeanUtil() {
        Student student1 = new Student();
        student1.setName("aston");
//        student1.setScore(1);
        Student2 student2 = new Student2();
        try {
            BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
            //默认为null，而不是0
            beanUtilsBean.getConvertUtils().register(new IntegerConverter(null), Integer.class);
            beanUtilsBean.getConvertUtils().register(new LongConverter(null), Long.class);

            beanUtilsBean.copyProperties(student2, student1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
       /* try {
            PropertyUtils.copyProperties(student2, student1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }*/
        System.out.println("student2=" + student2);
    }

    public static void main(String[] args) {
      /*
       Supplier<CommonUtil> supplier = CommonUtil::new;
        supplier.get().testBeanUtil();
        */

        try {
            System.out.println(SizeOfObject.fullSizeOf(new Object()));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
