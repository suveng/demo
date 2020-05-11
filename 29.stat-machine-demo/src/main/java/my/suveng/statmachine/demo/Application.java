package my.suveng.statmachine.demo;

import my.suveng.statmachine.demo.own.StatContext;
import my.suveng.statmachine.demo.own.StatEnums;
import my.suveng.statmachine.demo.spring.EventEnums;
import my.suveng.statmachine.demo.spring.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineContext;

@SpringBootApplication
public class Application {



	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println("测试自己的状态模式");
		StatContext statContext = new StatContext();
		System.out.println(statContext.currStat());

		statContext.switchStatTo(StatEnums.create);
		System.out.println(statContext.currStat());

		statContext.switchStatTo(StatEnums.ready);
		System.out.println(statContext.currStat());

		SpringComponent springComponent = (SpringComponent) context.getBean("springComponent");
		springComponent.send();

		Thread.sleep(2000);

	}

}
