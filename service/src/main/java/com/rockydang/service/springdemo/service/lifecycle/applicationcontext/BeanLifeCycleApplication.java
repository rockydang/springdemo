package com.rockydang.service.springdemo.service.lifecycle.applicationcontext;

import com.rockydang.service.springdemo.service.lifecycle.Car;
import org.apache.xpath.SourceTree;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 文件描述。
 *
 * @author yanxiao
 * @since 2016年10月04日 15:41
 */
public class BeanLifeCycleApplication {

    private static void lifeCycleInBeanFactory() {
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("spring/spring-lifecycle_applicationcontext.xml");
        System.out.println("lifeCycleInBeanFactory start...");
        ApplicationContext   applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-lifecycle_applicationcontext.xml");
        System.out.println("1111111");

        Car car = (Car) applicationContext.getBean("car");
        System.out.println("2222");
        car.introduce();

        System.out.println("instantation bean...");
        Car car2 = (Car) applicationContext.getBean("car");
        System.out.println("33333");
        car2.introduce();

//((ClassPathXmlApplicationContext)applicationContext).close();
        //关闭容器的钩子方法
        ((ClassPathXmlApplicationContext) applicationContext).registerShutdownHook();

        System.out.println("lifeCycleInBeanFactory end...");

    }

    public static void main(String[] args) {
        lifeCycleInBeanFactory();
    }
}
