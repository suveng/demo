package my.suveng.redis.model.domain;

import lombok.Data;
import my.suveng.redis.model.vo.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

/**
 *
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
@RedisHash("people")
@Data
public class Person {

    @Id
    String id;

    @TimeToLive
    private Long expiration;

    String firstname;
    String lastname;

    Address address;

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
