package my.suveng.fastjson;

import java.util.Date;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import my.suveng.fastjson.model.domain.Human;

/**
 *
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
public class Demo {

    /**
     * 序列化一个对象成JSON字符串
     * 
     * @author suwenguang
     * 
     * @date 2019/11/6
     */
    public String ObjectToJsonString() {
        Human human = new Human();
        human.setBody("good");
        human.setSpirit("上天");
        human.setBirthday(new Date());
        human.setAge(22L);
        ArrayList<Human> famaily = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Human member = new Human();
            member.setBody("good");
            member.setSpirit("上天");
            member.setBirthday(new Date());
            member.setAge(22L);
            famaily.add(member);
        }
        human.setFamaily(famaily);

        // 设置human2
        Human human2 = new Human();
        human2.setBody("good");
        human2.setSpirit("上天");
        human2.setBirthday(new Date());
        human2.setAge(22L);
        human2.setFamaily(famaily);

        // 设置列表,测试应用依赖的问题;
        ArrayList<Human> humans = new ArrayList<>();
        humans.add(human);
        humans.add(human2);

        System.out.println("默认序列化为" + JSON.toJSONString(humans));
        System.out.println("解决$ref 问题");
        return JSON.toJSONString(humans, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 反序列化字符串到java对象
     * 
     * @author suwenguang
     * 
     * @date 2019/11/6
     */
    public Human stringToObject() {
        String json = "{\n" + "    \"age\": 22,\n" + "    \"birthday\": 1573007531738,\n" + "    \"body\": \"good\",\n"
                + "    \"famaily\": [\n" + "        {\n" + "            \"age\": 22,\n"
                + "            \"birthday\": 1573007531738,\n" + "            \"body\": \"good\",\n"
                + "            \"spirit\": \"上天\"\n" + "        },\n" + "        {\n" + "            \"age\": 22,\n"
                + "            \"birthday\": 1573007531738,\n" + "            \"body\": \"good\",\n"
                + "            \"spirit\": \"上天\"\n" + "        },\n" + "        {\n" + "            \"age\": 22,\n"
                + "            \"birthday\": 1573007531738,\n" + "            \"body\": \"good\",\n"
                + "            \"spirit\": \"上天\"\n" + "        },\n" + "        {\n" + "            \"age\": 22,\n"
                + "            \"birthday\": 1573007531738,\n" + "            \"body\": \"good\",\n"
                + "            \"spirit\": \"上天\"\n" + "        },\n" + "        {\n" + "            \"age\": 22,\n"
                + "            \"birthday\": 1573007531738,\n" + "            \"body\": \"good\",\n"
                + "            \"spirit\": \"上天\"\n" + "        }\n" + "    ],\n" + "    \"spirit\": \"上天\"\n" + "}";
        return JSON.parseObject(json, Human.class);
    }

}
