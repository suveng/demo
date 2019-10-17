package my.suveng.redis.service;

import my.suveng.redis.dao.PersonRepository;
import my.suveng.redis.model.domain.Person;
import my.suveng.redis.model.vo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
@Service
public class AppService {
	@Autowired
	PersonRepository repo;

	public void basicCrudOperations() {



		Person rand = new Person("rand", "althor");
		rand.setAddress(new Address("黄埔大道西", "22号"));
		rand.setExpiration(60L);

		Person save = repo.save(rand);

		System.out.println(save.toString());

		Optional<Person> byId = repo.findById(rand.getId());

		if (byId.isPresent()) {
			Person person = byId.get();
			System.out.println(person.toString());
		}

		long count = repo.count();
		System.out.println(count);


	}
}
