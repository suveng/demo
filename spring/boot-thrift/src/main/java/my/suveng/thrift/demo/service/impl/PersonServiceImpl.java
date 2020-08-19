package my.suveng.thrift.demo.service.impl;

import thrift.generated.Person._Fields;

import org.apache.thrift.TException;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 *
 * @author suwenguang
 **/
public class PersonServiceImpl implements PersonService.Iface {

    @Override
    public Person getPersonByUsername(String username) throws TException {
        System.out.println("getperson被调用");
        Person person = new Person();
        person.setUsername("");
        person.setUsernameIsSet(false);
        person.setAge(0);

        return person;
    }

    @Override
    public void savePerson(Person person) throws TException {
        System.out.println("save person被调用");
    }
}
