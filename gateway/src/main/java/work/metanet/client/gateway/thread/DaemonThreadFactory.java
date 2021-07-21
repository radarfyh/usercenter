package work.metanet.client.gateway.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @Description 守护线程池工厂类
 * @author EdisonFeng
 * @DateTime 2021年6月21日
 * Copyright(c) 2021. All Rights Reserved
 */
public class DaemonThreadFactory implements ThreadFactory {
    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
    private final AtomicInteger threadNumber;
    private final String namePrefix;

    public DaemonThreadFactory() {
        this("pool");
    }

    public DaemonThreadFactory(String prefix) {
        this.threadNumber = new AtomicInteger(1);
        this.namePrefix = prefix + "-" + POOL_NUMBER.getAndIncrement() + "-thread-";
    }

    public Thread newThread(Runnable runnable) {
        Thread t = new Thread(runnable, this.namePrefix + this.threadNumber.getAndIncrement());
        t.setDaemon(true);
        return t;
    }
}