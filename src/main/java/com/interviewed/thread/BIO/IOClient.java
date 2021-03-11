package com.interviewed.thread.BIO;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */
public class IOClient {

    public static int COUNTER = 10;

    public static void main(String[] args) {

        while (COUNTER < 1) {
            new Thread(() -> {
                try {
                    Socket socket = new Socket("127.0.0.1", 3333);
                    socket.getOutputStream().write((new Date() + "   hello word").getBytes());
                    Thread.sleep(2000);
                    System.out.println("已经发送消息成功！！！");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {

                }
            }).start();
            COUNTER--;
        }
    }
}
