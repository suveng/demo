package my.suveng.guava.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.*;
import com.google.common.collect.Ordering;
import my.suveng.guava.dao.TestDao;
import my.suveng.guava.model.TestModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suwenguang
 * 
 * @version 1.0.0
 **/
public class TestService {

    public static TestService SINGLE = new TestService();
    private final TestDao testDao;

    public TestService(TestDao testDao) {
        this.testDao = testDao;
    }

    public TestService() {
        this.testDao = TestDao.SINGLE;
    }

    public Optional<TestModel> getOne() {
        return testDao.getOne();
    }

    /**
     * 使用guava defaultValue
     * 
     * @author suwenguang
     * 
     * @date 2019/11/8
     */
    public TestModel getOneDefaultValue() {
        return testDao.getOneDefaultValue();
    }

    /**
     * @see com.google.common.base.Strings
     * 
     * @author suwenguang
     * 
     * @date 2019/11/8
     */
    public TestModel stringMethods() {
        String emptyToNull = Strings.emptyToNull("");
        System.out.println(emptyToNull);

        boolean nullOrEmpty = Strings.isNullOrEmpty("");
        System.out.println(nullOrEmpty);

        String nullToEmpty = Strings.nullToEmpty(null);
        System.out.println(nullToEmpty);

        String commonPrefix = Strings.commonPrefix("123,222", "124,333");
        System.out.println(commonPrefix);

        String commonSuffix = Strings.commonSuffix("123,222", "2345,222");
        System.out.println(commonSuffix);

        // 填充字符到后面
        String padEnd = Strings.padEnd("222", 10, '1');
        System.out.println(padEnd);

        // 填充字符到前面
        String padStart = Strings.padStart("222", 10, '1');
        System.out.println(padStart);

        // minlength决定是否填充
        String minLengthEnough = Strings.padEnd("222", 2, '1');
        System.out.println(minLengthEnough);
        return null;
    }

    /**
     * objects常用方法
     * 
     * @see com.google.common.base.Objects
     * @see com.google.common.collect.ComparisonChain
     * 
     * @author suwenguang
     * 
     * @date 2019/11/8
     */
    public void objects() {
        // 使用这个可以避免空指针
        boolean equal = Objects.equal(null, new TestModel());
        System.out.println(equal);

        // 手动hash,暂时还没找到使用场景,jdk自带可以满足
        TestModel testModel = new TestModel();
        int hashCode = Objects.hashCode(testModel.getStr1(), testModel.getStr2());
        System.out.println(hashCode);

        // toString, 无需覆盖object的toString方法即可输出
        // 但是有了lombok的支持, 这个有点鸡肋, 基本没用, 但是对于老代码还是有点用
        String toString = MoreObjects.toStringHelper("类名").add("随意", 12).toString();
        System.out.println(toString);

        // 比较器 compare/compareTo
        // ComparisonChain执行一种懒比较：它执行比较操作直至发现非零的结果，在那之后的比较输入将被忽略。
        TestModel now = new TestModel();
        now.setStr1("1");
        TestModel that = new TestModel();
        that.setStr1("2");
        int i = now.compareTo(that);
        System.out.println(i);

    }

    /**
     * 排序扩展的几种写法
     * 
     * @see java.util.Comparator
     * @see com.google.common.collect.Ordering
     * 
     * @author suwenguang
     * 
     * @date 2019/11/8
     */
    public void ordering() {
        // 自定义comparator

        // 使用 from 静态方法构建ordering实现比较方法

        // 自然排序, 数字先后, 日期先后
        Ordering<Comparable> natural = Ordering.natural();

        // 字符序列做字典排序
        Ordering<Object> objectOrdering = Ordering.usingToString();

        // 自定义比较器
        // compound方法, 是处理ordering中的相等的情况的再一次比较
        // reverse方法对compoud的排序器没有影响,只是对当前的链路做一次反转, 注意虽然是链式操作,但是对象并不是相同.
        natural.onResultOf((Function<TestModel, String>) input -> {
            input = MoreObjects.firstNonNull(input, new TestModel());
            return MoreObjects.firstNonNull(input.getStr1(), "");
        });
        natural.compound(new Str2Comprator());

        ArrayList<TestModel> testModels = new ArrayList<>();
        TestModel e = new TestModel();
        e.setStr1("1");
        testModels.add(e);

        e = new TestModel();
        e.setStr1("4");
        e.setStr2("2");
        testModels.add(e);

        e = new TestModel();
        e.setStr1("2");
        e.setStr2("3");
        testModels.add(e);

        e = new TestModel();
        e.setStr1("2");
        e.setStr2("4");
        testModels.add(e);

        Ordering<Comparable> reverse = natural.reverse();
        System.out.println(natural.isOrdered(testModels));

        List<TestModel> testModels1 = reverse.sortedCopy(testModels);
        System.out.println(natural.isOrdered(testModels));
        System.out.println(natural.isOrdered(testModels1));

    }
}
