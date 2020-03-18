package com.orieange.demo.kafka.producer.impl;

import com.orieange.demo.kafka.producer.KafkaProducerService;
import com.orieange.demo.utils.FastJsonUtils;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

/**
 * @author: jianglong
 * @description: kafka发送消息接口实现
 * @date: 2019-09-24
 */
@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Resource
    private Executor executor;

    /**发送消息*/
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic , Object msgData){
        executor.execute(() ->{
            ProducerRecord record = new ProducerRecord<String, String>(topic, null, null, FastJsonUtils.ObjectTojson(msgData));
            kafkaTemplate.send(record);
//            kafkaTemplate.send(topic, FastJsonUtils.ObjectTojson(msgData));
        });
    }
}
