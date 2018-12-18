package my.suvneg.demo.util.common;

/**
 * 二进制转换工具
 */
public class CryptUtil {

	public static byte[] hex2byte(byte[] b) {
		if ((b.length % 2) != 0) {
            throw new IllegalArgumentException("长度不是偶数");
        }
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}

	/**
	 * 二行制转字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) {
		StringBuilder sb = new StringBuilder();
		String stmp = "";
		for (int n = 0; b != null && n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
                sb.append("0").append(stmp);
            } else {
                sb.append(stmp);
            }
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * 二行制转页面字符串
	 *
	 * @param b
	 * @return
	 */
	public static String byte2webhex(byte[] b) {
		return byte2hex(b, "%");
	}

	/**
	 * 二行制转字符串
	 *
	 * @param b
	 * @param elide
	 *            分隔符
	 * @return
	 */
	public static String byte2hex(byte[] b, String elide) {
		StringBuilder sb = new StringBuilder();
		String stmp = "";
		elide = elide == null ? "" : elide;
		for (int n = 0; b != null && n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
                sb.append(elide).append("0").append(stmp);
            } else {
                sb.append(elide).append(stmp);
            }
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * 随机数据来源
	 */
	@SuppressWarnings("unused")
	private final static String[] UPPERCASE = { "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "0", "Q", "W", "E", "R", "T", "Y", "U", "I", "O",
			"P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C",
			"V", "B", "N", "M" };

	/**
	 * 随机数据来源
	 */
	@SuppressWarnings("unused")
	private final static String[] LOWERCASE = { "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "0", "q", "w", "e", "r", "t", "y", "u", "i", "o",
			"p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c",
			"v", "b", "n", "m" };

}
