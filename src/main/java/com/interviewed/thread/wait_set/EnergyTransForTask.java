package com.interviewed.thread.wait_set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: kang.liu
 * Date  : 2019/3/10 6:07 PM
 * Email :bjwlliuakng@163.com
 * Description:This is a simple class
 */
public class EnergyTransForTask implements Runnable{
    /**
     * share 共享资源
     */
    private EnergySystem energySystem;
    /**
     * 能量盒子下标
     */
    private int fromBox;
    /**
     * 单次最大转移能量
     */
    private double maxElement;
    /**
     * 延时时间
     */
    private int DELAY = 10;

    public EnergyTransForTask(EnergySystem energySystem, int fromBox, double maxElement) {
        this.energySystem = energySystem;
        this.fromBox = fromBox;
        this.maxElement = maxElement;
    }


    @Override
    public void run() {
        try {
            while(true){
                int toBox = (int)(energySystem.getBoxMount() * Math.random());
                double amount = maxElement * Math.random();
                energySystem.transfer(fromBox,toBox, amount);
                Thread.sleep((int) (DELAY * Math.random()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
