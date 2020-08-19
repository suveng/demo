package my.suveng.redis.dao;

import my.suveng.redis.model.domain.Person;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
public interface PersonRepository extends KeyValueRepository<Person, String>, CrudRepository<Person, String> {
}
