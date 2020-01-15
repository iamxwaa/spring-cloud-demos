# spring-cloud-demos

spring cloud 示例

## 依赖组件

vendor 目录下放置以下组件

- nacos-server-1.2.0-SNAPSHOT
- h2

## 模块说明

- service-common-demo 公共组件代码
- service-provider-demo 服务提供者
- service-consumer-demo 服务消费者
- spring-gateway-demo 服务网关
- zipkin-server-demo 服务调用追踪
  
## 使用

- 使用 nacos-start.bat 启动nacos
- 访问 <http://localhost:8848> (默认账号密码: nacos/nacos)
- 导入 nacos 目录下配置
- 启动 zipkin-server-demo
- 启动 service-provider-demo
- 启动 service-consumer-demo
- 启动 spring-gateway-demo
