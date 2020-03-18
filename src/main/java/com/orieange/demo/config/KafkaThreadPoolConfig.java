package com.orieange.demo.config;

import com.orieange.demo.kafka.comsumer.KafkaProducerListener;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: jianglong
 * @description: kafka线程池配置参数
 * @date: 2019-09-24
 */
@Component
@ConfigurationProperties(prefix = "kafka.threadlistener")
@Getter
@Setter
@ToString
public class KafkaThreadPoolConfig {
    /**配置线程池大小*/
    private Integer corePoolSize; //配置核心线程数
    private Integer maxPoolSize; //配置最大线程数
    private Integer poolQueueCapacity; //配置队列大小
    private String threadNamePrefix;//配置线程池中的线程的名称前缀
    private Boolean visiblePool;//是否打印线程信息
    /**配置kafka回调监听器*/
    private Boolean visibleLog;
    private Integer listenerQueueSize;

    @Bean
    public KafkaProducerListener kafkaProducerListener() {
        BlockingQueue<String> blockingDeque = new ArrayBlockingQueue<>(listenerQueueSize);
        return new KafkaProducerListener(blockingDeque, this.visibleLog);
    }
}
