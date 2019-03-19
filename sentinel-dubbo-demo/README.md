## 演示目的

演示Dubbo应用接入，通过Dubbo演示微服务流控降级效果。

## 步骤

1. 打开[公有云控制台](http://ahas.console.aliyun.com)，获取启动参数。
1. 启动dubbo-provider，启动参数
    ```bash
    -Djava.net.preferIPv4Stack=true -Dproject.name=dubbo-provider -Dahas.license=xxx
    ```
2. 启动dubbo-consumer，启动参数
   ```bash
   -Dserver.port=8080 -Djava.net.preferIPv4Stack=true -Dproject.name=dubbo-consumer -Dahas.license=xxx
   ```
4. 构造流量：手动访问`localhost:8080/hello?msg=ASummit2019` 或者执行`./autorun.sh`脚本
5. 控制台管理：[公有云控制台](http://ahas.console.aliyun.com)，通过控制台配置降级规则，查看流级效果。
6. 自定义Dubbo fallback逻辑，示例见`ConsumerConfig`

## 效果

- 客户端有访问量之后，可以在控制台看到该应用。
- 配置降级规则并到达降级阈值后，客户端会看到降级结果，控制台监控上能看到监控曲线。

## 备选方案

如果不想使用公有云控制台，也可使用[开源控制台](http://ahas-debug-beijing.oss-cn-beijing.aliyuncs.com/ASummit2019/dashboard/sentinel-dashboard-1.4.1.jar)，效果是一样的。

1. 需要修改pom依赖，用开源dependency替换公有云SDK
2. 然后在启动参数中加入控制台地址：`-Dcsp.sentinel.dashboard.server=localhost:8081`
3. 应用有访问量之后即可在控制台看到并管理。
