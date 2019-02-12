package com.oj.gkuoj.producer;

import com.oj.gkuoj.common.JudgeStatusEnum;
import com.oj.gkuoj.entity.ProblemResult;
import com.oj.gkuoj.response.RestResponseVO;
import com.oj.gkuoj.service.ProblemResultService;
import com.oj.gkuoj.utils.JsonUtil;
import com.oj.gkuoj.utils.UUIDUtil;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

/**
 * @author m969130721@163.com
 * @date 19-1-15 下午6:10
 */
@Component
public class JudgeProducer {

    @Autowired
    private Environment environment;

    @Autowired
    private ProblemResultService problemResultService;

    private static DefaultMQProducer producer;

    private Logger logger = LoggerFactory.getLogger(JudgeProducer.class);

    @PostConstruct
    private void initMQProducer() {
        producer = new DefaultMQProducer(environment.getProperty("rocketmq.producer.group"));
        producer.setNamesrvAddr(environment.getProperty("rocketmq.nameserver"));
        producer.setRetryTimesWhenSendFailed(Integer.parseInt(environment.getProperty("rocketmq.producer.retry-times")));
        try {
            producer.start();
        } catch (MQClientException e) {
            logger.error("判题机客户端初始化失败,{}", e.getErrorMessage());
        }
    }

    @PreDestroy
    private void shutdownMQProducer() {
        if (producer != null) {
            producer.shutdown();
        }
    }

    public RestResponseVO<String> send(ProblemResult problemResult) {

        try {
            problemResult.setStatus(JudgeStatusEnum.QUEUING.getStatus());
            problemResult.setRunNum(UUIDUtil.createByAPI36());
            //add queueing
//            problemResultService.insert(problemResult);

            String body = JsonUtil.obj2String(problemResult);
            Message message = new Message(environment.getProperty("rocketmq.topic"), body.getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(message);
            logger.info("{},发送消息：{}", Thread.currentThread().getName(), sendResult);
            return RestResponseVO.createBySuccess(problemResult.getRunNum());
        } catch (Exception e) {
            logger.error("发送异常,{}", e);
            return RestResponseVO.createByErrorMessage("发送异常,请稍后再试," + e.getMessage());
        }
    }

}
