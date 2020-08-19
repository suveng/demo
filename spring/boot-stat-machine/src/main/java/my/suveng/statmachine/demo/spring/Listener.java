package my.suveng.statmachine.demo.spring;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.OnTransitionEnd;
import org.springframework.statemachine.annotation.OnTransitionStart;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * 监听器
 * 
 * @author suwenguang
 **/
@WithStateMachine
public class Listener {
    @OnTransitionStart(source = "create", target = "ready")
    public void doBefore() {
        System.out.println("create -> ready before");
    }

    @OnTransition(source = "create", target = "ready")
    public void doAction() {
        System.out.println("create -> ready doing");
    }

    @OnTransitionEnd(source = "create", target = "ready")
    public void doAfter() {
        System.out.println("create -> ready after");
    }

}
