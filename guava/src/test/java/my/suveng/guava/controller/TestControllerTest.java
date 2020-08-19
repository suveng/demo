package my.suveng.guava.controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
public class TestControllerTest {

    private TestController testController;

    @Before
    public void before() {
        testController = new TestController();
    }

    @Test
    public void getOne() {
        testController.getOne();
    }

    @Test
    public void getOneDefaultValue() {
        testController.getOneDefaultValue();
    }

    @Test
    public void stringMethods() {
        testController.stringMethods();
    }

    @Test
    public void precondition() {
        testController.precondition();
    }

    @Test
    public void objects() {
        testController.objects();
    }

    @Test
    public void ordering() {
        testController.ordering();
    }
}
