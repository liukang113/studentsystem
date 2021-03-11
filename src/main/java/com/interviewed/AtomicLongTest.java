package com.interviewed;

import com.sun.tools.internal.jxc.SchemaGenerator;
import jdk.nashorn.internal.runtime.options.Options;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * ${DESCRIPTION}
 *
 * @author : liukang
 * @date :2020-09-02 22:15
 **/
public class AtomicLongTest {
    private static AtomicLong count = new AtomicLong();
    private static LongAdder longAdder = new LongAdder();

   /* public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder().include(AtomicLongTest.class.getName()).forks(1).build();
        new SchemaGenerator.Runner(options).run();
    }

    @Benchmark
    @Threads(10)
    public void run0(){
        count.getAndIncrement();
    }

    @Benchmark
    @Threads(10)
    public void run1(){
        longAdder.increment();
    }*/
}
