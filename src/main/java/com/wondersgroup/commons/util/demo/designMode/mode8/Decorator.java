package com.wondersgroup.commons.util.demo.designMode.mode8;

/**
 * 装饰模式
 * 是用来替代继承的一种设计模式。它通过一种无须定义子类的方式来给对象动态增加职责，使用对象之间的关联关系取代类之间的继承关系。降低了系统的耦合，可以动态的增加或者删除对象的职责。
 *   2、优点
 *         ①对于扩张一个对象的功能，装饰模式比继承模式更加灵活，不会导致类的数量急剧增加。
 *         ②可以通过一种动态的方式扩张一个类的功能，同过配置文件可以在运行时进行选择，不同的装饰类。
 *         ③ 可以对一个对象进行多次装饰，通过使用不同的具体装饰类以及这些装饰类的排列组合可以创造不同的行为的组合。
 *         3、缺点
 *         ① 在使用装饰模式的时候进行系统设计时会产生很多小对象，这些对象的区别在于他们之间相互连接 的方式有所不同，而不是他们的类或者属性值有所不同，大量小对象势必产生一大部分的系统资源开销，影响系统性能。
 *         ②装饰模式是一种比继承更加灵活的解决方案。但同时，也意味着比继承更加容易出错，更加难排长。对于多层装饰的对象，需要逐级排查，较为繁琐。
 * @author tangjunlin
 * @date 2022/12/16 13:47
 */
public class Decorator {
    public static abstract class Person{
        public abstract void dressed();
    }

    public static class Calvin extends Person{
        @Override
        public void dressed() {
            System.out.println("穿件内裤");
        }
    }

    public static abstract class PersonCloth extends Person{
        Person myPerson;

        public PersonCloth(Person myPerson) {
            this.myPerson = myPerson;
        }

        @Override
        public void dressed() {
            myPerson.dressed();
        }
    }

    public static class SummerCloth extends PersonCloth{

        public SummerCloth(Person myPerson) {
            super(myPerson);
        }

        @Override
        public void dressed() {
            super.dressed();
            System.out.println("穿件短裤");
        }
    }

    public static class WinterCloth extends PersonCloth{

        public WinterCloth(Person myPerson) {
            super(myPerson);
        }

        @Override
        public void dressed() {
            super.dressed();
            System.out.println("穿件毛裤");
        }
    }

    public static void main(String[] args) {
        Person calvin = new Calvin();
        PersonCloth summerCloth = new SummerCloth(calvin);
        PersonCloth winterCloth = new WinterCloth(calvin);
        summerCloth.dressed();
        winterCloth.dressed();

        PersonCloth summerCloth2 = new SummerCloth(winterCloth);
        summerCloth2.dressed();
    }

}

