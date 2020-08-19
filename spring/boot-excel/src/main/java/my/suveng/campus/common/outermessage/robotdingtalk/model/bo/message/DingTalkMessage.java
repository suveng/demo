package my.suveng.campus.common.outermessage.robotdingtalk.model.bo.message;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * description:
 * 
 * @author suwenguang
 * 
 * @date 2019-08-23
 * 
 * @version 1.0.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DingTalkMessage implements IMessage {
    private String app;

    @Value("${env.message.dingtalk.phone}")
    private String phone;

    @Value("${env.profile}")
    private String profile;

    @Value("${env.message.dingtalk.link}")
    private String link;

    private String content;

    public DingTalkMessage(String profile, String content) {
        this.profile = profile;
        this.content = content;
    }

    public DingTalkMessage(String content) {
        this.content = content;
    }

    @PostConstruct
    public void init() {
        this.app = "校园招聘系统-campus";
    }

    /**
     * description: 发送格式化钉钉消息 author: suwenguang date: 2019-08-23
     */
    public String toBeautiful() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("app:").append(this.app).append("\n\n");
        stringBuilder.append("env: ").append(this.profile).append("\n\n");
        stringBuilder.append("content: ").append(this.content).append("\n\n");
        return stringBuilder.toString();
    }
}
