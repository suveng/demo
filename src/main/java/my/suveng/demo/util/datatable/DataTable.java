package my.suveng.demo.util.datatable;

/**
 * @description DataTable列表对象
 * @author <a href="mailto:linguozhi@52tt.com">soothing</a>
 * @since 2016-01-28
 * @version 1.0.0
 */
public class DataTable {

    /* 开始行数 */
    private int draw;

    /* 记录总数 */
    private int recordsTotal;

    /* 记录过滤数 */
    private int recordsFiltered;

    /* 数据内容 */
    private Object data;

    public DataTable(int draw, int recordsTotal, int recordsFiltered, Object data) {
        super();
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }

    /**
     * get draw
     *
     * @return draw draw
     */
    public int getDraw() {
        return draw;
    }

    /**
     * set draw
     *
     * @param draw
     *            draw
     */
    public void setDraw(int draw) {
        this.draw = draw;
    }

    /**
     * get recordsTotal
     *
     * @return recordsTotal recordsTotal
     */
    public int getRecordsTotal() {
        return recordsTotal;
    }

    /**
     * set recordsTotal
     *
     * @param recordsTotal
     *            recordsTotal
     */
    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    /**
     * get recordsFiltered
     *
     * @return recordsFiltered recordsFiltered
     */
    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    /**
     * set recordsFiltered
     *
     * @param recordsFiltered
     *            recordsFiltered
     */
    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    /**
     * get data
     *
     * @return data data
     */
    public Object getData() {
        return data;
    }

    /**
     * set data
     *
     * @param data
     *            data
     */
    public void setData(Object data) {
        this.data = data;
    }
}
