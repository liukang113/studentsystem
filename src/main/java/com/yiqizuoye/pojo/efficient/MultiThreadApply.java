package com.yiqizuoye.pojo.efficient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.google.common.collect.Lists;
import com.yiqizuoye.pojo.classloader.TestDiffClassLoader;

import lombok.AllArgsConstructor;

/**
 * Description: 多线程应用测试
 *
 * @author :liukang07
 * @version :1.0
 * @date :2022/3/1 7:50 下午
 */
public class MultiThreadApply {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestDiffClassLoader.class);

    private static final Map<Integer, String> TEST = new HashMap<Integer, String>() {{
        put(1, "one");
        put(2, "two");
        put(3, "three");
        put(4, "four");
        put(5, "five");
        put(6, "");
    }};

    public static void main(String[] args) {
        System.out.println("start....");
        executeTask(TEST);
        System.out.println("end ....");
    }

    private static void executeTask(Map<Integer, String> test) {
        @AllArgsConstructor
        class ComputeTask implements Callable<String> {
            private Integer id;
            private String name;

            @Override
            public String call() {
                return printInfos(name, id);
            }
        }
        List<ComputeTask> tasks = Lists.newArrayList();
        test.keySet().forEach(id -> tasks.add(new ComputeTask(id, test.get(id))));

        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(test.keySet().size());
            List<Future<String>> futures = null;
            try {
                futures = executorService.invokeAll(tasks, 3000000, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                LOGGER.error("[executeTask] recommend get docIds  exception: {}", e.getMessage());
            }
            if (futures != null) {
                for (Future<String> future : futures) {
                    try {
                        if (!future.isCancelled()) {
                            String infos = future.get();
                            if (StringUtils.isEmpty(infos)) {
                                infos = "这是一条 test 数据";
                            }
                            System.out.println(infos);
                        } else {
                            LOGGER.warn("[executeTask] athena get qid info res thread was cancelled");
                        }
                    } catch (Exception e) {
                        LOGGER.error("[executeTask] athena get qid info res thread exception: {}", e);
                    }
                }
            }
        } catch (Exception e) {

        } finally {
            if (executorService != null) {
                try {
                    executorService.shutdownNow();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    /**
     * 打印人信息
     *
     * @param name 的名字
     * @param id   id
     * @return {@link Integer}
     */
    private static String printInfos(String name, Integer id) {
        return "编号number = " + id + " and  姓名name = " + name;
    }
}
