package my.suveng.statmachine.demo.spring.config;

import my.suveng.statmachine.demo.spring.EventEnums;
import my.suveng.statmachine.demo.spring.StatEnums;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * 状态机配置类
 * @author suwenguang
 **/
@EnableStateMachine
@Configuration
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<StatEnums, EventEnums> {

	/**
	 * 配置状态机状态
	 * @author suwenguang
	 */
	@Override
	public void configure(StateMachineStateConfigurer<StatEnums, EventEnums> states) throws Exception {
		states.withStates()
			.initial(StatEnums.create)
			.states(EnumSet.allOf(StatEnums.class));
	}

	/**
	 * configure用来初始化当前状态机有哪些状态迁移动作
	 * 从其中命名中我们很容易理解每一个迁移动作，都有来源状态source，目标状态target以及触发事件event
	 * 事件和状态流转关系绑定：类似BlogContext的throwCoin及UpSometimeState下的switchState的过程
	 */
	@Override
	public void configure(StateMachineTransitionConfigurer<StatEnums, EventEnums> transitions) throws Exception {
		transitions
			.withExternal()
			.source(StatEnums.create).target(StatEnums.ready)
			.event(EventEnums.toReady);
	}



}
