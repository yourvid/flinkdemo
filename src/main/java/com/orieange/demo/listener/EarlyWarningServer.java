package com.orieange.demo.listener;

import com.orieange.demo.flink.factory.ExecutionEnvFactory;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.springframework.stereotype.Component;

@Component
public class EarlyWarningServer implements BootstrapServer {
    @Override
    public void start() {
        try {
            // 1.创建运行环境并加载运行配置
            final ParameterTool parameterTool = ExecutionEnvFactory.createParameterTool();
            StreamExecutionEnvironment env = ExecutionEnvFactory.createStreamExecutionEnvironment(parameterTool);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
