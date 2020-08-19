package my.suveng.json.demo.jackson;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.junit.Test;

/**
 *
 * @author suwenguang
 **/
public class Use {
    /**
     * 对象转json
     * 
     * @author suwenguang
     */
    @Test
    public void toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Foo foo = new Foo();
        foo.setName(RandomUtil.randomString(3));
        foo.setAge(RandomUtil.randomInt());
        foo.setHouses(CollUtil.toList(RandomUtil.randomLong(), RandomUtil.randomLong(), RandomUtil.randomLong()));
        String json = objectMapper.writeValueAsString(foo);
        System.out.println(json);
    }

    /**
     * json转对象
     * 
     * @author suwenguang
     */
    @Test
    public void toObj() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Foo foo = new Foo();
        foo.setName(RandomUtil.randomString(3));
        foo.setAge(RandomUtil.randomInt());
        foo.setHouses(CollUtil.toList(RandomUtil.randomLong(), RandomUtil.randomLong(), RandomUtil.randomLong()));
        String json = objectMapper.writeValueAsString(foo);
        System.out.println(json);

        Foo value = objectMapper.readValue(json, Foo.class);
        System.out.println(value.toString());
    }

    /**
     * objectMapper的配置
     * 
     * @see com.fasterxml.jackson.core.JsonGenerator.Feature json语句生成配置
     * @see com.fasterxml.jackson.core.JsonParser.Feature json语法解析配置
     *
     * @see DeserializationFeature 反序列化配置
     * @see SerializationFeature 序列化配置
     *
     * @see com.fasterxml.jackson.annotation.JsonInclude.Include javabean字段是否参与序列化
     * 
     * @author suwenguang
     */
    @Test
    public void configObjectMapper() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        // 必须以 "双引号" 的形式包装字段
        objectMapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);

        Foo foo = new Foo();
        foo.setName(RandomUtil.randomString(3));
        foo.setAge(RandomUtil.randomInt());
        foo.setHouses(CollUtil.toList(RandomUtil.randomLong(), RandomUtil.randomLong(), RandomUtil.randomLong()));
        try {
            String json = objectMapper.writeValueAsString(null);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Foo value = objectMapper.readValue("{}", Foo.class);
        System.out.println(value.toString());
    }

    /**
     * 泛型转json
     * 
     * @author suwenguang
     */
    @Test
    public void ref2json() {
        ObjectMapper mapper = new ObjectMapper();
        Bar<Foo> fooBar = new Bar<>();
        fooBar.setName(RandomUtil.randomString(3));
        fooBar.setAge(RandomUtil.randomInt());
        fooBar.setHouses(CollUtil.toList(RandomUtil.randomLong(), RandomUtil.randomLong()));

        Foo foo = new Foo();
        foo.setName(RandomUtil.randomString(2));
        foo.setAge(RandomUtil.randomInt());
        foo.setHouses(CollUtil.toList(RandomUtil.randomLong(), RandomUtil.randomLong()));
        fooBar.setFoo(foo);

        try {
            String json = mapper.writeValueAsString(fooBar);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * json转泛型
     * 
     * @author suwenguang
     */
    @Test
    public void json2ref() {
        ObjectMapper mapper = new ObjectMapper();
        Bar<Foo> fooBar = new Bar<>();
        fooBar.setName(RandomUtil.randomString(3));
        fooBar.setAge(RandomUtil.randomInt());
        fooBar.setHouses(CollUtil.toList(RandomUtil.randomLong(), RandomUtil.randomLong()));

        Foo foo = new Foo();
        foo.setName(RandomUtil.randomString(2));
        foo.setAge(RandomUtil.randomInt());
        foo.setHouses(CollUtil.toList(RandomUtil.randomLong(), RandomUtil.randomLong()));
        fooBar.setFoo(foo);

        try {
            String json = mapper.writeValueAsString(fooBar);
            System.out.println(json);

            Bar<Foo> readValue = mapper.readValue(json, new TypeReference<Bar<Foo>>() {
            });

            System.out.println(readValue.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /**
     * jsonFilter使用
     * 
     * @author suwenguang
     */
    @Test
    public void jsonFilter() {
        ObjectMapper mapper = new ObjectMapper();
        Bar<Foo> fooBar = new Bar<>();
        fooBar.setName(RandomUtil.randomString(3));
        fooBar.setAge(RandomUtil.randomInt());
        fooBar.setHouses(CollUtil.toList(RandomUtil.randomLong(), RandomUtil.randomLong()));

        Foo foo = new Foo();
        foo.setName(RandomUtil.randomString(2));
        foo.setAge(RandomUtil.randomInt());
        foo.setHouses(CollUtil.toList(RandomUtil.randomLong(), RandomUtil.randomLong()));
        fooBar.setFoo(foo);

        // 注册myFilter
        mapper.addMixIn(Bar.class, MyFilter.class);
        // 调用 SimpleBeanPropertyFilter 的 serializeAllExcept 方法
        SimpleBeanPropertyFilter newFilter = SimpleBeanPropertyFilter.serializeAllExcept("testfilter");

        // 设置 FilterProvider
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("myFilter", newFilter);
        try {
            String json = mapper.setFilterProvider(filterProvider).writeValueAsString(fooBar);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
