package my.suveng.statmachine.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

/**
 *
 * @author suwenguang
 **/
@Component
public class SpringComponent {
	@Autowired
	private StateMachine<StatEnums, EventEnums> stateMachine;

	public void  send(){
		stateMachine.start();
		stateMachine.sendEvent(EventEnums.toReady);
	}
}
