package com.wondersgroup.commons.util.demo.designMode.mode2;

/**
 * 工厂模式中的
 * 工厂方法模式
 *
 * @author tangjunlin
 * @date 2022/12/16 16:53
 */
public class FunctionFactory {

    public static interface Animal{
        public void desc();
    }
    public static class Cat implements Animal {
        public  void desc(){
            System.out.println("我是一只猫");
        }
    }
    public static class Dog implements Animal {
        public   void desc(){
            System.out.println("我是一只狗");
        }
    }
    /**
     * 工厂接口
     */
    public static interface AnimalFactory {
        Animal createAnimal();
    }

    /**
     * 小猫实现
     */
    public static class CatFactory implements AnimalFactory {
        @Override
        public Animal createAnimal() {
            Cat cat = new Cat();
            //一系列复杂操作
            return cat;
        }
    }

    /**
     * 小狗实现
     */
    public static class DogFactory implements AnimalFactory {
        @Override
        public Animal createAnimal() {
            Dog dog = new Dog();
            //一系列复杂操作
            return dog;
        }
    }

    public static void main(String[] args) {
        AnimalFactory animalFactory = new CatFactory();
        Animal cat = animalFactory.createAnimal();
        cat.desc();
    }

}
