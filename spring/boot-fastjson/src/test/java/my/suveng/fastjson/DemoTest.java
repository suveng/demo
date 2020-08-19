package my.suveng.fastjson;

import my.suveng.fastjson.model.domain.Human;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
public class DemoTest {
    private Demo demo;

    @Before
    public void setupBefore() {
        this.demo = new Demo();
    }

    @Test
    public void objToJsonString() {
        String s = demo.ObjectToJsonString();
        System.out.println(s);
    }

    @Test
    public void stringToObject() {
        Human human = demo.stringToObject();
        System.out.println(human);
    }
}
