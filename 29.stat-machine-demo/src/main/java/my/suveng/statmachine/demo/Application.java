package my.suveng.statmachine.demo;

import my.suveng.statmachine.demo.own.StatContext;
import my.suveng.statmachine.demo.own.StatEnums;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("测试自己的状态模式");
		StatContext statContext = new StatContext();
		System.out.println(statContext.currStat());

		statContext.switchStatTo(StatEnums.create);
		System.out.println(statContext.currStat());

		statContext.switchStatTo(StatEnums.ready);
		System.out.println(statContext.currStat());
	}

}
