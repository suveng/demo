# 关于Oauth2.0说明

1. 这里使用SpringSecurityOauth2的集成框架,版本是2.0.15,springboot的版本是1.5.16
2. 关于使用的Oauth2.0的模式,这里的client是基于MySQL的,可以动态在MySQL的client details中配置
3. 关于token存储, token是基于MySQL来存储的, 这里的token没有使用jwtToken,jwtToken打算另外起一个隔离的项目来配置
4. 关于UserDetails系统用户,UserDetailsService, 这里配置了spring bean(CustomUserDetailsService), 替换默认的InMemoryUserDetailsService; 自定义的UserDetailsService是基于MySQL的用户系统来查找用户的.
5. 关于接口, 使用postman进行测试.
