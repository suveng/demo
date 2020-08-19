package my.suveng.oauth2.jwt.config.datasource;

/**
 *
 * @author suwenguang
 **/
public enum DataSourceType {
    /**
     * 主库
     */
    MASTER(0),

    /**
     * 从库1
     */
    SLAVE1(1),

    /**
     * 从库2
     */
    SLAVE2(2),

    /**
     * 从库3
     */
    SLAVE3(3),;

    private final int code;

    DataSourceType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
