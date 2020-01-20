# 关于Oauth2.0说明

1. 这里使用SpringSecurityOauth2的集成框架,版本是2.0.15,springboot的版本是1.5.16
2. 关于使用的Oauth2.0的模式,这里的client是基于MySQL的,可以动态在MySQL的client details中配置
3. 关于token存储, token是基于MySQL来存储的, 这里的token没有使用jwtToken,jwtToken打算另外起一个隔离的项目来配置
4. 关于UserDetails系统用户,UserDetailsService, 这里配置了spring bean(CustomUserDetailsService), 替换默认的InMemoryUserDetailsService; 自定义的UserDetailsService是基于MySQL的用户系统来查找用户的.
5. 关于接口, 使用postman进行测试.


spring boot security oauth2.0
基于jdbc的DataSource,配置受信客户端
```sql
#--------------- MySQL ---------------
drop table if exists oauth_client_details;
create table oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(255)
);

create table if not exists oauth_client_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);

create table if not exists oauth_access_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication LONG VARBINARY,
  refresh_token VARCHAR(255)
);

create table if not exists oauth_refresh_token (
  token_id VARCHAR(255),
  token LONG VARBINARY,
  authentication LONG VARBINARY
);

create table if not exists oauth_code (
  code VARCHAR(255), authentication LONG VARBINARY
);

create table if not exists oauth_approvals (
	userId VARCHAR(255),
	clientId VARCHAR(255),
	scope VARCHAR(255),
	status VARCHAR(10),
	expiresAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	lastModifiedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

create table if not exists ClientDetails (
  appId VARCHAR(255) PRIMARY KEY,
  resourceIds VARCHAR(255),
  appSecret VARCHAR(255),
  scope VARCHAR(255),
  grantTypes VARCHAR(255),
  redirectUrl VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(255)
);

```

受信客户端数据
```sql
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('fooClientIdPassword', 'secret', 'foo,read,write',
	'password,authorization_code,refresh_token', null, null, 36000, 36000, null, true);
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('sampleClientId', 'secret', 'read,write,foo,bar',
	'implicit', null, null, 36000, 36000, null, false);
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('barClientIdPassword', 'secret', 'bar,read,write',
	'password,authorization_code,refresh_token', null, null, 36000, 36000, null, true);

```
