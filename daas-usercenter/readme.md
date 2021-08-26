# 用户中心服务

## bug说明

### 1、failed to request

```
2021-08-20 12:48:21.722 ERROR 1888 [ main] c.a.n.c.naming : [NA] failed to request

com.alibaba.nacos.api.exception.NacosException: caused: Get data failed, key: com.alibaba.nacos.naming.iplist.public##DEFAULT_GROUP@@providers:com.alibaba.cloud.dubbo.service.DubboMetadataService:1.0.0:daas-usercenter;
```

这个问题是nacos 4.x的一个bug，参考：
https://github.com/alibaba/nacos/commit/25a8bf696b43b42694fd6e9d6c495190a89c5eed
