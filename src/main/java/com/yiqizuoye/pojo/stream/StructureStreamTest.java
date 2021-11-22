package com.yiqizuoye.pojo.stream;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Description: 构建流
 *
 * @author :liukang07
 * @version :1.0
 * @date :2021/10/9 5:14 下午
 */

public class StructureStreamTest {

    @Test
    public void test_iterate() {
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void test_generate() {
        Stream<Double> limit = Stream.generate(Math::random)
                .limit(5);
        limit.forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
//        File file = new File("/Users/liukang07/Documents/temp/1");
//        boolean res = file.createNewFile();
//        if (!res) {
//            System.out.println("创建失败！");
//        }


        String strPath = "/Users/liukang07/Documents/temp/1.txt";
        File file = new File(strPath);
        File fileParent = file.getParentFile();
        if(!fileParent.exists()){
            fileParent.mkdirs();
        }
        File tempFile = File.createTempFile(strPath, ".txt");
        System.out.println(tempFile);
    }
}
