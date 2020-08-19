package my.suveng.statmachine.demo.own;

/**
 * 状态抽闲
 * 
 * @author suwenguang
 **/
public interface IStat {

    /**
     * 转化状态前的回调
     * 
     * @author suwenguang
     */
    void doBefore();

    /**
     * 转化到这个状态需要做的事情
     * 
     * @author suwenguang
     */
    void doAction();

    /**
     * 转化到这个状态 后要做的事情
     * 
     * @author suwenguang
     */
    void doAfter();

}
