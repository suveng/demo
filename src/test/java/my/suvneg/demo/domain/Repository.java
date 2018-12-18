package my.suvneg.demo.domain;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Repository {
//    @Autowired
//    UserRepository userRepository;
//    @Test
//    public void testRepository(){
//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
//        String formattedDate = dateFormat.format(date);
//
//        userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
//        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
//        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));
//
//        List<User> all = userRepository.findAll();
//        String bb = userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName();
//        userRepository.delete(userRepository.findByUserName("aa1"));
//    }
}
