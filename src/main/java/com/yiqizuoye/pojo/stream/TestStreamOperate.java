package com.yiqizuoye.pojo.stream;

import com.google.common.collect.Lists;
import com.yiqizuoye.pojo.stream.entity.Transaction;
import com.yiqizuoye.pojo.stream.enums.TransactEnum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/3/16 14:14
 * Description:
 * Stream 作为 Java 8 的一大亮点，它与 java.io 包里的 InputStream 和 OutputStream 是完全不同的概念。
 * 它也不同于 StAX 对 XML 解析的 Stream，也不是 Amazon Kinesis 对大数据实时处理的 Stream。Java 8 中
 * 的 Stream 是对集合（Collection）对象功能的增强，它专注于对集合对象进行各种非常便利、高效的聚合操
 * 作（aggregate operation），或者大批量数据操作 (bulk data operation)。Stream API 借助于同样新出
 * 现的 Lambda 表达式，极大的提高编程效率和程序可读性。同时它提供串行和并行两种模式进行汇聚操作，并
 * 发模式能够充分利用多核处理器的优势，使用 fork/join 并行方式来拆分任务和加速处理过程。通常编写并
 * 行代码很难而且容易出错, 但使用 Stream API 无需编写一行多线程的代码，就可以很方便地写出高性能的
 * 并发程序。所以说，Java 8 中首次出现的 java.util.stream 是一个函数式语言+多核时代综合影响的产物。
 */
public class TestStreamOperate {

    public static void main(String[] args) {
        List<Transaction> list = initListCollection();
        System.out.println(list);
        /**  使用Stream 操作 ： 并行化流 */
        List<Long> collect = list.parallelStream().
                distinct().
                filter(Objects::nonNull).
                filter(data -> data.getType() == TransactEnum.BLANK).
                sorted(Comparator.comparing(Transaction::getValue).reversed()).
                map(Transaction::getId).
                collect(Collectors.toList());
        System.out.println(collect);
        Transaction collect1= list.parallelStream().collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Transaction::getSaleCount)),Optional::get) );
        System.out.println("==============================================>"+collect1.getSaleCount());


        // 常见的流操作
        System.out.println("=========构造流的几种常见方法 =============");
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");
        // 2. Arrays
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        // 3. Collections
        List<String> list1 = Arrays.asList(strArray);
        stream = list1.stream();

        // 数值流的构造
        System.out.println("==========数值流的构造 ==============");
        IntStream.of(new int[]{1, 2, 3, 4, 5, 6, 7}).forEach(System.out::println);
        // 不包括上限
        IntStream.range(1, 3).forEach(System.out::println);
        // 包括上限
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

        System.out.println("=========flatMap 操作 将input stream 中的层级结构扁平化======");
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6));
        List<Integer> flatMap = inputStream.
                flatMap((childList) -> childList.stream()).collect(Collectors.toList());
        System.out.println(flatMap);
        System.out.println("======filter 操作============");
        Integer[] data = {1, 2, 34, 4, 666, 343};

        Integer[] result = Stream.of(data).
                filter(integer -> integer % 2 == 0).
                sorted(Comparator.comparing(Integer::intValue).reversed()).toArray(Integer[]::new);
        Arrays.asList(result).forEach(System.out::println);
        System.out.println("=============peek 操作 ===========");
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        /**  stream的多个操作 */
        List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        System.out.println("==============================stream的多级操作 ");
        System.out.println("sum is:" + nums.stream().filter(num -> num != null).
                distinct().mapToInt(num -> num * 2).
                peek(System.out::println).skip(2).limit(4).sum());
    }

    private static List<Transaction> initListCollection() {
        List<Transaction> list = Lists.newArrayList();
        list.add(new Transaction(ProfileUtil.getAtomicCounter(), (int) (Math.random() * 100) % 100, UUID.randomUUID().toString().replace("-", "").substring(0, 12), TransactEnum.BLANK, (int) (Math.random() * 100) % 100));
        list.add(new Transaction(ProfileUtil.getAtomicCounter(), (int) (Math.random() * 100) % 100, UUID.randomUUID().toString().replace("-", "").substring(0, 12), TransactEnum.RED, (int) (Math.random() * 100) % 100));
        list.add(new Transaction(ProfileUtil.getAtomicCounter(), (int) (Math.random() * 100) % 100, UUID.randomUUID().toString().replace("-", "").substring(0, 12), TransactEnum.YELLOW, (int) (Math.random() * 100) % 100));
        list.add(new Transaction(ProfileUtil.getAtomicCounter(), (int) (Math.random() * 100) % 100, UUID.randomUUID().toString().replace("-", "").substring(0, 12), TransactEnum.GREEN, (int) (Math.random() * 100) % 100));
        list.add(new Transaction(ProfileUtil.getAtomicCounter(), (int) (Math.random() * 100) % 100, UUID.randomUUID().toString().replace("-", "").substring(0, 12), TransactEnum.RED, (int) (Math.random() * 100) % 100));
        list.add(new Transaction(ProfileUtil.getAtomicCounter(), (int) (Math.random() * 100) % 100, UUID.randomUUID().toString().replace("-", "").substring(0, 12), TransactEnum.BLANK, (int) (Math.random() * 100) % 100));
        list.add(new Transaction(ProfileUtil.getAtomicCounter(), (int) (Math.random() * 100) % 100, UUID.randomUUID().toString().replace("-", "").substring(0, 12), TransactEnum.BLANK, (int) (Math.random() * 100) % 100));
        return list;
    }
}