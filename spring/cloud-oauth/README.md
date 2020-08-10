oauth2-X 认证授权服务 支持authorization_code 和 password 两种oauth2的模式

- oauth2-memory token存放在内存
- oauth2-jdbc token存放在数据库
- oauth2-jwt 用户信息存放在token, 使用jwt存储协议的格式, 使用RSA非对称加密
- resource 资源服务
- dependency 依赖管理
    - spring 版本2.2.5


注意:
认证授权服务和资源服务建议配套使用


