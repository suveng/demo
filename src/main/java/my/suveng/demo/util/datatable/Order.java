/*
 * Copyright (c) 2004-2014 by yiyou All rights reserved
 */
package my.suveng.demo.util.datatable;

/**
 * @description 排序类
 * @author <a href="mailto:linguozhi@52tt.com">soothing</a>
 * @since 2016-03-16
 * @version 1.0.0
 */
public class Order {

	/* 列索引 */
	private int colIdex;

	/* 列名 */
	private String colName;

	/* 方向 */
	private String direction;

	/* 是否倒序 */
	private Boolean desc;

	/**
	 * 默认排序字段
	 */
	private static final String DEFALUT_COLNAME = "id";

	public Order() {
		this.colName = DEFALUT_COLNAME;
		this.direction = "desc";
	}

	/**
	 * 构建排序对象（返回默认排序）
	 *
	 * @return Order
	 */
	public static Order build() {
		Order order = new Order();
		order.setColName(DEFALUT_COLNAME);
		order.setDesc(true);
		return order;
	}

	/**
	 * 构建排序对象
	 *
	 * @param colName
	 *            排序字段
	 * @return Order
	 */
	public static Order build(String colName) {
		Order order = new Order();
		order.setColName(colName);
		order.setDesc(true);
		return order;
	}

	/**
	 * get desc
	 *
	 * @return desc desc
	 */
	public Boolean getDesc() {
		if (desc != null) {
			return this.desc;
		}
		return "desc".equals(direction);
	}

	/**
	 * set desc
	 *
	 * @param desc
	 *            desc
	 */
	public void setDesc(Boolean desc) {
		this.desc = desc;
	}

	/**
	 * get colName
	 *
	 * @return colName colName
	 */
	public String getColName() {
		return colName;
	}

	/**
	 * set colName
	 *
	 * @param colName
	 *            colName
	 */
	public void setColName(String colName) {
		this.colName = colName;
	}

	/**
	 * get colIdex
	 *
	 * @return colIdex colIdex
	 */
	public int getColIdex() {
		return colIdex;
	}

	/**
	 * set colIdex
	 *
	 * @param colIdex
	 *            colIdex
	 */
	public void setColIdex(int colIdex) {
		this.colIdex = colIdex;
	}

	/**
	 * get direction
	 *
	 * @return direction direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * set direction
	 *
	 * @param direction
	 *            direction
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
}
