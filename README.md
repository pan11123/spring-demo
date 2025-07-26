# Spring Demo 项目

## 项目概述

这是一个基于Spring Boot 3.2.5的多模块Maven项目，采用分层架构设计，包含一个简单的示例。

## 项目架构

### 模块结构
```
spring-demo/
├── demo-common/          # 公共工具模块
├── demo-domain/          # 实体类模块
├── demo-dao/            # 数据访问层模块
├── demo-service/        # 业务逻辑层模块
├── demo-web/            # Web控制器模块
└── demo-main/           # 主启动模块
```

### 技术栈
- **框架**: Spring Boot 3.2.5
- **数据库**: MySQL 8.0.33
- **连接池**: Druid 1.2.20
- **ORM**: MyBatis 3.0.4
- **工具类**: Hutool 5.8.22
- **API文档**: Knife4j 4.4.0
- **权限认证**: Sa-Token 1.44.0
- **开发工具**: Lombok 1.18.30

## 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 8.0+

## 快速开始

### 1. 数据库配置

在 `demo-main/src/main/resources/application-dev.yml` 中配置数据库连接信息：

```yaml
demo:
  datasource:
    host: localhost
    port: 3306
    database: test
    username: root
    password: 123456
```

### 2. 启动项目

```bash
# 编译项目
mvn clean compile

# 启动项目
mvn spring-boot:run -pl demo-main
```

### 3. 访问项目

- 项目地址: http://localhost:8080
- **Knife4j API文档**: http://localhost:8080/doc.html
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs

## 配置说明

### 数据源配置

项目使用Druid连接池，主要配置在 `application.yml` 中：

```yaml
spring:
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://${demo.datasource.host}:${demo.datasource.port}/${demo.datasource.database}?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true
    username: ${demo.datasource.username}
    password: ${demo.datasource.password}
```

### MyBatis配置

```yaml
mybatis:
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.nexa.demo.entity
```

### Knife4j API文档配置

项目已集成Knife4j 4.4.0，提供美观的API文档界面：

```yaml
# Knife4j配置
knife4j:
  enable: true
  production: false

# SpringDoc配置
springdoc:
  group-configs:
    - group: 'default'
      paths-to-match: '/**'
      packages-to-scan: com.nexa.demo.controller
```

**功能特性**:
- 📖 美观的API文档界面
- 🔍 在线API测试功能
- 📋 API分组管理（用户管理、系统管理等）
- 🔒 支持认证测试（Sa-Token集成）(目前实现简单的登录功能,后续需要具体实现)

## 常见问题解决方案

### 1. 启动失败：数据源配置错误

**错误信息**: `Failed to configure a DataSource: 'url' attribute is not specified`

**解决方案**:
1. 确保 `demo-main` 模块包含数据库相关依赖
2. 检查配置文件中的数据源配置
3. 确认数据库连接信息正确

### 2. MyBatis Mapper扫描问题

**错误信息**: `No MyBatis mapper was found in '[com.nexa.demo.mapper]' package`

**解决方案**:
1. 在启动类添加 `@MapperScan("com.nexa.demo.mapper")` 注解
2. 确保mapper接口在正确的包路径下
```

## 开发规范

### 代码结构
- **Controller**: 处理HTTP请求，位于 `demo-web` 模块
- **Service**: 业务逻辑处理，位于 `demo-service` 模块
- **Mapper**: 数据访问接口，位于 `demo-dao` 模块
- **Entity**: 实体类，位于 `demo-domain` 模块
- **Common**: 公共工具类，位于 `demo-common` 模块

### 包命名规范
- `com.nexa.demo.controller` - 控制器
- `com.nexa.demo.service` - 服务接口
- `com.nexa.demo.impl` - 服务实现
- `com.nexa.demo.mapper` - 数据访问接口
- `com.nexa.demo.entity` - 实体类

## API接口说明

### 用户管理接口

| 接口 | 方法 | 路径 | 说明 |
|------|------|------|------|
| 用户登录 | POST | `/user/login` | 用户登录认证 |
| 检查登录状态 | GET | `/user/isLogin` | 检查当前用户登录状态 |
| 用户退出登录 | POST | `/user/logout` | 退出当前用户登录 |

### 统一返回格式

所有API接口都使用统一的返回格式：

```json
{
  "code": 200,
  "message": "操作成功",
  "data": "具体数据",
  "timestamp": 1642665600000
}
```

## 项目状态

✅ 项目基础架构搭建完成  
✅ 数据源配置完成  
✅ MyBatis集成完成  
✅ **Knife4j API文档集成完成**  
✅ **Sa-Token权限认证集成完成**  
✅ **统一返回结果格式完成**  
✅ **详细API接口文档完善**  
✅ **项目配置说明补充完整**  
⚠️ 需要创建更多的业务功能模块  
⚠️ 需要完善单元测试

## 联系方式

- 作者: Nexa
- 创建时间: 2025/6/29

---

**注意**: 请确保MySQL数据库已启动并且连接信息配置正确，否则项目启动会失败。
