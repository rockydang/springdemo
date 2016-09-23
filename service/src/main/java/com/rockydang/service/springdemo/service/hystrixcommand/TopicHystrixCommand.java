/*
package com.rockydang.service.springdemo.service.topic.hystrixcommand;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopicHystrixCommand extends HystrixCommand<String> {

    Logger logger = LoggerFactory.getLogger(TopicHystrixCommand.class);

    //标签中心service
    TopicService topicService;

    private final String topicId;

    public TopicHystrixCommand(final TopicService topicService, final String topicId) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("commands"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("TopicHystrixCommand"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("HystrixThreadPool")));
        this.topicService = topicService;
        this.topicId = topicId;
    }

    @Override
    protected String run() throws Exception {
        String result = "";
        try {
            result = topicService.queryTopicInfo(topicId);
        } catch (Exception e) {
            logger.error("TopicHystrixCommand.run ...");
        }
        return result;
    }

    protected String getFallback() {
        logger.error("TopicHystrixCommand.getFallback error...");
        return "false...";
    }
}
*/
