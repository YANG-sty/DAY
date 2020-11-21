package com.sys.testMy;

import org.junit.Test;

/**
 * 数据类型强转
 * @author y_zzu 2020-10-28-15:50
 */
public class StrongTransaction {


    @Test
    public void test1() {
        int a = 123;
        String b = "23";
        Double ab = 1.234;
        System.out.println(a);
        System.out.println(ab);
        boolean boo = false;
        String s = String.valueOf(boo);
        System.out.println(s);

    }

    /**
     * 多态
     * 1.继承
     * 2.重写方法
     * 3.父类引用指向子类对象
     */
    @Test
    public void test2() {
//        show(new Cat());  // 以 Cat 对象调用 show 方法
//        show(new Dog());  // 以 Dog 对象调用 show 方法

       /* Animal a = new Cat();  // 向上转型
        a.eat();               // 调用的是 Cat 的 eat
        Cat c = (Cat)a;        // 向下转型
        c.work();        // 调用的是 Cat 的 work*/

        Cat cat = new Cat();
        cat.eat();
        cat.work();
        //父类引用指向子类对象
        Animal animal = cat;
        animal.eat();
        //父类强转为子类（父类引用要执行子类对象）
        Cat catb = (Cat) animal;
        catb.eat();
        catb.work();


        Animal a = new Animal() {
            @Override
            void eat() {
                System.out.println("new animal");
            }
        };

        a.eat();

        //a StrongTransaction$1 标记为 1 无法强转为 cat, 父类对象没有指向子类的情况，是不允许进行强转的
        Cat acat = (Cat) a;
        acat.eat();
        acat.work();

        //animal StrongTransaction$Cat 标记为 cat 无法强转为 dog
        Dog dog = (Dog) animal;
        dog.eat();
        dog.work();
    }

    public static void show(Animal a)  {
        a.eat();
        // 类型判断
        if (a instanceof Cat)  {  // 猫做的事情
            Cat c = (Cat)a;
            c.work();
        } else if (a instanceof Dog) { // 狗做的事情
            Dog c = (Dog)a;
            c.work();
        }
    }


    abstract class Animal {
        abstract void eat();
    }

    class Cat extends Animal {
        @Override
        public void eat() {
            System.out.println("吃鱼");
        }
        public void work() {
            System.out.println("抓老鼠");
        }
    }

    class Dog extends Animal {
        @Override
        public void eat() {
            System.out.println("吃骨头");
        }
        public void work() {
            System.out.println("看家");
        }
    }






}
