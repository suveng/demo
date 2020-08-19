package my.suveng.statmachine.demo.spring;

import my.suveng.statmachine.demo.own.IStat;
import my.suveng.statmachine.demo.own.impl.CreateStatImpl;
import my.suveng.statmachine.demo.own.impl.ReadyStatImpl;

/**
 * 状态, 后续在这里添加做扩展
 * 
 * @author suwenguang
 **/
public enum StatEnums {
    //
    create(new CreateStatImpl()), ready(new ReadyStatImpl());

    StatEnums(IStat stat) {
        this.stat = stat;
    }

    private final IStat stat;

    public IStat getStat() {
        return stat;
    }
}
