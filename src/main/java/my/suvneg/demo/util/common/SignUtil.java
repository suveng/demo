package my.suvneg.demo.util.common;


import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * 加密工具类
 */
@Component
public class SignUtil {

    private static final Logger logger = LoggerFactory.getLogger(SignUtil.class);


    /**
     * 签名并返回base64编码
     *
     * @param context
     * @param mkey
     * @return
     */
    public static String sign2Base64(String context, String mkey) {
        return md5(context + mkey);
    }

    /**
     * 签名并返回base64编码
     *
     * @param params
     * @param mkey
     * @return
     */
    public static String sign2Base64(Map<?,?> params, String mkey) {
        return md5(getSortStr(params, false) + mkey);
    }

    public static String md5(String string) {
        byte[] bytes;
        try {
            bytes = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 should be supported?", e);
        }

        return Base64.encodeBase64String(bytes);
    }

    public static String onlyMD5(String str) {
        byte[] bytes;
        try {
            bytes = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 should be supported?", e);
        }

        return bytesToHex(bytes);
    }

    /**
     * 将byte数组按十六进制转换成字符串
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();
        //把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];
            if(digital < 0) {
                digital += 256;
            }
            if(digital < 16){
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString();
    }

    public static boolean verifyOnlyMD5(String src, String sign, String mkey) {
        String mySign = onlyMD5(src + mkey);
        boolean isTrue = mySign.equals(sign);
        if (!isTrue) {
            logger.info("verify sign fail,[sign={},mySign={},src={},mkey={}]", sign, mySign, src, mkey);
        }
        return isTrue;
    }

    /**
     * 签名验证,返回true代表验证成功
     * <p/>
     * 验证公式为:md5(src+mkey) equals sign
     *
     * @param src  源,未加密,json字符串
     * @param sign 待比较的签名
     * @param mkey 加密用的秘钥
     * @return
     */
    public static boolean verify(String src, String sign, String mkey) {
        String mySign = md5(src + mkey);
        if(logger.isDebugEnabled()) {
            logger.debug("加密原文：{}", src + mkey);
        }

        boolean isTrue = mySign.equals(sign);
        if (!isTrue) {
            logger.info("verify sign fail,[sign={},mySign={},src={},mkey={}]", sign, mySign, src, mkey);
        }
        return isTrue;
    }

    /**
     * @param params--过滤参数数组
     * @param withChar 返回的字符串是否包含“&”字符
     * @return
     * @desc 获得按Map键升序排序的字符串 如a=88&f=22&t=uu 或 a=88f=22t=uu
     */
    public static String getSortStr(Map params, boolean withChar) {

        StringBuffer content = new StringBuffer();
        if (params.size() <= 0) {
            return "";
        }
        // 按照key做排序
        @SuppressWarnings("unchecked")
        List keys = new ArrayList(params.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {

            String key = keys.get(i).toString();
            Object ov = params.get(key);

            String value = null;
            if (ov == null) {
                value = "null";
            } else if (ov instanceof String || ov instanceof Number || ov instanceof Boolean) {
                value = ov.toString();
            } else if (ov instanceof Map) {
                value = getSortStr((Map) ov, withChar);
            } else {
                continue;
            }

            if (true == withChar) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
            } else {
                content.append(key + "=" + value);
            }
            index++;
        }
        return content.toString();
    }

}
