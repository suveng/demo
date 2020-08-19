package my.suveng.thrift.demo.server;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.*;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 *
 * @author suwenguang
 **/
public class ThriftClient {
    public static void main(String[] args) {
        TTransport tTransport = new TFramedTransport(new TSocket("localhost", 9090, 3000, 2000));

        TProtocol tProtocol = new TCompactProtocol(tTransport);

        PersonService.Client client = new PersonService.Client(tProtocol);

        try {
            // 打开端口, 占用
            tTransport.open();
            Person hhh = client.getPersonByUsername("hhh");
            System.out.println(hhh);
            client.savePerson(new Person().setAge(123));
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            tTransport.close();
        }
    }

}
