# usercenter通用框架

## 关于配置和注册

使用nacos 1.4.4 和 seata 1.4.2

## 关于远程进程通讯

使用dubbo 2.8.7

## 关于和前端接口

使用RESTful API，支持http（s） 1.1

## 关于多模块规定

1. common存放通用工具
2. common-client 存放展示层（前端接口）用到的通用工具
3. common-server 存放业务层（业务规则处理和数据处理）用到的通用工具
4. common-XXX 存放某个模块/范围的api定义，用于规定协作展示层和业务层协议和协议详情，提供三个示例：支付模块、用户模块、设备模块
5. daas-xxx 用于提供业务层某个服务，可以对应某个范围、某个业务模块、某个子系统，提供四个示例：
6. baas-xxx 用于提供展示层某个服务，可以对应某个范围、某个业务模块、某个子系统，提供三个示例：

## 业务层示例模块

	 - 支付模块payment、
	 - 用户模块usercenter、
	 - 设备模块device、
	 - 调查模块questionaire
	 
## 展示层示例模块

* 用户模块user、
* 调查模块qestionaire、
* 开放平台模块openapi