/*
 * Copyright (c) 2013-2020 by yiyou All rights reserved
 */
package my.suveng.demo.util.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description 整型工具类
 * @author <a href="mailto:linguozhi@52tt.com">soothing</a>
 * @since 2013-12-18
 * @version 1.0.0
 */
public class IntegerUtil {

	/**
	 * 转为基本类型
	 *
	 * @param i
	 * @return int
	 */
	public static int toInt(Integer i) {
		return null == i ? 0 : i;
	}

	/**
	 * nullOrZero
	 *
	 * @param i
	 * @return boolean
	 */
	public static boolean nullOrZero(Integer i) {
		if (null == i || i <= 0) {
            return true;
        }
		return false;
	}

	/**
	 * 比较相等
	 *
	 * @param a
	 * @param b
	 * @return boolean
	 */
	public static boolean equals(Integer a, Integer b) {
		if (null == a || null == b) {
			return false;
		}
		return a.equals(b);
	}

	/**
	 * isEmpty
	 *
	 * @param i
	 * @return boolean
	 */
	public static boolean ltZero(Integer i) {
		if (null == i || i < 0) {
            return true;
        }
		return false;
	}

	/**
	 * isEmpty
	 *
	 * @param i
	 * @return boolean
	 */
	public static boolean ltOne(Integer i) {
		if (null == i || i < 1) {
            return true;
        }
		return false;
	}

	/**
	 * isNotEmpty
	 *
	 * @param i
	 * @return boolean
	 */
	public static boolean gtZero(Integer i) {
		if (null != i && i > 0) {
            return true;
        }
		return false;
	}
	
	/**
	 * 字节转MB
	 * @param b
	 * @return double
	 */
	public static double byteToMb(Integer b) {
		BigDecimal dividend = new BigDecimal(1024);
		BigDecimal divisor = new BigDecimal(b);
		return divisor.divide(dividend).divide(dividend).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
	}
}
