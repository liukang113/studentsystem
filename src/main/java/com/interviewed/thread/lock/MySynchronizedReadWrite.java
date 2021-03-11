package com.interviewed.thread.lock;

public class MySynchronizedReadWrite {
    
    public static void main(String[] args)  {
        final MySynchronizedReadWrite test = new MySynchronizedReadWrite();
         
        new Thread(){
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();
         
        new Thread(){
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();
         
    }  
     
    public synchronized void get(Thread thread) {
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis() - start <= 1) {
            System.out.println(thread.getName()+"正在进行读操作");
        }
        System.out.println(thread.getName()+"读操作完毕");
    }

}
