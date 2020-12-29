package com.yyb.learn.jarea.pool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Yamos
 * @description AreaThreadPool
 * @date 2020/12/28 0028 17:19
 */
@Configuration
public class AreaThreadPool {
    @Value("${area.pool.coreSize}")
    private int coreSize;

    @Value("${area.pool.maxSize}")
    private int maxSize;

    @Value("${area.pool.queueCapacity}")
    private int queueCapacity;

    @Value("${area.pool.keepAliveSeconds}")
    private int keepAliveSeconds;

    @Value("${area.pool.awaitTerminationSeconds}")
    private int awaitTerminationSeconds;

    @Value("${area.pool.threadNamePrefix}")
    private String threadNamePrefix;


    public void setCoreSize(int coreSize) {
        this.coreSize = coreSize;
    }

    public int getCoreSize() {
        return coreSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setKeepAliveSeconds(int keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }

    public int getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    public void setAwaitTerminationSeconds(int awaitTerminationSeconds) {
        this.awaitTerminationSeconds = awaitTerminationSeconds;
    }

    public int getAwaitTerminationSeconds() {
        return awaitTerminationSeconds;
    }

    public void setThreadNamePrefix(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    public String getThreadNamePrefix() {
        return threadNamePrefix;
    }

    @Bean(name = "area-executor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(coreSize);
        executor.setMaxPoolSize(maxSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
