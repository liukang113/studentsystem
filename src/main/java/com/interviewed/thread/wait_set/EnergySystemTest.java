package com.interviewed.thread.wait_set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: kang.liu
 * Date  : 2019/3/10 5:59 PM
 * Email :bjwlliuakng@163.com
 * Description:This is a simple class
 */
public class EnergySystemTest {
    public static final int BOX_AMOUNT = 100;
    public static final double INITAL_ENERGY = 1000.0;

    public static void main(String[] args) {
        // 初始化能量系统
        EnergySystem energySystem = new EnergySystem(BOX_AMOUNT, INITAL_ENERGY);
        // 调用能量转移任务
        for (int i = 0; i < BOX_AMOUNT; i++) {
            EnergyTransForTask transForTask = new EnergyTransForTask(energySystem, i, INITAL_ENERGY);
            Thread t = new Thread(transForTask, "TransferThread_" + i);
            t.start();
        }

    }
}
