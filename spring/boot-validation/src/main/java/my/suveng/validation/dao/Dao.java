package my.suveng.validation.dao;

import my.suveng.validation.model.HelloBo;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 *
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
@Component
public class Dao {

    public HelloBo getOne() {
        Random random = new Random();
        int i = random.nextInt();
        if (i % 2 == 0) {
            return new HelloBo();
        }
        return null;
    }
}
