package com.wondersgroup.commons.util.demo.designMode.mode2;

import com.wondersgroup.commons.util.demo.designMode.mode2.impl.HuiNoodles;
import com.wondersgroup.commons.util.demo.designMode.mode2.impl.LzNoodles;
import com.wondersgroup.commons.util.demo.designMode.mode2.impl.PaoNoodles;

/**
 * 面馆工厂类
 *    工厂模式定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个，也就是说工厂方法模式让实例化推迟到子类。
 *优点
 *         ①一个调用者想创建一个对象，只要知道其名称就可以了。
 *         ②扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。
 *         ③屏蔽产品的具体实现，调用者只关心产品的接口。
 * 缺点
 *         每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数成倍增加，在一定 程度上增加了系统的复杂度，同时也增加了系统具体类的依赖。
 * @author tangjunlin
 * @date 2022/12/13 11:29
 */
public class SimpleNoodlesFactory {
    public static final int TYPE_LZ = 1;//兰州拉面
    public static final int TYPE_PM = 2;//泡面
    public static final int TYPE_HM = 3;//烩面

    private static MianTiao creatNoodles(int type) {
        switch (type) {
            case TYPE_LZ:
                return new LzNoodles();
            case TYPE_PM:
                return new PaoNoodles();
            case TYPE_HM:
            default:
                return new HuiNoodles();
        }
    }

    public static void main(String[] args) {
        MianTiao mianTiao = SimpleNoodlesFactory.creatNoodles(TYPE_HM);
        mianTiao.desc();
    }
}
