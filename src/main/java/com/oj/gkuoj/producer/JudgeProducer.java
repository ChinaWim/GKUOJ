package com.oj.gkuoj.producer;

import com.oj.gkuoj.common.JudgeStatusConst;
import com.oj.gkuoj.entity.ProblemResult;
import com.oj.gkuoj.request.CodeRequest;
import com.oj.gkuoj.service.ProblemResultService;
import com.oj.gkuoj.utils.JsonUtil;
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

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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

//    @Transactional todo

    public void send(CodeRequest code) {
        //add queueing
        try {
            ProblemResult problemResult = new ProblemResult();
            problemResult.setUserId(code.getUserId());
            problemResult.setCompId(code.getCompId());
            problemResult.setSourceCode(code.getSourceCode());
            problemResult.setType(code.getType());
            problemResult.setProblemId(code.getProblemId());
            problemResult.setStatus(JudgeStatusConst.QUEUING.getStatus());
            problemResultService.insert(problemResult);
            code.setProblemResultId(problemResult.getId());

            String body = JsonUtil.obj2String(code);
            Message message = new Message(environment.getProperty("topic"), body.getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = producer.send(message);
            logger.info(Thread.currentThread().getName() + "发送消息：{}", sendResult);
        } catch (Exception e) {
            //todo
            logger.error("发送异常,{}", e.getMessage());
        }
    }

}
