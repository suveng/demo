package my.suveng.campus.common.outermessage;

import my.suveng.campus.common.outermessage.robotdingtalk.model.interfaces.InitRobot;
import my.suveng.campus.common.outermessage.robotdingtalk.service.impl.TextRobotServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * description:
 * 
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
public class Robot {

    private static final Logger logger = LoggerFactory.getLogger(Robot.class);

    /**
     * 说明: 根据传入的参数获取 robot, 如果发生异常,则默认返回 文字群聊机器人
     * 
     * @return com.free.base.dingtalkrobot.service.InitRobot <- 返回类型
     */
    public static InitRobot build(RobotEnums robot) {
        Class robotClass = robot.getRobot();
        try {
            Object instance = robotClass.newInstance();
            return (InitRobot) instance;
        } catch (InstantiationException | IllegalAccessException e) {
            logger.info("获取initRobot实例失败,创建默认initRobot");
            if (logger.isDebugEnabled()) {
                e.printStackTrace();
            }
        }
        return new TextRobotServiceImpl();
    }

}
