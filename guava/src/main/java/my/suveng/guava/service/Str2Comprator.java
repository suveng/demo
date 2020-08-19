package my.suveng.guava.service;

import com.google.common.collect.ComparisonChain;
import my.suveng.guava.model.TestModel;

import java.util.Comparator;

/**
 *
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
public class Str2Comprator implements Comparator<TestModel> {

    /**
     * 如果str1相等,比较str2的自然排序
     * 
     * @author suwenguang
     * 
     * @date 2019/11/8
     */
    @Override
    public int compare(TestModel left, TestModel right) {
        return ComparisonChain.start().compare(left.getStr2(), right.getStr2()).result();
    }
}
