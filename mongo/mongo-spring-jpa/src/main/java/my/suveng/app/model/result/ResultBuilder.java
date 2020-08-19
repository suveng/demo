package my.suveng.app.model.result;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import my.suveng.app.model.log.LogDetail;
import my.suveng.app.model.log.LogDetailThreadLocal;

/**
 * @author suwenguang email suveng@163.com since 2019/2/26 description: 统一返回层 工厂类
 **/
@Slf4j
public class ResultBuilder {

    public static Result build(CodeEnum codeEnum, Object data) {
        LogDetail logDetail = LogDetailThreadLocal.logDetailThreadLocal.get();
        if (StrUtil.isBlank(logDetail.getRequsetId())) {
            log.warn(Thread.currentThread().getName() + "没有requestid");
        }
        return new Result(codeEnum.getCode(), codeEnum.getMsg(), data, logDetail.getRequsetId());
    }

}
