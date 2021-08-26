# 业务层用户服务

## bug说明

### 1、No provider available from registry localhost:9090

```
2021-08-21 14:26:25.854 ERROR 548 --- [nio-8889-exec-3] o.a.c.c.C.[.[.[.[dispatcherServlet]      : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is org.apache.dubbo.rpc.RpcException: No provider available from registry localhost:9090 for service work.metanet.server.usercenter.service.UsersService on consumer 172.16.0.205 use dubbo version 2.7.8, please check status of providers(disabled, not registered or in blacklist).] with root cause

org.apache.dubbo.rpc.RpcException: No provider available from registry localhost:9090 for service work.metanet.server.usercenter.service.UsersService on consumer 172.16.0.205 use dubbo version 2.7.8, please check status of providers(disabled, not registered or in blacklist).
```

有人推荐使用sca2.2.5; sb2.3.3; nacos 141，参考：
https://github.com/alibaba/spring-cloud-alibaba/issues/1360
