## 演示目的

演示web应用流控降级接入。

## 步骤

1. 下载[sentinel-dashboard-1.4.1.jar](https://github.com/alibaba/Sentinel/releases/download/1.4.1/sentinel-dashboard-1.4.1.jar)，[OSS备份](http://ahas-debug-beijing.oss-cn-beijing.aliyuncs.com/ASummit2019/dashboard/sentinel-dashboard-1.4.1.jar)。
2. 启动控制台：通过如下命令启动控制台：
    ```shell
    java -Dserver.port=8081 -Dcsp.sentinel.dashboard.server=localhost:8081 \
        -Dproject.name=sentinel-dashboard -Dcsp.sentinel.log.use.pid=true \
        -jar sentinel-dashboard-1.4.1.jar 
    ```
3. 启动客户端：通过如下参数启动本程序：
    ```shell
    -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8081
    ```
4. 构造流量：手动访问`localhost:8080/hello?msg=ASummit2019` 或者执行`./autorun.sh`脚本
5. 控制台管理：访问控制台`localhost:8081`，通过控制台配置流控降级规则，然后通过监控看流控降级效果。

## 效果

- 客户端有访问量之后，可以在控制台看到该应用。
- 配置流控降级规则之后，客户端会看到block页面，控制台监控上能看到监控曲线。


## 备选方案

如果现场出现网速慢，控制台jar包无法下载的情况，可直接使用公有云控制台，步骤如下：

1. 开通：访问[公有云控制台](http://ahas.console.aliyun.com)，按步骤开通账号；
2. 接入：打开控制台后选择"流控降级"菜单，右上角点击"应用接入" 按步骤接入；
3. 启动客户端：按启动参数启动程序；
4. 控制台管理：通过控制台配置流控降级规则，然后通过监控看流控降级效果。
