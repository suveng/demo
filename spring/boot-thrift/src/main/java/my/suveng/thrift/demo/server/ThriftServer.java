package my.suveng.thrift.demo.server;

import my.suveng.thrift.demo.service.impl.PersonServiceImpl;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import thrift.generated.PersonService;

/**
 *
 * @author suwenguang
 **/
public class ThriftServer {
    public static void main(String[] args) throws TTransportException {
        System.out.println("thrift服务端");
        TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(9090);
        THsHaServer.Args arg = new THsHaServer.Args(serverSocket).minWorkerThreads(2).maxWorkerThreads(20);

        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());

        // 一些配置
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));

        // 启动
        TServer server = new THsHaServer(arg);
        System.out.println("启动完毕!");
        server.serve();
    }
}
