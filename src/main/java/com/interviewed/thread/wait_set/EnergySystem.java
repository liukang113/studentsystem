package com.interviewed.thread.wait_set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: kang.liu
 * Date  : 2019/3/10 5:55 PM
 * Email :bjwlliuakng@163.com
 * Description:This is a simple class
 * <p>
 * Wait Set
 *     当一个线程获得锁资源进入临界区执行某项操作时，发现某些条件不满足导致该线程无法继续执行，
 * 则调用wait()方法，然后该线程会释放锁资源，并且进入锁对象的Wait-Set,
 * 由于锁资源被释放，则其他线程可以获取锁资源进入临界区完成操作，当操作完毕，
 * 调用notify(),notifuAll()方法，对WaitSet中的线程进行唤醒,等待的线程重新  获取锁进入临界区执行.
 * <p>
 */
public class EnergySystem {


    /**
     * 能量盒子，能量存储的地方
     */
    private final double[] energyBoxes;

    private final Object lockObj = new Object();

    /**
     * 能量总值
     *
     * @param n            能量盒子的数量
     * @param initalEnergy 每个能量盒子初始含有的能量值
     */
    public EnergySystem(int n, double initalEnergy) {
        energyBoxes = new double[n];
        for (int i = 0; i < energyBoxes.length; i++) {
            energyBoxes[i] = initalEnergy;
        }
    }

    public int getBoxMount() {
        return energyBoxes.length;
    }

    public void transfer(int fromBox, int toBox, double amount) {
        synchronized (lockObj) {
            // 能量转出的单元能量不足时，终止本次操作
//            if (energyBoxes[fromBox] < amount) {
//                return;
//            }
            while (energyBoxes[fromBox] < amount) {
                try {
                    // 当临界资源不够时，线程会调用锁对象上的wait(),此时该线程将释放锁资源，进去锁对象上的wait-set集合中
                    lockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(Thread.currentThread().getName());
            energyBoxes[fromBox] -= amount;
            // System.out.printf(),java对应格式输出
            System.out.printf("从%d转移%10.2f单位能量到%d", fromBox, amount, toBox);
            energyBoxes[toBox] += amount;
            System.out.printf("能量总和:%10.2f%n", getTotalEnergies());
            // 当前线程执行完任务后，调用notify或者notifyAll去唤醒锁资源上等待区域的线程，去竞争CPU资源
            lockObj.notifyAll();
        }

    }

    /**
     * 返回能量盒子能量的总和
     *
     * @return
     */
    public double getTotalEnergies() {
        double sum = 0;
        for (double amount : energyBoxes) {
            sum += amount;
        }
        return sum;
    }
}

