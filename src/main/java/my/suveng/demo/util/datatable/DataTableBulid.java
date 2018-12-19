/*
 * Copyright (c) 2004-2014 by yiyou All rights reserved
 */
package my.suveng.demo.util.datatable;


import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @description DataTable列表JSON数据构建类
 * @author <a href="mailto:linguozhi@52tt.com">soothing</a>
 * @since 2016-06-01
 * @version 1.0.0
 */
public class DataTableBulid {

	/**
	 * 构建方法
	 *
	 * @param draw
	 * @param data
	 * @return DataTable
	 */
	public static DataTable build(int draw, int count, Object data) {
		// dataTable不接受空值
		if(data == null) {
			data = ArrayUtils.EMPTY_INT_ARRAY;
		}
		return new DataTable(draw, count, count, data);
	}

	/**
	 * 构建方法
	 *
	 * @param draw
	 * @param data
	 * @return DataTable
	 */
	public static String buildJson(int draw, int count, Object data) {
		DataTable dataTable = new DataTable(draw, count, count, data);
		return JSON.toJSONString(dataTable);
	}

	/**
	 * 构建方法
	 *
	 * @param draw
	 * @param data
	 * @return DataTable
	 */
	public static String buildJson(int draw, int count, Object data, String dateFormat) {
		DataTable dataTable = new DataTable(draw, count, count, data);
		return JSON.toJSONString(dataTable);
	}
}
