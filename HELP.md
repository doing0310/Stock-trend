# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-template-engines)
* [jsoup]()
* [websocket]()

### 爬虫 jsoup
主要爬同花顺和东方财富的北上资金:

* 跑批前一天的东方财富北上资金个股的持有市值
* 股票开盘定时跑现在同花顺上北上资金个股的持有市值
* 两个相减判断每时段北上资金流入个股有多少
* 界面使用websocket实时监控北上资金流入到一定值并预警（未完成）

