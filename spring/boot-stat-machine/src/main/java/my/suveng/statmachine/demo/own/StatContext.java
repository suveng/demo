package my.suveng.statmachine.demo.own;

import org.springframework.util.ObjectUtils;

import java.util.Objects;

/**
 * 状态上下文
 * 
 * @author suwenguang
 **/
public class StatContext {
    // 状态
    protected StatEnums statEnums;

    public void switchStatTo(StatEnums statEnums) {
        this.statEnums = statEnums;
        statEnums.getStat().doBefore();
        statEnums.getStat().doAction();
        statEnums.getStat().doAfter();
    }

    public String currStat() {
        if (ObjectUtils.isEmpty(statEnums)) {
            return null;
        }
        return this.statEnums.name();
    }

}
