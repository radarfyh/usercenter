package work.metanet.client.user;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.alibaba.cloud.nacos.registry.NacosRegistration;
import com.alibaba.cloud.nacos.registry.NacosServiceRegistry;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.common.lifecycle.Closeable;
import com.alibaba.nacos.common.utils.ThreadUtils;

/**
 * 解决报错：m.s.DubboMetadataServiceInvocationHandler Failed to invoke the method getExportedURLs in the service org.apache.dubbo.rpc.service.GenericService. Tried 1 times of the providers [172.16.0.205:20881] (1/1) from the registry localhost:9090 on the consumer 172.16.0.205 using the dubbo version 2.7.8. Last error is: Failed to invoke remote method: $invoke, provider: dubbo://172.16.0.205:20881/com.alibaba.cloud.dubbo.service.DubboMetadataService?anyhost=true&application=baas-user&bind.ip=172.16.0.205&bind.port=20881&check=false&deprecated=false&dubbo=2.0.2&dynamic=true&generic=true&group=daas-usercenter&interface=com.alibaba.cloud.dubbo.service.DubboMetadataService&loadbalance=roundrobin&metadata-type=remote&methods=getAllServiceKeys,getServiceRestMetadata,getExportedURLs,getAllExportedURLs&pid=15232&qos.enable=false&register.ip=172.16.0.205&release=2.7.8&remote.application=daas-usercenter&retries=0&revision=2.2.3.RELEASE&side=consumer&sticky=false&timeout=10000&timestamp=1629369396851&version=1.0.0, cause: message can not send, because channel is closed . url:dubbo://172.16.0.205:20881/com.alibaba.cloud.dubbo.service.DubboMetadataService?anyhost=true&application=baas-user&bind.ip=172.16.0.205&bind.port=20881&check=false&codec=dubbo&deprecated=false&dubbo=2.0.2&dynamic=true&generic=true&group=daas-usercenter&heartbeat=60000&interface=com.alibaba.cloud.dubbo.service.DubboMetadataService&loadbalance=roundrobin&metadata-type=remote&methods=getAllServiceKeys,getServiceRestMetadata,getExportedURLs,getAllExportedURLs&pid=15232&qos.enable=false&register.ip=172.16.0.205&release=2.7.8&remote.application=daas-usercenter&retries=0&revision=2.2.3.RELEASE&side=consumer&sticky=false&timeout=10000&timestamp=1629369396851&version=1.0.0
 * 应用启动后，在 `ApplicationRunner`接口的`run`方法中，调用 `springCloudAlibaba`框架中的`NacosServiceRegistry`类的`setStatus`方法，更新在注册中心的实例状态
 * https://blog.csdn.net/tianzeyong/article/details/109513113
 * @author EdisonFeng
 */
public class NacosServiceOperator implements ApplicationRunner, Closeable {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
    /**
     * nacos服务实例上线
     */
    private static final String OPERATOR_UP = "UP";
    /**
     * nacos服务实例下线
     */
    private static final String OPERATOR_DOWN = "DOWN";
 
    @Autowired
    NacosServiceRegistry nacosServiceRegistry;
 
    @Autowired
    NacosRegistration nacosRegistration;
 
    private ScheduledExecutorService executorService;
 
 
    @PostConstruct
    public void init() {
        int poolSize = 1;
        this.executorService = new ScheduledThreadPoolExecutor(poolSize, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                thread.setName("NacosServiceInstanceUpAndDownOperator");
                return thread;
            }
        });
    }
 
 
    @Override
    public void run(ApplicationArguments args) throws Exception {
        long delay_down = 5000L;  //下线任务延迟
        long delay_up = 10000L;   // 上线任务延迟
        this.executorService.schedule(new InstanceDownAndUpTask(nacosServiceRegistry, nacosRegistration, OPERATOR_DOWN), delay_down, TimeUnit.MILLISECONDS);
        this.executorService.schedule(new InstanceDownAndUpTask(nacosServiceRegistry, nacosRegistration, OPERATOR_UP), delay_up, TimeUnit.MILLISECONDS);
    }
 
    @Override
    public void shutdown() throws NacosException {
        ThreadUtils.shutdownThreadPool(executorService, logger);
    }
 
    /**
     * 服务实例上下线任务
     */
    class InstanceDownAndUpTask implements Runnable {
        private NacosServiceRegistry nacosServiceRegistry;
        private NacosRegistration nacosRegistration;
        //更新服务实例的状态 ：UP 、DOWN
        private String nacosServiceInstanceOperator;
 
        InstanceDownAndUpTask(NacosServiceRegistry nacosServiceRegistry, NacosRegistration nacosRegistration, String nacosServiceInstanceOperator) {
            this.nacosServiceRegistry = nacosServiceRegistry;
            this.nacosRegistration = nacosRegistration;
            this.nacosServiceInstanceOperator = nacosServiceInstanceOperator;
        }
 
        @Override
        public void run() {
            logger.info("===更新nacos服务实例的状态to：{}===start=", nacosServiceInstanceOperator);
            this.nacosServiceRegistry.setStatus(nacosRegistration, nacosServiceInstanceOperator);
            logger.info("===更新nacos服务实例的状态to：{}===end=", nacosServiceInstanceOperator);
 
            //上线后，关闭线程池
            if (NacosServiceOperator.OPERATOR_UP.equals(nacosServiceInstanceOperator)) {
                ThreadUtils.shutdownThreadPool(NacosServiceOperator.this.executorService, NacosServiceOperator.this.logger);
            }
        }
    }
}
