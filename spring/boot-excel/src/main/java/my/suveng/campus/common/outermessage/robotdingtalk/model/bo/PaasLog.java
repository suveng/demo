package my.suveng.campus.common.outermessage.robotdingtalk.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 * 
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaasLog {
    private String link;
    private Long cost;
    private Boolean status;
    private String request;
    private String response;

    public PaasLog(String link, String request) {
        this.link = link;
        this.request = request;
    }

    @Override
    public String toString() {
        return "请求第三方API:" + "link='" + link + '\'' + ", cost=" + cost + ", status=" + status + ", request='" + request
                + '\'' + ", response='" + response + '\'';
    }
}
