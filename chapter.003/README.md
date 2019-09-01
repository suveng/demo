
1. 引入依赖

2. 配置fastjson 序列化

3. 配置 application.yml

4. docker启动MongoDB

````
docker run --restart="always" \
          -d \
          --name mongo\
          -p 27017:27017\
          -v /docker/mongo/data/db:/data/db\
          mongo:latest --storageEngine wiredTiger 
````

