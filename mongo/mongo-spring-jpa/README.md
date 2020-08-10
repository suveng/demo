# springboot2.X 使用spring-data组件对MongoDB做CURD

## 使用背景

基于快速开发,需求不稳定的情况, 我决定使用MongoDB作为存储数据库,搭配使用spring-data

因为快速开发,使用spring data可以直接在类上建表等其他操作,而且对于复合数据模型,MongoDB可以直接存储

## 代码地址

[gitee](https://gitee.com/suveng/demo/tree/master/chapter.003)

[github](https://github.com/suveng/demo/tree/master/chapter.003)

## 入门普通级别

### 1.引入maven依赖

```xml
<dependencies>
        <!--###############时间日期操作################-->
        <dependency>
            <groupId>joda-time</groupId>
            <artifactId>joda-time</artifactId>
        </dependency>


        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>

        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
        <!--###############springboot-aop模块################-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>
        <!--###############test模块################-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!--###############web模块################-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!--###############lombok################-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>

        <!--fast json-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
        </dependency>

        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
        </dependency>

</dependencies>
```



**基于maven dependencyManagement 版本控制如下:**



```xml
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>2.1.2.RELEASE</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>5.1.48</version>
            </dependency>

            <dependency>
                <groupId>cn.hutool</groupId>
                <artifactId>hutool-all</artifactId>
                <version>4.5.16</version>
            </dependency>

            <!--mybatis-->
            <dependency>
                <groupId>org.mybatis.spring.boot</groupId>
                <artifactId>mybatis-spring-boot-starter</artifactId>
                <version>2.0.0</version>
            </dependency>

            <!--fast json-->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>fastjson</artifactId>
                <version>1.2.56</version>
            </dependency>

            <!-- druid -->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid-spring-boot-starter</artifactId>
                <version>1.1.9</version>
            </dependency>

            <dependency>
                <groupId>com.google.guava</groupId>
                <artifactId>guava</artifactId>
                <version>20.0</version>
            </dependency>
        </dependencies>
    </dependencyManagement>

```

### 2.使用docker启动MongoDB

````
docker run --restart="always" \
          -d \
          --name mongo\
          -p 27017:27017\
          -v /docker/mongo/data/db:/data/db\
          mongo:latest --storageEngine wiredTiger
````



### 3.创建Mongo的实体类

- @Document(collection="female")

- 设置id: @Id

- 设置属性

- 构建索引

- getter/setter

> [Female.java](https://github.com/suveng/demo/blob/master/chapter.003/src/main/java/my/suveng/app/model/Female.java)

```
@Document(collection = "female")
@Data
public class Female {
	/**
	 * 主键
	 */
	@Id
	private String id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 年龄
	 */
	private String age;

	/**
	 * 哪种类型的女人;FemaleTypeEnums
	 */
	private Integer type;

	/**
	 * 舔狗
	 */
	private List<Male> dogs;

	/**
	 * 男朋友们
	 */
	@Indexed
	private List<Male> boyFriends;

	/**
	 * 男神们
	 */
	@Indexed
	private List<Male> dreamers;

	/**
	 * 创建时间
	 */
	@Indexed
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date modifiedTime;
}
```

### 4.创建Dao层

- 创建Repository 继承于MongoRepository

- 根据规则来编写接口方法, spring data mongodb的dao 方法规则详细查看[点这里](https://docs.spring.io/spring-data/data-mongodb/docs/2.1.2.RELEASE/reference/html/#repositories.query-methods.details),理论上用idea会提示出来的.

- 编写单元测试方法



**创建Repository 继承于MongoRepository,编写接口方法**

> [FemaleRepository.java](https://github.com/suveng/demo/blob/master/chapter.003/src/main/java/my/suveng/app/dao/FemaleRepository.java)

```java
public interface FemaleRepository extends MongoRepository<Female,String> {
	Page<Female> findAllByCreateTimeBetweenAndNameContaining(Date createTime, Date createTime2, String name, Pageable pageable);

	Page<Female> findAllByCreateTimeBefore(Date createTime, Pageable pageable);

	Page<Female> findAllByCreateTimeAfter(Date createTime, Pageable pageable);

	Page<Female> findAllByCreateTimeBetween(Date start, Date end, PageRequest pageRequest);
}
```

**单元测试方法**

> [FemaleRepositoryTest.java](https://github.com/suveng/demo/blob/master/chapter.003/src/test/java/my/suveng/app/dao/FemaleRepositoryTest.java)

```java
	/**
	 * description: 添加测试数据
	 * author: suwenguang
	 * date: 2019-09-01
	 */
	@Test
	public void addTestData() {
		for (int i = 0; i < 1000; i++) {
			Female entity = new Female();
			entity.setName(RandomUtil.randomString(12));
			LocalDate now = LocalDate.now();
			LocalDate localDate = now.minusDays(RandomUtil.randomInt(4));
			entity.setCreateTime(localDate.toDate());
			femaleRepository.save(entity);
		}
	}

	/**
	 * description: 测试查询构造器
	 * author: suwenguang
	 * date: 2019-09-01
	 */
	public void  matching(){
		//精确匹配和模糊匹配
		Female probe = new Female();
		ExampleMatcher matching = ExampleMatcher.matching()
			.withMatcher("name", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING))//模糊匹配
			.withIgnorePaths("id")//忽略匹配id
			;
		PageRequest of = PageRequest.of(0, 10);
		Page<Female> all = femaleRepository.findAll(Example.of(probe, matching), of);
		System.out.println(JSON.toJSONString(all));
	}

	/**
	 * description: 测试范围查询
	 * author: suwenguang
	 * date: 2019-09-01
	 */
	@Test
	public void findAllByCreateTimeAfter() {
		LocalDate yesteday = new LocalDate().minusDays(3);
		PageRequest of = PageRequest.of(0, 10);
		List<Female> byCreateTimeAfter = femaleRepository.findAllByCreateTimeAfter(yesteday.toDate(), of);
		System.out.println(JSON.toJSONString(byCreateTimeAfter));
	}

	/**
	 * description: 测试范围查询
	 * author: suwenguang
	 * date: 2019-09-01
	 */
	@Test
	public void findByCreateTimeBetween() {
		LocalDate localDate = new LocalDate();
		Page<Female> byCreateTimeBetween = femaleRepository.findByCreateTimeBetween(localDate.minusDays(2).toDate(), localDate.toDate(), PageRequest.of(0, 10));
		System.out.println(JSON.toJSONString(byCreateTimeBetween.getContent()));
	}
```



## 进阶Querydsl扩展复杂查询

> (基于单表的复杂查询,多表复杂查询暂时不纳入讨论范围)

如果按照以上的用法,动态扩展多条件查询仍然不能够完美支持,会导致代码冗余,当然你如果使用mongoTemlate进行自己封装,另当别论.

那么为了实现动态扩展多条件查询,我去查看对应版本的官方文档,[跳转点这里](https://docs.spring.io/spring-data/data-mongodb/docs/2.1.2.RELEASE/reference/html/#core.extensions.querydsl),看到可以集成querydsl作为扩展.

### 步骤

- 整合querydsl

- 使用dsl

### 1.整合querydsl

> [1.Querydsl官网](http://www.querydsl.com/)
>
> [2.querydsl集成文档](http://www.querydsl.com/static/querydsl/latest/reference/html/ch02.html#jpa_integration)

**pom.xml配置引入依赖**

```xml
       <!--###############复杂查询querydsl jpa################-->
        <dependency>
            <groupId>com.querydsl</groupId>
            <artifactId>querydsl-apt</artifactId>
            <version>${querydsl.version}</version>
            <scope>provided</scope>
        </dependency>

        <dependency>
            <groupId>com.querydsl</groupId>
            <artifactId>querydsl-jpa</artifactId>
            <version>${querydsl.version}</version>
        </dependency>

<!--        <dependency>-->
<!--            <groupId>org.slf4j</groupId>-->
<!--            <artifactId>slf4j-log4j12</artifactId>-->
<!--            <version>1.6.1</version>-->
<!--        </dependency>-->
```

**为什么要注释掉slf4j?**

因为我的springboot项目已经引入了slf4j,没必要重复声明,自己可以通过idea的maven dependence查看是否有引入,没有则需要重新引入

### 2.使用dsl

- 在`dao`的`repository`中继承`QuerydslPredicateExecutor<T>`

  ```java
  public interface FemaleRepository extends MongoRepository<Female,String>, QuerydslPredicateExecutor<Female> {

  }
  ```



- 编写单元测试[FemaleRepositoryTest.java](https://github.com/suveng/demo/blob/master/chapter.003/src/test/java/my/suveng/app/dao/FemaleRepositoryTest.java)

  ```java
  	/**
  	 * description: 多条件
  	 * author: suwenguang
  	 * date: 2019-09-01
  	 */
  	@Test
  	public void querydsl() {
  		PageRequest of = PageRequest.of(0, 10);
  		QFemale female = QFemale.female;
  		BooleanExpression createTimeBetween = female.createTime.between(LocalDate.now().minusDays(2).toDate(), LocalDate.now().minusDays(1).toDate());
  		BooleanBuilder builder = new BooleanBuilder(createTimeBetween);
  		BooleanExpression contains = female.name.contains("3");
  		builder.and(contains);
  		Page<Female> all = femaleRepository.findAll(builder,of);
  		System.out.println(all.getTotalElements());
  		System.out.println(JSON.toJSONString(all.getContent()));
  	}
  ```



如上所示, 这样子可以**动态构造**所需要的条件,**多个范围查询也可以支持**了!!!那么对于后台的搜索数据只需要一个接口就可以了

至于怎么实现,后面再继续整合 [X-admin 2.2](https://gitee.com/daniuit/X-admin)这个后端模板, 另外出一篇文章吧.

> 如果对上诉**代码有问题**或者有**其他的扩展性问题**,欢迎留下你的评论.



## 补充

- **BooleanBuilder的类图, 可以通过idea查看,因为findAll是通过父类继承下来的接口, 里面的Predicate也是一个接口,而BooleanExpression和BooleanBuilder都是实现了Predicate的;**
  ![](https://img2018.cnblogs.com/blog/1419387/201909/1419387-20190901192816243-1084215449.png)



